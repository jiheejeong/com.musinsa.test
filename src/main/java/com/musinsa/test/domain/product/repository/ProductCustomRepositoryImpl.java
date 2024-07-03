package com.musinsa.test.domain.product.repository;

import com.musinsa.test.service.product.dto.LowestPriceBrandResult;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.musinsa.test.domain.brand.QBrand.brand;
import static com.musinsa.test.domain.category.QCategory.category;
import static com.musinsa.test.domain.product.QProduct.product;
import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;

@Repository
public class ProductCustomRepositoryImpl implements ProductCustomRepository {

  private final JPAQueryFactory jpaQueryFactory;

  public ProductCustomRepositoryImpl(final JPAQueryFactory jpaQueryFactory) {
    this.jpaQueryFactory = jpaQueryFactory;
  }

  @Override
  public List<LowestPriceBrandResult> getBrandLowestPriceList() {
    return jpaQueryFactory.from(product)
        .join(product.brand, brand)
        .join(product.category, category)
        .groupBy(brand.brandNo, category.categoryNo)
        .transform(groupBy(brand.name).list(Projections.constructor(LowestPriceBrandResult.class,
            brand.name,
            list(Projections.constructor(LowestPriceBrandResult.CategoryPrice.class,
                category.name,
                product.price.min())))
        ));
  }
}
