package com.demo.reactive.service;

import com.demo.reactive.dto.StockRequest;
import com.demo.reactive.dto.StockResponse;
import com.demo.reactive.exception.StockCreationException;
import com.demo.reactive.exception.StockNotFoundException;
import com.demo.reactive.model.Stock;
import com.demo.reactive.repository.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class StockService {

    private final StockRepository repository;

    public Mono<StockResponse> getOneStock(String id) {
        return this.repository.findById(id)
                .map(StockResponse::fromModel)
                .switchIfEmpty(
                    Mono.error(new StockNotFoundException("Stock not found with id: " + id)
                ));
    }

    public Flux<StockResponse> getAllStocks(BigDecimal priceGreaterThan) {
        return this.repository.findAll()
                .filter(stock -> stock.getPrice().compareTo(priceGreaterThan) > 0)
                .map(StockResponse::fromModel);
    }

    public Mono<StockResponse> addStock(StockRequest request) {
        return Mono.just(request)
            .map(StockRequest::toStock)
            .flatMap(stock -> this.repository.save(request.toStock()))
            .map(StockResponse::fromModel)
            .onErrorMap(ex -> new StockCreationException(ex.getMessage()));
    }
}
