package com.musinsa.test.exception;

import jakarta.persistence.EntityNotFoundException;

import java.util.function.Supplier;

public class CategoryNotFoundException extends EntityNotFoundException {
  public CategoryNotFoundException(final String message) {
    super(message);
  }

  public static Supplier<CategoryNotFoundException> supplier(final Long categoryNo) {
    return () -> new CategoryNotFoundException("Category for '" + categoryNo + "' not found");
  }

  public static Supplier<CategoryNotFoundException> supplier(final String categoryName) {
    return () -> new CategoryNotFoundException("Category for '" + categoryName + "' not found");
  }
}
