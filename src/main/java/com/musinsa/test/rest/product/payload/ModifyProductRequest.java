package com.musinsa.test.rest.product.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class ModifyProductRequest {

  @NotEmpty
  String name;

  @NotNull
  Long price;
}
