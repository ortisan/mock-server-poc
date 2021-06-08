package com.ortiz.view;

import com.ortiz.business.IStockService;
import com.ortiz.domain.IndicesDataMessage;
import com.ortiz.domain.PortfolioAssetMessage;
import com.ortiz.domain.PortfolioDataMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class DefaultController {

    @Autowired
    private IStockService stockService;

    @GetMapping("/broker/indices")
    public Mono<ResponseEntity> getIndices() {
        return stockService.getIndices().flatMap((IndicesDataMessage indicesDataMessage) -> {
            ResponseEntity body = ResponseEntity.status(HttpStatus.OK).body(indicesDataMessage);
            return Mono.just(body);
        }).onErrorResume(exc -> {
            ResponseEntity body = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exc.getMessage());
            return Mono.just(body);
        });
    }

    @GetMapping("/broker/portfolio")
    public Mono<ResponseEntity> getPortfolio() {
        return stockService.getPortfolio().flatMap((PortfolioDataMessage dataMessage) -> {
            ResponseEntity body = ResponseEntity.status(HttpStatus.OK).body(dataMessage);
            return Mono.just(body);
        }).onErrorResume(exc -> {
            ResponseEntity body = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exc.getMessage());
            return Mono.just(body);
        });
    }

    @PostMapping("/broker/portfolio")
    public Mono<ResponseEntity> createPortfolio(@RequestBody List<PortfolioAssetMessage> assets) {
        return stockService.createPortfolio(assets).flatMap((PortfolioDataMessage dataMessage) -> {
            ResponseEntity body = ResponseEntity.status(HttpStatus.OK).body(dataMessage);
            return Mono.just(body);
        }).onErrorResume(exc -> {
            ResponseEntity body = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exc.getMessage());
            return Mono.just(body);
        });
    }

    @PutMapping("/broker/portfolio")
    public Mono<ResponseEntity> updatePortfolio(@RequestBody List<PortfolioAssetMessage> assets) {
        return stockService.updatePortfolio(assets).flatMap((PortfolioDataMessage dataMessage) -> {
            ResponseEntity body = ResponseEntity.status(HttpStatus.OK).body(dataMessage);
            return Mono.just(body);
        }).onErrorResume(exc -> {
            ResponseEntity body = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exc.getMessage());
            return Mono.just(body);
        });
    }
}
