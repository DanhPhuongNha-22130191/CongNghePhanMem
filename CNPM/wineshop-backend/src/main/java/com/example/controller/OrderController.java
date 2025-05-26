package com.example.controller;

import com.example.dto.OrderRequest;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public String placeOrder(@RequestBody OrderRequest request) {
        return "Đặt hàng thành công. Mã đơn hàng: " + orderService.processOrder(request);
    }
}
