package com.musinsa.test.rest.product;

import com.musinsa.test.rest.product.payload.CreateProductRequest;
import com.musinsa.test.rest.product.payload.ModifyProductRequest;
import com.musinsa.test.rest.product.payload.ProductResponse;
import com.musinsa.test.service.product.ProductService;
import com.musinsa.test.service.product.dto.CreateProductCommand;
import com.musinsa.test.service.product.dto.ModifyProductCommand;
import com.musinsa.test.service.product.dto.ProductResult;
import com.musinsa.test.support.ResponseWrapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  /**
   * @title 상품 등록
   */
  @PostMapping
  public ResponseWrapper<ProductResponse> create(@RequestBody @Valid final CreateProductRequest request) {
    final CreateProductCommand command = ProductPayloadConverter.INSTANCE.toCommand(request);
    final ProductResult result = productService.create(command);
    return ResponseWrapper.ok(ProductPayloadConverter.INSTANCE.toResponse(result));
  }

  /**
   * @param productNo 상품 번호
   * @title 상품 수정
   */
  @PutMapping("/{productNo}")
  public ResponseWrapper<Void> modify(@PathVariable final Long productNo, @RequestBody @Valid final ModifyProductRequest request) {
    final ModifyProductCommand command = ProductPayloadConverter.INSTANCE.toCommand(request, productNo);
    productService.modify(command);
    return ResponseWrapper.ok();
  }

  /**
   * @param productNo 상품 번호
   * @title 상품 삭제
   */
  @DeleteMapping("/{productNo}")
  public ResponseWrapper<Void> delete(@PathVariable final Long productNo) {
    productService.delete(productNo);
    return ResponseWrapper.ok();
  }
}
