package com.musinsa.test.service.product;

import com.musinsa.test.domain.product.Product;
import com.musinsa.test.service.product.dto.ProductResult;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductConverter {

  ProductConverter INSTANCE = Mappers.getMapper(ProductConverter.class);

  @Mapping(target = "categoryName", source = "category.name")
  @Mapping(target = "brandName", source = "brand.name")
  ProductResult toResult(Product source);
}
