package com.alfabank.task.service;

import com.alfabank.task.model.Currency;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class RateClientTest {

    @MockBean
    private RateClient rateClient;

    @Test
    void getLatestRate() {
        Currency expect = new Currency("USD", BigDecimal.valueOf(71.55));
        Mockito.when(rateClient.getLatestRate("USD")).thenReturn(expect);
        Currency actual = rateClient.getLatestRate("USD");
        assertEquals(expect, actual);
    }

    @Test
    void getPrevDayRate() {
        Currency expect = new Currency("USD", BigDecimal.valueOf(70.70));
        Mockito.when(rateClient.getPrevDayRate("USD")).thenReturn(expect);
        Currency actual = rateClient.getPrevDayRate("USD");
        assertEquals(expect, actual);
    }
}