package com.example.fizzbuzz;

import com.example.fizzbuzz.services.FizzBuzzService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ExtendWith(SpringExtension.class)
public class FizzBuzzControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FizzBuzzService fizzBuzzService;

    private List<Integer> actual = Arrays.asList(3,6,7,9);
    private List<String> result = Arrays.asList("fizz","fizz","Bazz","fizz");

    @Test
    void getEntry() throws Exception {
        when(fizzBuzzService.multipliedBy(actual)).thenReturn(result);
        mockMvc.perform(get("/fizzbuzz?entry=3,6,7,9"))
                .andExpect(status().isOk())
                .andExpect(content().json(String.valueOf(result)));
    }

    @Test
    void getEntry_withEmptyParam() throws Exception {
        List<Integer> range = IntStream.rangeClosed(1, 100)
                .boxed()
                .collect(Collectors.toList());
        when(fizzBuzzService.multipliedBy(range)).thenReturn(result);
        mockMvc.perform(get("/fizzbuzz?entry="))
                .andExpect(status().isOk())
                .andExpect(content().json(String.valueOf(result)));
    }

    @Test
    void getEntry_withoutParam() throws Exception {
        List<Integer> range = IntStream.rangeClosed(1, 100)
                .boxed()
                .collect(Collectors.toList());
        when(fizzBuzzService.multipliedBy(range)).thenReturn(result);
        mockMvc.perform(get("/fizzbuzz"))
                .andExpect(status().isOk())
                .andExpect(content().json(String.valueOf(result)));
    }

    @Test
    void getEntry_withStringParam() throws Exception {
        mockMvc.perform(get("/fizzbuzz?entry=a"))
                .andExpect(status().is4xxClientError());
    }
}
