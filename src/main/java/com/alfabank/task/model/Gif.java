package com.alfabank.task.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Gif {
    private String title;
    private String uri;

    @JsonProperty("data")
    private void unpackNameFromNestedObject(Map<String, Object> data) {
        this.title = (String) data.get("title");
        this.uri = (String) data.get("image_url");
    }
}
