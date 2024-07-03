package com.musinsa.test.rest.category;

import com.musinsa.test.rest.category.payload.CategoryPriceMarginResponse;
import com.musinsa.test.service.category.CategoryPriceService;
import com.musinsa.test.service.category.dto.CategoryPriceMarginResult;
import com.musinsa.test.support.ResponseWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category-price")
@RequiredArgsConstructor
public class CategoryPriceController {

  private final CategoryPriceService categoryPriceService;

  /**
   * @title 카테고리별 최고/최저가 조회
   */
  @GetMapping
  public ResponseWrapper<CategoryPriceMarginResponse> getBrandPriceMarginByCategory(final String categoryName) {
    final CategoryPriceMarginResult result = categoryPriceService.getBrandPriceMarginByCategory(categoryName);
    return ResponseWrapper.ok(CategoryPayloadConverter.INSTANCE.toResponse(result));
  }
}
