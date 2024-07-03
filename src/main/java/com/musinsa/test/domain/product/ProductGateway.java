package com.musinsa.test.domain.product;

import com.musinsa.test.domain.product.repository.ProductRepository;
import com.musinsa.test.exception.ProductNotFoundException;
import com.musinsa.test.service.product.dto.LowestPriceBrandResult;
import com.musinsa.test.service.product.dto.LowestPriceCategoryResult;
import com.musinsa.test.support.stereotype.Gateway;
import lombok.RequiredArgsConstructor;

import java.util.List;

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

  public List<LowestPriceBrandResult> getBrandLowestPriceList() {
    return productRepository.getBrandLowestPriceList();
  }

  public List<LowestPriceCategoryResult> getCategoryLowestPriceList() {
    return productRepository.getCategoryLowestPriceList();
  }
}
