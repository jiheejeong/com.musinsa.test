package com.musinsa.test.rest.product;

import com.musinsa.test.rest.product.payload.CategoryPriceMarginResponse;
import com.musinsa.test.service.product.ProductCategoryService;
import com.musinsa.test.service.product.dto.CategoryPriceMarginResult;
import com.musinsa.test.support.ResponseWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product-category")
@RequiredArgsConstructor
public class ProductCategoryController {

  private final ProductCategoryService productCategoryService;

  /**
   * @title 카테고리별 최고/최저가 조회
   */
  @GetMapping("/price")
  public ResponseWrapper<CategoryPriceMarginResponse> getBrandPriceMarginByCategory(final String categoryName) {
    final CategoryPriceMarginResult result = productCategoryService.getBrandPriceMarginByCategory(categoryName);
    return ResponseWrapper.ok(ProductPayloadConverter.INSTANCE.toResponse(result));
  }
}
