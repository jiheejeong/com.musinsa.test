package com.musinsa.test.domain.product;

import com.musinsa.test.domain.brand.Brand;
import com.musinsa.test.domain.category.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long productNo;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private Long price;

  @CreatedDate
  private LocalDateTime registeredAt;

  @LastModifiedDate
  private LocalDateTime updatedAt;

  @ManyToOne
  @JoinColumn(name = "categoryNo")
  private Category category;

  @ManyToOne
  @JoinColumn(name = "brandNo")
  private Brand brand;
}
