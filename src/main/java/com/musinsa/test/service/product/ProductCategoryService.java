package com.musinsa.test.service.product;

import com.musinsa.test.domain.category.Category;
import com.musinsa.test.domain.category.CategoryGateway;
import com.musinsa.test.domain.product.Product;
import com.musinsa.test.service.product.dto.CategoryPriceMarginResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ProductCategoryService {

  private final CategoryGateway categoryGateway;

  @Transactional(readOnly = true)
  public CategoryPriceMarginResult getBrandPriceMarginByCategory(final String categoryName) {
    final Category category = categoryGateway.findByName(categoryName);
    final TreeMap<Long, List<CategoryPriceMarginResult.BrandPrice>> productMap = new TreeMap<>(category.getProducts().stream()
        .collect(Collectors.groupingBy(Product::getPrice, Collectors.mapping(product ->
            CategoryPriceMarginResult.BrandPrice.builder()
                .brandName(product.getBrand().getName())
                .price(product.getPrice())
                .build(), Collectors.toList()))));
    return CategoryPriceMarginResult.builder()
        .categoryName(category.getName())
        .lowestBrandPrice(productMap.firstEntry().getValue())
        .highestBrandPrice(productMap.lastEntry().getValue())
        .build();
  }
}
