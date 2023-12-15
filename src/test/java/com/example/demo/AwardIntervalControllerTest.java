package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AwardIntervalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetIntervals() throws Exception {
        mockMvc.perform(get("/api/awards/intervals"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.min", hasSize(greaterThanOrEqualTo(1))))
            .andExpect(jsonPath("$.max", hasSize(greaterThanOrEqualTo(1))))

            .andExpect(jsonPath("$.min[0].producer", is("Bo Derek")))
            .andExpect(jsonPath("$.min[0].interval", is(6)))
            .andExpect(jsonPath("$.min[0].previousWin", is(1984)))
            .andExpect(jsonPath("$.min[0].followingWin", is(1990)))

            .andExpect(jsonPath("$.max[0].producer", is("Bo Derek")))
            .andExpect(jsonPath("$.max[0].interval", is(6)))
            .andExpect(jsonPath("$.max[0].previousWin", is(1984)))
            .andExpect(jsonPath("$.max[0].followingWin", is(1990)));
    }
}
