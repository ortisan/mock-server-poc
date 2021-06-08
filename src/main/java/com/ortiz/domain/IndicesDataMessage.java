package com.ortiz.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class IndicesDataMessage {

    @JsonProperty("data")
    private List<IndiceMessage> indices;

    public List<IndiceMessage> getIndices() {
        return indices;
    }

    public void setIndices(List<IndiceMessage> indices) {
        this.indices = indices;
    }
}
