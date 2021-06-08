package com.ortiz.view;

import com.ortiz.business.IStockService;
import com.ortiz.domain.IndicesDataMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

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
}
