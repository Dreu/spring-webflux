package com.demo.reactive.model;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Stock {
    private String id;
    private String name;
    private BigDecimal price;
    private String currency;
}
