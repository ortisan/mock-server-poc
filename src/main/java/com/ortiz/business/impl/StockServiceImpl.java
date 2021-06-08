package com.ortiz.business.impl;

import com.ortiz.business.IStockService;
import com.ortiz.domain.IndicesDataMessage;
import com.ortiz.domain.PortfolioAssetMessage;
import com.ortiz.domain.PortfolioDataMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class StockServiceImpl implements IStockService {

    private WebClient webClient;


    public StockServiceImpl(@Value("${assets.url}")
                                    String assetsUrl,
                            @Autowired
                                    WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(assetsUrl).build();
    }

    @Override
    public Mono<IndicesDataMessage> getIndices() {
        return this.webClient.get()
                .uri("/assets/indices")
                .header("Content-Type", "application/json")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(IndicesDataMessage.class).log();
    }

    @Override
    public Mono<PortfolioDataMessage> getPortfolio() {
        return this.webClient.get()
                .uri("/assets/portfolio")
                .header("Content-Type", "application/json")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(PortfolioDataMessage.class);
    }

    @Override
    public Mono<PortfolioDataMessage> createPortfolio(List<PortfolioAssetMessage> assets) {
        return this.webClient.post()
                .uri("/assets/portfolio")
                .body(Mono.just(assets), List.class)
                .header("Content-Type", "application/json")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(PortfolioDataMessage.class);
    }

    @Override
    public Mono<PortfolioDataMessage> updatePortfolio(List<PortfolioAssetMessage> assets) {
        return this.webClient.put()
                .uri("/assets/portfolio")
                .body(Mono.just(assets), List.class)
                .header("Content-Type", "application/json")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(PortfolioDataMessage.class);
    }
}