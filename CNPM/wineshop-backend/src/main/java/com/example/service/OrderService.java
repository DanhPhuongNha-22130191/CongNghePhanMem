package com.example.service;

import com.example.dto.OrderRequest;
import com.example.model.Order;
import com.example.model.OrderDetail;
import com.example.model.Product;
import com.example.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private ProductRepository productRepo;

    @Transactional
    public String processOrder(OrderRequest req) {
        Order order = new Order();
        order.setRecipientName(req.recipientName);
        order.setAddress(req.address);
        order.setPhone(req.phone);
        order.setPaymentMethod(req.paymentMethod);
        order.setNotes(req.notes);
        order.setOrderDate(Timestamp.from(Instant.now()));
        order.setStatus("PENDING");

        List<OrderDetail> details = new ArrayList<>();
        double total = 0;

        for (OrderRequest.CartItemDTO itemDTO : req.items) {
            Product product = productRepo.findById(itemDTO.productId).orElseThrow();
            double price = product.getPrice();

            OrderDetail detail = new OrderDetail();
            detail.setOrder(order);
            detail.setProduct(product);
            detail.setQuantity(itemDTO.quantity);
            detail.setPrice(price);
            total += price * itemDTO.quantity;
            details.add(detail);
        }

        order.setOrderDetails(details);
        order.setTotal(total);

        orderRepo.save(order);
        return "DH" + order.getId(); // Mã đơn hàng
    }
}
