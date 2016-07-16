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
    },

    unknownType: function(userInput){
        $.get("api/convert/detect/" + userInput)
            .done(function(response){
                showResults(response);
            })
    }

};

function showResults(response){
    console.log(response);
    $("#result").text(response);
}