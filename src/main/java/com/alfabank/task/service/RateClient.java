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

    @Value("${openexchangerates_api_key}")
    private String apiKey;
    @Value("${symbols}")
    private String symbol;
    @Value("${openexchangerates_url}")
    private String url;

    private final RateService rateService = Feign.builder()
            .client(new OkHttpClient())
            .decoder(new JacksonDecoder())
            .target(RateService.class, url);

    public Currency getLatestRate(String code) {
        return rateService.getLatestRate(apiKey, symbol, code);
    }

    public Currency getPrevDayRate(String code) {
        LocalDate date = LocalDate.now().minusDays(1);
        return rateService.getRateByDate(date.toString(), apiKey, symbol, code);
    }
}
