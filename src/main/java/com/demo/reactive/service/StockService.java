package com.demo.reactive.service;

import com.demo.reactive.dto.StockRequest;
import com.demo.reactive.dto.StockResponse;
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

    public Mono<StockResponse> getOneStock(String id) {
        return this.repository.findById(id)
                .map(StockResponse::fromModel);
    }

    public Flux<StockResponse> getAllStocks() {
        return this.repository.findAll()
                .map(StockResponse::fromModel);
    }

    public Mono<StockResponse> addStock(StockRequest request) {
        return this.repository.save(request.toStock())
                .map(StockResponse::fromModel);
    }
}
