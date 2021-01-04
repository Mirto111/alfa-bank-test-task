package com.alfabank.task.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Currency {
    private String base;
    private double rate;
    private LocalDate date;

    @JsonProperty("rates")
    private void unpackNameFromNestedObject(Map<String, Double> rates) {
        rate = rates.get("RUB");
    }

    @JsonProperty("timestamp")
    private void unpackNameFromNestedObject(Long timestamp) {
        date = Instant.ofEpochSecond(timestamp).atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
