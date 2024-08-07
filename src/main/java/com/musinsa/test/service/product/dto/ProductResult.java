package com.musinsa.test.service.product.dto;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class ProductResult {
  Long productNo;
  String name;
  Long price;
  LocalDateTime registeredAt;
  LocalDateTime updatedAt;
  String categoryName;
  String brandName;
}
