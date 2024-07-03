package com.musinsa.test.rest.product;

import com.musinsa.test.rest.product.payload.CategoryPriceMarginResponse;
import com.musinsa.test.rest.product.payload.CreateProductRequest;
import com.musinsa.test.rest.product.payload.ModifyProductRequest;
import com.musinsa.test.rest.product.payload.ProductResponse;
import com.musinsa.test.service.product.dto.CategoryPriceMarginResult;
import com.musinsa.test.service.product.dto.CreateProductCommand;
import com.musinsa.test.service.product.dto.ModifyProductCommand;
import com.musinsa.test.service.product.dto.ProductResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductPayloadConverter {

  ProductPayloadConverter INSTANCE = Mappers.getMapper(ProductPayloadConverter.class);

  CreateProductCommand toCommand(CreateProductRequest source);

  ModifyProductCommand toCommand(ModifyProductRequest source, Long productNo);

  ProductResponse toResponse(ProductResult source);

  CategoryPriceMarginResponse toResponse(CategoryPriceMarginResult source);
}
