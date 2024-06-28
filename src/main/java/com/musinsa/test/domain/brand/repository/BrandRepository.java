package com.musinsa.test.domain.brand.repository;


import com.musinsa.test.domain.brand.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
