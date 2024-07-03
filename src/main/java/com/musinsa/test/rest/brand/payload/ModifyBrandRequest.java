package com.musinsa.test.rest.brand.payload;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class ModifyBrandRequest {

  @NotEmpty
  String name;
}
