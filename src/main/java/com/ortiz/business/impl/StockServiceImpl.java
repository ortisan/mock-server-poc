package com.ortiz.business.impl;

import com.ortiz.business.IStockService;
import com.ortiz.domain.IndicesDataMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class StockServiceImpl implements IStockService {

    private WebClient webClient;

    @Value("${application.indices.url}")
    private String indicesUrl;

    public StockServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    @Override
    public Mono<IndicesDataMessage> getIndices() {
        return this.webClient.get()
                .uri(indicesUrl)
                .header("Content-Type", "application/json")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(IndicesDataMessage.class);
    }
}