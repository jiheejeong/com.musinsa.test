package com.musinsa.test.rest.brand;

import com.musinsa.test.rest.brand.payload.BrandResponse;
import com.musinsa.test.rest.brand.payload.CreateBrandRequest;
import com.musinsa.test.rest.brand.payload.ModifyBrandRequest;
import com.musinsa.test.service.brand.dto.BrandResult;
import com.musinsa.test.service.brand.dto.CreateBrandCommand;
import com.musinsa.test.service.brand.dto.ModifyBrandCommand;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BrandPayloadConverter {

  BrandPayloadConverter INSTANCE = Mappers.getMapper(BrandPayloadConverter.class);

  CreateBrandCommand toCommand(CreateBrandRequest source);

  ModifyBrandCommand toCommand(ModifyBrandRequest source, Long brandNo);

  BrandResponse toResponse(BrandResult source);
}
