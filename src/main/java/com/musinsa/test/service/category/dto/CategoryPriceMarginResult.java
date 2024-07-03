package com.musinsa.test.service.category.dto;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class CategoryPriceMarginResult {
  String categoryName;
  List<BrandPrice> lowestBrandPrice;
  List<BrandPrice> highestBrandPrice;

  @Value
  @Builder
  public static class BrandPrice {
    String brandName;
    Long price;
  }
}
