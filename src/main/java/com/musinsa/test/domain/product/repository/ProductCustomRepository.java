package com.musinsa.test.domain.product.repository;


import com.musinsa.test.service.product.dto.LowestPriceBrandResult;

import java.util.List;

public interface ProductCustomRepository {

  List<LowestPriceBrandResult> getBrandLowestPriceList();
}
