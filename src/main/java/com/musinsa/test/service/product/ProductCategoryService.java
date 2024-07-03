package com.musinsa.test.service.product;

import com.musinsa.test.domain.category.Category;
import com.musinsa.test.domain.category.CategoryGateway;
import com.musinsa.test.domain.product.Product;
import com.musinsa.test.domain.product.ProductGateway;
import com.musinsa.test.service.product.dto.CategoryPriceMarginResult;
import com.musinsa.test.service.product.dto.CategoryPriceSummation;
import com.musinsa.test.service.product.dto.LowestPriceCategoryResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ProductCategoryService {

  private final CategoryGateway categoryGateway;
  private final ProductGateway productGateway;

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

  public CategoryPriceSummation getCategoryLowestPriceSummation() {
    final List<LowestPriceCategoryResult> result = productGateway.getCategoryLowestPriceList();
    final List<CategoryPriceSummation.CategoryPrice> categoryPrices = result.stream().map(lowestPriceCategoryResult -> {
      final Optional<LowestPriceCategoryResult.BrandPrice> brandPrice = lowestPriceCategoryResult.getBrandPrices().stream().findFirst();
      if (brandPrice.isPresent()) {
        return CategoryPriceSummation.CategoryPrice.builder()
            .categoryName(lowestPriceCategoryResult.getCategoryName())
            .brandName(brandPrice.get().getBrandName())
            .price(brandPrice.get().getPrice())
            .build();
      }
      return null;
    }).toList();
    return CategoryPriceSummation.builder().categoryPrices(categoryPrices).build();
  }
}
