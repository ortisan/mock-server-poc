package com.ortiz.business;

import com.ortiz.domain.IndicesDataMessage;
import reactor.core.publisher.Mono;

public interface IStockService {
    Mono<IndicesDataMessage> getIndices();
}
