package com.ortiz.business;

import com.ortiz.domain.IndicesDataMessage;
import com.ortiz.domain.PortfolioAssetMessage;
import com.ortiz.domain.PortfolioDataMessage;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IStockService {
    Mono<IndicesDataMessage> getIndices();

    Mono<PortfolioDataMessage> getPortfolio();

    Mono<PortfolioDataMessage> createPortfolio(List<PortfolioAssetMessage> assets);

    Mono<PortfolioDataMessage> updatePortfolio(List<PortfolioAssetMessage> assets);
}
