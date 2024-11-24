package com.shakhawat.springgraphqlclient.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public record Item(String name, String category, Float price, Integer stock) {
}
