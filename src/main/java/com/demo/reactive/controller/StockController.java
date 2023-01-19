package com.demo.reactive.controller;


import com.demo.reactive.dto.StockRequest;
import com.demo.reactive.dto.StockResponse;
import com.demo.reactive.model.Stock;
import com.demo.reactive.service.StockService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/stocks")
@AllArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping("/{idStock}")
    public Mono<StockResponse> getOneStock(@PathVariable String idStock) {
        return this.stockService.getOneStock(idStock);
    }

    @GetMapping
    public Flux<StockResponse> getAllStocks() {
        return this.stockService.getAllStocks();
    }

    @PostMapping
    public Mono<StockResponse> ajouterStock(@RequestBody StockRequest stock) {
        return this.stockService.addStock(stock);
    }
}
