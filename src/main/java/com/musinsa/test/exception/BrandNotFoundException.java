package com.musinsa.test.exception;

import jakarta.persistence.EntityNotFoundException;

import java.util.function.Supplier;

public class BrandNotFoundException extends EntityNotFoundException {
  public BrandNotFoundException(final String message) {
    super(message);
  }

  public static Supplier<BrandNotFoundException> supplier(final Long brandName) {
    return () -> new BrandNotFoundException("Brand for '" + brandName + "' not found");
  }
}
