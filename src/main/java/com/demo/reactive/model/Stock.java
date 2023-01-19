package com.demo.reactive.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Stock {

    @Id
    private String id;
    private String name;

    @NonNull
    private BigDecimal price;
    private String currency;
}
