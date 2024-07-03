package com.musinsa.test.service.product;

import com.musinsa.test.domain.brand.Brand;
import com.musinsa.test.domain.brand.BrandGateway;
import com.musinsa.test.domain.category.Category;
import com.musinsa.test.domain.category.CategoryGateway;
import com.musinsa.test.domain.product.Product;
import com.musinsa.test.domain.product.ProductGateway;
import com.musinsa.test.service.product.dto.CreateProductCommand;
import com.musinsa.test.service.product.dto.ModifyProductCommand;
import com.musinsa.test.service.product.dto.ProductResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductGateway productGateway;
  private final BrandGateway brandGateway;
  private final CategoryGateway categoryGateway;

  @Transactional
  public ProductResult create(final CreateProductCommand command) {
    final Product product = new Product();
    final Category category = categoryGateway.findById(command.getCategoryNo());
    final Brand brand = brandGateway.findById(command.getBrandNo());
    product.create(command.getName(), command.getPrice(), category, brand);
    return ProductConverter.INSTANCE.toResult(productGateway.save(product));
  }

  @Transactional
  public void modify(final ModifyProductCommand command) {
    final Product product = productGateway.findById(command.getProductNo());
    product.modify(command.getName(), command.getPrice());
    productGateway.save(product);
  }

  @Transactional
  public void delete(final Long productNo) {
    final Product product = productGateway.findById(productNo);
    productGateway.delete(product);
  }
}

