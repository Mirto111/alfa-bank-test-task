package com.alfabank.task.service;

import com.alfabank.task.model.Gif;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.okhttp.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GifClient {

    @Value("${giphy.api_key}")
    private String apiKey;
    @Value("${giphy.url}")
    private String gitUrl;

    private static <T> T createClient(Class<T> type, String uri) {
        return Feign.builder()
                .client(new OkHttpClient())
                .decoder(new JacksonDecoder())
                .target(type, uri);
    }

    public Gif getRandomGif(String tag) {
        return createClient(GifService.class, gitUrl).getRandomGifByTag(apiKey, tag);
    }
}
