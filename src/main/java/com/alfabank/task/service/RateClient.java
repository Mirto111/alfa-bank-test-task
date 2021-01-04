package com.alfabank.task.service;

import com.alfabank.task.model.Currency;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.okhttp.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class RateClient {

    @Value("${openexchangerates.api_key}")
    private String apiKey;
    @Value("${symbols}")
    private String symbol;
    @Value("${openexchangerates.url}")
    private String openexUrl;

    private static <T> T createClient(Class<T> type, String uri) {
        return Feign.builder()
                .client(new OkHttpClient())
                .decoder(new JacksonDecoder())
                .target(type, uri);
    }

    public Currency getLatestRate(String code) {
        return createClient(RateService.class, openexUrl).getLatestRate(apiKey, symbol, code);
    }

    public Currency getPrevDayRate(String code) {
        LocalDate date = LocalDate.now().minusDays(1);
        return createClient(RateService.class, openexUrl).getRateByDate(date.toString(), apiKey, symbol, code);
    }
}
