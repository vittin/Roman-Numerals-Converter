package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Created by Mateusz on 2016-07-15. */

@RestController
@RequestMapping("/api/convert")
public class ApiController {

    @Autowired
    RomanNumerals romanNumerals;

    @RequestMapping("/fromNumber/{number}")
    public ResponseEntity<String> fromNumber(@PathVariable int number){
        String result = romanNumerals.convert(number);
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @RequestMapping("/fromString/{string}")
    public ResponseEntity<String> fromString(@PathVariable String string){
        String input = string.toUpperCase();
        String result = "";
        if(romanNumerals.isValid(input)){
            int resultNumber = romanNumerals.convert(string);
            result = String.valueOf(resultNumber);

            String bestNumeral = romanNumerals.convert(resultNumber);
            if (!input.equals(bestNumeral)){
                String error = "Invalid numeral. Did you mean " + bestNumeral;
                HttpHeaders headers = new HttpHeaders();
                headers.set("bestNumeral", bestNumeral);
                return new ResponseEntity<>(error, headers, HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping("/detect/{input}")
    public ResponseEntity<String> detect(@PathVariable String input){
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return fromString(input);
        }
        return fromNumber(number);
    }
}
