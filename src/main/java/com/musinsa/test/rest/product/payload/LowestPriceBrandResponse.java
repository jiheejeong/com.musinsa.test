package com.musinsa.test.rest.product.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class LowestPriceBrandResponse {
  @JsonProperty("최저가")
  LowestPriceBrand lowestPriceBrand;

  @Value
  @Builder
  public static class LowestPriceBrand {
    @JsonProperty("브랜드")
    String brandName;
    @JsonProperty("카테고리")
    List<CategoryPrice> categoryPrices;
    @JsonProperty("총액")
    Long totalPrice;

    @Value
    @Builder
    public static class CategoryPrice {
      @JsonProperty("카테고리")
      String categoryName;
      @JsonProperty("가격")
      Long price;
    }
  }
}
