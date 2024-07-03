# 무신사 사전 과제 

## 실행환경: intellij
## 빌드환경: intellij clean / build 실행
## 테스트환경: postman
## 구현 범위

### 구현 1: ProductCategoryController
GET localhost:8080/api/product/by-category/lowest-price-summation

### 구현 2: ProductBrandController
GET localhost:8080/api/product/by-brand/lowest-price

### 구현 3: ProductCategoryController
GET localhost:8080/api/product/by-category/price-margin?categoryName=상의

### 구현 4
#### 상품 생성/수정/삭제: PruductController
* POST localhost:8080/api/products

  {
  "name" : "ABCD",
  "price" : 1000,
  "categoryNo" : 1,
  "brandNo" : 1
  }
* PUT localhost:8080/api/products/1

  {
  "name" : "ABCD",
  "price" : 1000
  }
* DELETE localhost:8080/api/products/1

#### 브랜드 생성/수정/삭제: BrandController
* POST localhost:8080/api/brands \
{
"name" : "ABCD"
}
* PUT localhost:8080/api/brands/1 \
{
"name" : "ABCD"
}
* DELETE localhost:8080/api/brands/1

