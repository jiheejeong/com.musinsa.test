package com.musinsa.test.service.product.dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class CreateProductCommand {
  String name;
  Long price;
  Long categoryNo;
  Long brandNo;
}
