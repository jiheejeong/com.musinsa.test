package com.musinsa.test.domain.product.repository;

import com.musinsa.test.service.product.dto.LowestPriceBrandResult;
import com.musinsa.test.service.product.dto.LowestPriceCategoryResult;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.SubQueryExpression;
import com.querydsl.jpa.JPAExpressions;
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

  @Override
  public List<LowestPriceCategoryResult> getCategoryLowestPriceList() {
    return jpaQueryFactory.from(product)
        .join(product.brand, brand)
        .join(product.category, category)
        .groupBy(category.categoryNo, brand.brandNo)
        .orderBy(product.registeredAt.desc())
        .transform(groupBy(category.name).list(Projections.constructor(LowestPriceCategoryResult.class,
            category.name,
            list(Projections.constructor(LowestPriceCategoryResult.BrandPrice.class,
                brand.name,
                product.price.min())))
        ));
  }
}
