package com.musinsa.test.rest.product.payload;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class LowestPriceSummationResponse {
  List<LowestPrice> lowestPrices;
  Long totalPrice;

  @Value
  @Builder
  public static class LowestPrice {
    String categoryName;
    String brandName;
    Long price;
  }
}
