package com.demo.reactive.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Stock {
    private String id;
    private String name;
    private double price;
    private String currency;
}
