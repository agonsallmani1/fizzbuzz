package com.example.fizzbuzz;

import com.example.fizzbuzz.services.FizzBuzzService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class FizzBuzzServiceTest {

    @Autowired
    private FizzBuzzService service;


    @Test
    void multiplied_by_3(){
        List<Integer> actual = Arrays.asList(3,6,9);
        List<String> expected = Arrays.asList("fizz","fizz","fizz");
        assertThat(service.multipliedBy(actual)).isEqualTo(expected);
    }

    @Test
    void multiplied_by_5(){
        List<Integer> actual = Arrays.asList(5,10);
        List<String> expected = Arrays.asList("buzz","buzz");
        assertThat(service.multipliedBy(actual)).isEqualTo(expected);
    }

    @Test
    void multiplied_by_3_and_5(){
        List<Integer> actual = Arrays.asList(15,30,45);
        List<String> expected = Arrays.asList("fizzbuzz","fizzbuzz","fizzbuzz");
        assertThat(service.multipliedBy(actual)).isEqualTo(expected);
    }

    @Test
    void multiplied_by_7(){
        List<Integer> actual = Arrays.asList(7,14);
        List<String> expected = Arrays.asList("Bazz","Bazz");
        assertThat(service.multipliedBy(actual)).isEqualTo(expected);
    }

    @Test
    void multiplied_by_3_and_7(){
        List<Integer> actual = Arrays.asList(21,42);
        List<String> expected = Arrays.asList("FizzBazz","FizzBazz");
        assertThat(service.multipliedBy(actual)).isEqualTo(expected);
    }

    @Test
    void multiplied_by_5_and_7(){
        List<Integer> actual = Arrays.asList(35,70);
        List<String> expected = Arrays.asList("BuzzBazz","BuzzBazz");
        assertThat(service.multipliedBy(actual)).isEqualTo(expected);
    }

    @Test
    void multiplied_by_3_and_5_and_7(){
        List<Integer> actual = Arrays.asList(105,210);
        List<String> expected = Arrays.asList("FizzBuzzBazz","FizzBuzzBazz");
        assertThat(service.multipliedBy(actual)).isEqualTo(expected);
    }

    @Test
    void multiply_by_range(){
        List<Integer> actual = IntStream.rangeClosed(1, 100)
                .boxed()
                .collect(Collectors.toList());
        List<String> result = Arrays.asList("1", "2", "fizz", "4", "buzz", "fizz", "Bazz", "8", "fizz", "buzz", "11", "fizz", "13", "Bazz", "fizzbuzz",
                "16", "17", "fizz", "19", "buzz", "FizzBazz", "22", "23", "fizz", "buzz", "26", "fizz", "Bazz", "29", "fizzbuzz", "31", "32", "fizz",
                "34", "BuzzBazz", "fizz", "37", "38", "fizz", "buzz", "41", "FizzBazz", "43", "44", "fizzbuzz", "46", "47", "fizz", "Bazz", "buzz",
                "fizz", "52", "53", "fizz", "buzz", "Bazz", "fizz", "58", "59", "fizzbuzz", "61", "62", "FizzBazz", "64", "buzz", "fizz", "67", "68",
                "fizz", "BuzzBazz", "71", "fizz", "73", "74", "fizzbuzz", "76", "Bazz", "fizz", "79", "buzz", "fizz", "82", "83", "FizzBazz",
                "buzz", "86", "fizz", "88", "89", "fizzbuzz", "Bazz", "92", "fizz", "94", "buzz", "fizz", "97", "Bazz", "fizz", "buzz");

        assertThat(service.multipliedBy(actual)).isEqualTo(result);
    }

}
