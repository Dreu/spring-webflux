package com.demo.reactive.service;

import com.demo.reactive.model.Stock;
import com.demo.reactive.repository.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class StockService {

    private final StockRepository repository;

    public Mono<Stock> getOneStock(String id) {
        return this.repository.findById(id);
    }

    public Flux<Stock> getAllStocks() {
        return this.repository.findAll();
    }

    public Mono<Stock> addStock(Stock stock) {
        return this.repository.save(stock);
    }
}
