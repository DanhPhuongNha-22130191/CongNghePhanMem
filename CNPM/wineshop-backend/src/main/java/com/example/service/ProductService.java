package com.example.service;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<String> getAllBrands() {
        return productRepository.findAllDistinctBrands();
    }

    public List<Double> getAllAlcohols() {
        return productRepository.findAllDistinctAlcohols();
    }

    // 2.6 – Gọi Repository để xử lý nghiệp vụ lọc
    public List<Product> filterProducts(String brand, Double alcohol, Double maxPrice) {
        return productRepository.filterProducts(brand, alcohol, maxPrice); // 2.7
    }

    // Lấy khoảng giá min/max
    public Map<String, Double> getPriceRange() {
        Object[] result = (Object[]) productRepository.findPriceRange();
        System.out.println(result[0]);
        System.out.println(result[1]);
        Map<String, Double> map = new HashMap<>();
        map.put("minPrice", (Double) result[0]);
        map.put("maxPrice", (Double) result[1]);
        System.out.println(map.get("minPrice"));
        return map;
    }
}