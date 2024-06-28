package com.musinsa.test.domain.category;

import com.musinsa.test.domain.category.repository.CategoryRepository;
import com.musinsa.test.support.stereotype.Gateway;
import lombok.RequiredArgsConstructor;

@Gateway
@RequiredArgsConstructor
public class CategoryGateway {

  private final CategoryRepository categoryRepository;
}
