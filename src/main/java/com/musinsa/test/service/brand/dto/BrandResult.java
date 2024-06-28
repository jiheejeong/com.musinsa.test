package com.musinsa.test.service.brand.dto;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class BrandResult {
  Long brandNo;
  String name;
  LocalDateTime registeredAt;
}
