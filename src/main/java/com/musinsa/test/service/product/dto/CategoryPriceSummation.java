package com.musinsa.test.service.product.dto;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class CategoryPriceSummation {
  List<CategoryPrice> categoryPrices;
  Long totalPrice;

  public Long getTotalPrice() {
    return categoryPrices.stream().mapToLong(CategoryPrice::getPrice).sum();
  }

  @Value
  @Builder
  public static class CategoryPrice {
    String categoryName;
    String brandName;
    Long price;
  }
}
