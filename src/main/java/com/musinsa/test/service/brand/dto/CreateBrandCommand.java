package com.musinsa.test.service.brand.dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class CreateBrandCommand {
  String name;
}
