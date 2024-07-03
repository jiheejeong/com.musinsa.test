package com.musinsa.test.service.product;

import com.musinsa.test.domain.product.ProductGateway;
import com.musinsa.test.service.product.dto.LowestPriceBrandResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductBrandService {
  private final ProductGateway productGateway;

  @Transactional(readOnly = true)
  public LowestPriceBrandResult getLowestPriceBrand() {
    final List<LowestPriceBrandResult> brands = productGateway.getBrandLowestPriceList();
    return brands.stream().min(Comparator.comparingLong(LowestPriceBrandResult::getTotalPrice)).orElse(LowestPriceBrandResult.builder().build());
  }
}
