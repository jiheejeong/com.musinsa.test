package com.musinsa.test.rest.product;

import com.musinsa.test.rest.product.payload.*;
import com.musinsa.test.service.product.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductPayloadConverter {

  ProductPayloadConverter INSTANCE = Mappers.getMapper(ProductPayloadConverter.class);

  CreateProductCommand toCommand(CreateProductRequest source);

  ModifyProductCommand toCommand(ModifyProductRequest source, Long productNo);

  ProductResponse toResponse(ProductResult source);

  CategoryPriceMarginResponse toResponse(CategoryPriceMarginResult source);

  LowestPriceBrandResponse.LowestPriceBrand toResponse(LowestPriceBrandResult source);

  @Mapping(target = "lowestPrices", source="categoryPrices")
  LowestPriceSummationResponse toResponse(CategoryPriceSummation source);
}
