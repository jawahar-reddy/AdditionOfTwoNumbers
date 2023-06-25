package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;  // Import statement for MediaType
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class AdditionOfTwoNumbersApplicationTests {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testAddNumbers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"num1\": 5, \"num2\": 10}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("15"));
    }
    
    @Test
    public void testAddNumbers_InvalidRequestBody() throws Exception {
        String invalidRequestBody = "{\"num1\": \"abc\", \"num2\": 3}";

        mockMvc.perform(MockMvcRequestBuilders.post("/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidRequestBody))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    
    @Test
    public void testAddNumbers_MissingRequestBody() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/add")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }


}
