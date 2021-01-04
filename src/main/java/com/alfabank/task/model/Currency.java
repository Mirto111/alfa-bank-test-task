package com.alfabank.task.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
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
    private BigDecimal rate;

    @JsonProperty("rates")
    private void unpackNameFromNestedObject(Map<String, BigDecimal> rates) {
        rate = rates.get("RUB");
    }
}
