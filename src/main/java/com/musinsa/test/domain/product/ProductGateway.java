package com.musinsa.test.domain.product;

import com.musinsa.test.domain.product.repository.ProductRepository;
import com.musinsa.test.support.stereotype.Gateway;
import lombok.RequiredArgsConstructor;

@Gateway
@RequiredArgsConstructor
public class ProductGateway {

  private final ProductRepository productRepository;
}
