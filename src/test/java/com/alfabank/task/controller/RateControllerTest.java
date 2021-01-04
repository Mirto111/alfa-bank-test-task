package com.alfabank.task.controller;

import com.alfabank.task.model.Currency;
import com.alfabank.task.model.Gif;
import com.alfabank.task.service.GifClient;
import com.alfabank.task.service.RateClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(RateController.class)
class RateControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RateClient rateService;
    @MockBean
    private GifClient gifService;

    @Test
    void getGif() throws Exception {
        Currency curDay = new Currency("USD", 71.55, LocalDate.now());
        Currency prevDay = new Currency("USD", 70.70, LocalDate.now().minusDays(1));
        Gif gif = new Gif("richgif", "url-ref");
        Mockito.when(rateService.getLatestRate("USD")).thenReturn(curDay);
        Mockito.when(rateService.getPrevDayRate("USD")).thenReturn(prevDay);
        Mockito.when(gifService.getRandomGif("rich")).thenReturn(gif);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/rate/USD"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}