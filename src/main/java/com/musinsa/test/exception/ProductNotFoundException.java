package com.musinsa.test.exception;

import jakarta.persistence.EntityNotFoundException;

import java.util.function.Supplier;

public class ProductNotFoundException extends EntityNotFoundException {
  public ProductNotFoundException(final String message) {
    super(message);
  }

  public static Supplier<ProductNotFoundException> supplier(final Long productNo) {
    return () -> new ProductNotFoundException("Product for '" + productNo + "' not found");
  }
}
