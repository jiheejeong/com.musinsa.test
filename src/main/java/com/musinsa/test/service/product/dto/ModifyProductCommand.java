package com.musinsa.test.service.product.dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ModifyProductCommand {
  Long productNo;
  String name;
  Long price;
}
