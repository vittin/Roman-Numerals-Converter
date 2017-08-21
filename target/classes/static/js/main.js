/**
 * Created by mati on 2016-07-15.
 */
$(document).on("ready", function(){
    enableKeyEvent();
});

function enableKeyEvent(){
    var inputBox = $("#inputNumber");
    inputBox.on("keyup", function(){
        sendRequest(inputBox.val());
    })
}

function sendRequest(inputValue){
    var convertType = $( "input:checked" ).val();
    switch (convertType){
        case "fromString":
            convert.fromString(inputValue);
            break;
        case "fromNumber":
            convert.fromNumber(inputValue);
            break;
        default: convert.unknownType(inputValue);
    }
}

var convert = {

    fromNumber: function(userInput){
        $.get("api/convert/fromNumber/" + userInput)
            .done(function(response){
                showResults(response);
            })
    },

    fromString: function(userInput){
        $.get("api/convert/fromString/" + userInput)
            .done(function(response){
                showResults(response);
            })
            .fail(function(response){
                handleBadRequest(response);
            });
    },

    unknownType: function(userInput){
        $.get("api/convert/detect/" + userInput)
            .done(function(response){
                showResults(response);
            })
            .fail(function(response){
                handleBadRequest(response);
            });
    }

};

function showResults(response){
    console.log(response);
    $("#info").show();
    $("#result").text(response);
}

function handleBadRequest(response){
    if (response.status == 400){
        $("#info").hide();

        var result = $("#result");
        result.text("");
        result.append("<a href='#' class='repairLink'>"+response.responseText+"</a>");

        enableRepairLink(response.getResponseHeader("bestNumeral"));
    }
}

function enableRepairLink(bestNumeral){
    var link = $(".repairLink");
    link.on("click", function(){
        console.log("hi"+bestNumeral);
        var numeral = link.attr("data-numeral");
        $("#inputNumber").val(bestNumeral);
        convert.fromString(bestNumeral);
        link.unbind();
    });

}