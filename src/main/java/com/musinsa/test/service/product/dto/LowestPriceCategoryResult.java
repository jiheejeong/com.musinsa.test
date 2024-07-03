package com.musinsa.test.service.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.Comparator;
import java.util.List;

@Value
@Builder
@AllArgsConstructor
public class LowestPriceCategoryResult {
  String categoryName;
  List<BrandPrice> brandPrices;


  @Value
  @Builder
  @AllArgsConstructor
  public static class BrandPrice {
    String brandName;
    Long price;
  }

  public List<BrandPrice> getBrandPrices() {
    return brandPrices.stream().min(Comparator.comparing(BrandPrice::getPrice)).stream().toList();
  }
}
