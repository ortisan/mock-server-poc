package com.ortiz.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PortfolioDataMessage {

    @JsonProperty("data")
    private List<PortfolioAssetMessage> assets;
}
