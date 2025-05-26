package com.example.repository;

import com.example.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // 2.7 – Truy vấn JPQL theo bộ lọc
    @Query("SELECT p FROM Product p WHERE " +
            "(:brand IS NULL OR p.brand.name = :brand) AND " +
            "(:alcohol IS NULL OR p.alcohol = :alcohol) AND " +
            "(:maxPrice IS NULL OR p.price <= :maxPrice)")
    List<Product> filterProducts(@Param("brand") String brand,
                                 @Param("alcohol") Double alcohol,
                                 @Param("maxPrice") Double maxPrice);

    // Truy vấn lấy khoảng giá min/max
    @Query("SELECT MIN(p.price), MAX(p.price) FROM Product p")
    Object[] findPriceRange();

    // Truy vấn lấy danh sách thương hiệu
    @Query("SELECT DISTINCT p.brand.name FROM Product p WHERE p.brand IS NOT NULL")
    List<String> findAllDistinctBrands();

    // Truy vấn lấy danh sách nồng độ cồn
    @Query("SELECT DISTINCT p.alcohol FROM Product p WHERE p.alcohol IS NOT NULL")
    List<Double> findAllDistinctAlcohols();
}

