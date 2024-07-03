package com.musinsa.test.domain.product;

import com.musinsa.test.domain.product.repository.ProductRepository;
import com.musinsa.test.exception.ProductNotFoundException;
import com.musinsa.test.support.stereotype.Gateway;
import lombok.RequiredArgsConstructor;

@Gateway
@RequiredArgsConstructor
public class ProductGateway {

  private final ProductRepository productRepository;

  public Product save(final Product product) {
    return productRepository.save(product);
  }

  public Product findById(final Long productNo) {
    return productRepository.findById(productNo).orElseThrow(ProductNotFoundException.supplier(productNo));
  }

  public void delete(final Product brand) {
    productRepository.delete(brand);
  }
}
