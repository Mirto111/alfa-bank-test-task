package com.alfabank.task.service;

import com.alfabank.task.model.Gif;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.okhttp.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GifClient {

    @Value("${giphy_api_key}")
    private String apiKey;
    @Value("${giphy_url}")
    private String gitUrl;

    private final GifService gifClient = Feign.builder()
            .client(new OkHttpClient())
            .decoder(new JacksonDecoder())
            .target(GifService.class, gitUrl);

    public Gif getRandomGif(String tag) {
        return gifClient.getRandomGifByTag(apiKey, tag);
    }
}
