package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "https://congnghephanmem.onrender.com",
        methods = {RequestMethod.GET, RequestMethod.POST},
        allowedHeaders = {"Content-Type", "Authorization"},
        maxAge = 3600)
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/brands")
    public ResponseEntity<List<String>> getAllBrands() {
        return ResponseEntity.ok(productService.getAllBrands());
    }

    @GetMapping("/alcohols")
    public ResponseEntity<List<Double>> getAllAlcohols() {
        return ResponseEntity.ok(productService.getAllAlcohols());
    }

    // 2.5 – Controller nhận request từ JS frontend
    @GetMapping("/filter")
    public ResponseEntity<List<Product>> filterProducts(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) Double alcohol,
            @RequestParam(required = false) Double maxPrice) {
        List<Product> filtered = productService.filterProducts(brand, alcohol, maxPrice); // 2.6
        return ResponseEntity.ok(filtered); // 2.10 – Trả JSON về client
    }

    @GetMapping("/price-range")
    public ResponseEntity<Map<String, Double>> getPriceRange() {
        return ResponseEntity.ok(productService.getPriceRange());
    }
}
