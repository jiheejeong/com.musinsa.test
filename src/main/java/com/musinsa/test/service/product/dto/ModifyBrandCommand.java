package com.musinsa.test.service.product.dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ModifyBrandCommand {
  Long brandNo;
  String name;
}
