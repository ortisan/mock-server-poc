package com.ortiz.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PortfolioAssetMessage {

    @JsonProperty("weight")
    private double weight;
    @JsonProperty("symbol")
    private String symbol;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
