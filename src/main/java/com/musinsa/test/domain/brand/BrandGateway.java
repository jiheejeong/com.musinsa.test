package com.musinsa.test.domain.brand;

import com.musinsa.test.domain.brand.repository.BrandRepository;
import com.musinsa.test.support.stereotype.Gateway;
import lombok.RequiredArgsConstructor;

@Gateway
@RequiredArgsConstructor
public class BrandGateway {

  private final BrandRepository brandRepository;
}
