package com.example.fizzbuzz.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FizzBuzzServiceImpl implements FizzBuzzService{


    @Override
    public List<String> multipliedBy(List<Integer> numbers) {
        List<String> result = new ArrayList<>();
        for (Integer i : numbers){
            result.add(calculate(i));
        }
        return result;
    }

    private String calculate(int number) {
        StringBuilder sb = new StringBuilder();
        if (number % 7 == 0){
            sb.append(number % 3 == 0 ? "Fizz" : "");
            sb.append(number % 5 == 0 ? "Buzz" : "");
            sb.append("Bazz");
        }else {
            sb.append(number % 3 == 0 ? "fizz" : "");
            sb.append(number % 5 == 0 ? "buzz" : "");
        }

        return sb.length() == 0 ? String.valueOf(number) : sb.toString();
    }
}
