package com.musinsa.test.domain.brand;

import com.musinsa.test.domain.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Brand {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long brandNo;

  @Column(nullable = false)
  private String name;

  @CreatedDate
  private LocalDateTime registeredAt;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Product> products ;
}
