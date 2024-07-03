package com.musinsa.test.rest.brand;

import com.musinsa.test.rest.brand.payload.BrandResponse;
import com.musinsa.test.rest.brand.payload.CreateBrandRequest;
import com.musinsa.test.rest.brand.payload.ModifyBrandRequest;
import com.musinsa.test.service.brand.BrandService;
import com.musinsa.test.service.brand.dto.BrandResult;
import com.musinsa.test.service.brand.dto.CreateBrandCommand;
import com.musinsa.test.service.brand.dto.ModifyBrandCommand;
import com.musinsa.test.support.ResponseWrapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/brands")
@RequiredArgsConstructor
public class BrandController {

  private final BrandService brandService;

  /**
   * @title 브랜드 등록
   */
  @PostMapping
  public ResponseWrapper<BrandResponse> create(@RequestBody @Valid final CreateBrandRequest request) {
    final CreateBrandCommand command = BrandPayloadConverter.INSTANCE.toCommand(request);
    final BrandResult result = brandService.create(command);
    return ResponseWrapper.ok(BrandPayloadConverter.INSTANCE.toResponse(result));
  }

  /**
   * @param brandNo 브랜드 번호
   * @title 브랜드 수정
   */
  @PutMapping("/{brandNo}")
  public ResponseWrapper<Void> modify(@PathVariable final Long brandNo, @RequestBody @Valid final ModifyBrandRequest request) {
    final ModifyBrandCommand command = BrandPayloadConverter.INSTANCE.toCommand(request, brandNo);
    brandService.modify(command);
    return ResponseWrapper.ok();
  }

  /**
   * @param brandNo 브랜드 번호
   * @title 브랜드 삭제
   */
  @DeleteMapping("/{brandNo}")
  public ResponseWrapper<Void> delete(@PathVariable final Long brandNo) {
    brandService.delete(brandNo);
    return ResponseWrapper.ok();
  }
}
