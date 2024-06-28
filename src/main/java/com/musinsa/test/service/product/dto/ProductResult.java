package com.musinsa.test.service.product.dto;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class ProductResult {
  Long brandNo;
  String name;
  LocalDateTime registeredAt;
}
