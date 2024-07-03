package com.musinsa.test.domain.product.repository;


import com.musinsa.test.service.product.dto.LowestPriceBrandResult;
import com.musinsa.test.service.product.dto.LowestPriceCategoryResult;

import java.util.List;

public interface ProductCustomRepository {

  List<LowestPriceBrandResult> getBrandLowestPriceList();

  List<LowestPriceCategoryResult> getCategoryLowestPriceList();
}
