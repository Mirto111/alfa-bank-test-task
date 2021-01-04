package com.alfabank.task.controller;

import com.alfabank.task.model.Currency;
import com.alfabank.task.model.Gif;
import com.alfabank.task.service.GifClient;
import com.alfabank.task.service.RateClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rate/")
public class RateController {

    private final RateClient rateService;
    private final GifClient gifService;

    public RateController(RateClient rateService, GifClient gifService) {
        this.rateService = rateService;
        this.gifService = gifService;
    }

    @GetMapping(value = "/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getGif(@PathVariable String code) {
        Currency rateNow = rateService.getLatestRate(code);
        Currency ratePrevDay = rateService.getPrevDayRate(code);
        String tag = "";
        if (rateNow.getRate() > ratePrevDay.getRate()) {
            tag = "rich";
        } else if (rateNow.getRate() < ratePrevDay.getRate()) {
            tag = "broke";
        } else {
            return "Курс не изменился";
        }
        Gif gif = gifService.getRandomGif(tag);

        return gif.getUri();
    }
}
