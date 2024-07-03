package com.musinsa.test.domain.category.repository;


import com.musinsa.test.domain.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

  Optional<Category> findByName(String categoryName);
}
