package com.alfabank.task.service;

import com.alfabank.task.model.Gif;
import feign.Param;
import feign.RequestLine;

public interface GifService {
    @RequestLine("GET ?api_key={api_key}&tag={tag}")
    Gif getRandomGifByTag(@Param("api_key") String apiKey, @Param("tag") String tag);
}
