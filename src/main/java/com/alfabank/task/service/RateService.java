package com.alfabank.task.service;

import com.alfabank.task.model.Currency;
import feign.Param;
import feign.RequestLine;


public interface RateService {

    @RequestLine("GET /latest.json?app_id={app_id}&symbols={symbols}&base={base}")
    Currency getLatestRate(@Param("app_id") String appId,
                           @Param("symbols") String symbol,
                           @Param("base") String base);

    @RequestLine("GET /historical/{date}.json?app_id={app_id}&symbols={symbols}&base={base}")
    Currency getRateByDate(@Param("date") String date,
                           @Param("app_id") String appId,
                           @Param("symbols") String symbol,
                           @Param("base") String base);
}
