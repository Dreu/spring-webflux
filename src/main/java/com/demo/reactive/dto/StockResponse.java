package com.demo.reactive.dto;

import com.demo.reactive.model.Stock;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockResponse {

    private String id;
    @JsonProperty("stockName")
    private String name;
    private BigDecimal price;
    private String currency;

    public static StockResponse fromModel(Stock stock) {
        return StockResponse.builder()
            .id(stock.getId())
            .name(stock.getName())
            .price(stock.getPrice())
            .currency(stock.getCurrency())
            .build();
    }
}
