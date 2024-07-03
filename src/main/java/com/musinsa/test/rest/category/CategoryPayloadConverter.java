package com.musinsa.test.rest.category;

import com.musinsa.test.rest.category.payload.CategoryPriceMarginResponse;
import com.musinsa.test.service.category.dto.CategoryPriceMarginResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryPayloadConverter {

  CategoryPayloadConverter INSTANCE = Mappers.getMapper(CategoryPayloadConverter.class);

  CategoryPriceMarginResponse toResponse(CategoryPriceMarginResult source);
}
