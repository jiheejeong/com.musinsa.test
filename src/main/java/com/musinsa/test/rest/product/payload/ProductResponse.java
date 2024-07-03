package com.musinsa.test.rest.product.payload;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class ProductResponse {
  Long productNo;
  String name;
  Long price;
  String categoryName;
  String brandName;
  LocalDateTime registeredAt;
  LocalDateTime updatedAt;
}
