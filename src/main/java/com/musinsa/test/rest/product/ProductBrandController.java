package com.musinsa.test.rest.product;

import com.musinsa.test.rest.product.payload.LowestPriceBrandResponse;
import com.musinsa.test.service.product.ProductBrandService;
import com.musinsa.test.service.product.dto.LowestPriceBrandResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product/by-brand")
@RequiredArgsConstructor
public class ProductBrandController {

  private final ProductBrandService productBrandService;

  /**
   * @title 판매 최저가 브랜드 상품 조회
   */
  @GetMapping("/lowest-price")
  public ResponseEntity<LowestPriceBrandResponse> getLowestPriceBrand() {
    final LowestPriceBrandResult result = productBrandService.getLowestPriceBrand();
    return ResponseEntity.ok(LowestPriceBrandResponse.builder().lowestPriceBrand(ProductPayloadConverter.INSTANCE.toResponse(result)).build());
  }
}
