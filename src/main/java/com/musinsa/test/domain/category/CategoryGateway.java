package com.musinsa.test.domain.category;

import com.musinsa.test.domain.category.repository.CategoryRepository;
import com.musinsa.test.exception.CategoryNotFoundException;
import com.musinsa.test.support.stereotype.Gateway;
import lombok.RequiredArgsConstructor;

@Gateway
@RequiredArgsConstructor
public class CategoryGateway {

  private final CategoryRepository categoryRepository;

  public Category findById(final Long categoryNo) {
    return categoryRepository.findById(categoryNo).orElseThrow(CategoryNotFoundException.supplier(categoryNo));
  }

  public Category findByName(final String categoryName) {
    return categoryRepository.findByName(categoryName).orElseThrow(CategoryNotFoundException.supplier(categoryName));
  }
}
