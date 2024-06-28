package com.musinsa.test.service.product;

import com.musinsa.test.domain.brand.Brand;
import com.musinsa.test.service.brand.dto.BrandResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BrandConverter {

  BrandConverter INSTANCE = Mappers.getMapper(BrandConverter.class);

  BrandResult toResult(Brand source);
}
