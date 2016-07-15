package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Created by Mateusz on 2016-07-15. */

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    RomanNumerals romanNumerals;

    @RequestMapping("/fromNumber/{number}")
    public String fromNumber(@PathVariable int number){
        String result = romanNumerals.convert(number);
        return result;
    }

    @RequestMapping("/fromString/{string}")
    public String fromString(@PathVariable String string){
        String result = "";
        if(romanNumerals.isValid("XVIII")){
            int resultNumber = romanNumerals.convert(string);
            result = String.valueOf(resultNumber);
        }
        return result;
    }

    @RequestMapping("/detect/{input}")
    public String fromNumber(@PathVariable String input){
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (ClassCastException stringToIntFailed) {
            return fromString(input);
        }
        return fromNumber(number);
    }
}
