package com.musinsa.test.service.product;

import com.musinsa.test.domain.brand.Brand;
import com.musinsa.test.domain.brand.BrandGateway;
import com.musinsa.test.service.brand.dto.BrandResult;
import com.musinsa.test.service.brand.dto.CreateBrandCommand;
import com.musinsa.test.service.brand.dto.ModifyBrandCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BrandService {

  private final BrandGateway brandGateway;

  @Transactional
  public BrandResult create(final CreateBrandCommand command) {
    final Brand brand = new Brand();
    brand.create(command.getName());
    return BrandConverter.INSTANCE.toResult(brandGateway.save(brand));
  }

  @Transactional
  public void modify(final ModifyBrandCommand command) {
    final Brand brand = brandGateway.findById(command.getBrandNo());
    brand.modify(command.getName());
    brandGateway.save(brand);
  }

  @Transactional
  public void delete(final Long brandNo) {
    final Brand brand = brandGateway.findById(brandNo);
    brandGateway.delete(brand);
  }
}

