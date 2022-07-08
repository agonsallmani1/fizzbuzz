package com.example.fizzbuzz.controllers;

import com.example.fizzbuzz.services.FizzBuzzService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class FizzBuzzController {

    private final FizzBuzzService fizzBuzzService;

    public FizzBuzzController(FizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    @ResponseBody
    @GetMapping("/fizzbuzz")
    public ResponseEntity<List<String>> getEntry(@RequestParam (value = "entry",required = false) List<Integer> entry){
        List<Integer> n;
        if(entry == null || entry.isEmpty()){
             entry = IntStream.rangeClosed(1, 100)
                    .boxed()
                    .collect(Collectors.toList());
        }
        return new ResponseEntity<>(fizzBuzzService.multipliedBy(entry), HttpStatus.OK);
    }
}
