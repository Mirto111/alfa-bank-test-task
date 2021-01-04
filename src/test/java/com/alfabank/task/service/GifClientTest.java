package com.alfabank.task.service;

import com.alfabank.task.model.Gif;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GifClientTest {

    @MockBean
    private GifClient gifService;

    @Test
    void getRandomGif() {
        Gif gif = new Gif("title","gifurl");
        Mockito.when(gifService.getRandomGif("rich")).thenReturn(gif);
        Gif expect = gifService.getRandomGif("rich");
        assertEquals(expect, gif);
    }
}