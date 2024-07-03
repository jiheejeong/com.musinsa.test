package com.musinsa.test.rest.brand.payload;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class BrandResponse {
  Long brandNo;
  String name;
  LocalDateTime registeredAt;
  LocalDateTime updatedAt;
}
