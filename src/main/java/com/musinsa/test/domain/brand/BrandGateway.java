package com.musinsa.test.domain.brand;

import com.musinsa.test.domain.brand.repository.BrandRepository;
import com.musinsa.test.exception.BrandNotFoundException;
import com.musinsa.test.support.stereotype.Gateway;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Gateway
@RequiredArgsConstructor
public class BrandGateway {

  private final BrandRepository brandRepository;

  public Brand save(final Brand brand) {
    return brandRepository.save(brand);
  }

  public Brand findById(final Long brandNo) {
    return brandRepository.findById(brandNo).orElseThrow(BrandNotFoundException.supplier(brandNo));
  }

  public void delete(final Brand brand) {
    brandRepository.delete(brand);
  }

  public List<Brand> findAll() {
    return brandRepository.findAll();
  }
}
