package com.musinsa.test.service.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
@AllArgsConstructor
public class LowestPriceBrandResult {
  String brandName;
  List<CategoryPrice> categoryPrices;
  Long totalPrice;

  public LowestPriceBrandResult(final String brandName, List<CategoryPrice> categoryPrices) {
    this.brandName = brandName;
    this.categoryPrices = categoryPrices;
    this.totalPrice = null;
  }

  public Long getTotalPrice() {
    return categoryPrices.stream().mapToLong(CategoryPrice::getPrice).sum();
  }

  @Value
  @Builder
  @AllArgsConstructor
  public static class CategoryPrice {
    String categoryName;
    Long price;
  }
}
