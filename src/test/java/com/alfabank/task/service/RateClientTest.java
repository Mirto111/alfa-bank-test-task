package com.alfabank.task.service;

import com.alfabank.task.model.Currency;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class RateClientTest {

    @MockBean
    private RateClient rateService;

    @Test
    void getLatestRate() {
        Currency expect = new Currency("USD", 70.55, LocalDate.now());
        Mockito.when(rateService.getLatestRate("USD")).thenReturn(expect);
        Currency actual = rateService.getLatestRate("USD");
        assertEquals(expect, actual);
    }

    @Test
    void getPrevDayRate() {
        Currency expect = new Currency("USD", 71.55, LocalDate.now().minusDays(1));
        Mockito.when(rateService.getPrevDayRate("USD")).thenReturn(expect);
        Currency actual = rateService.getPrevDayRate("USD");
        assertEquals(expect, actual);
    }
}