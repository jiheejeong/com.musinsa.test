package com.musinsa.test.rest.category.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class CategoryPriceMarginResponse {
  @JsonProperty("카테고리")
  String categoryName;
  @JsonProperty("최저가")
  List<BrandPrice> lowestBrandPrice;
  @JsonProperty("최고가")
  List<BrandPrice> highestBrandPrice;

  @Value
  @Builder
  public static class BrandPrice {
    @JsonProperty("브랜드")
    String brandName;
    @JsonProperty("가격")
    Long price;
  }
}
