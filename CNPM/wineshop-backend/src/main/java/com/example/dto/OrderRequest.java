package com.example.dto;

import java.util.List;

public class OrderRequest {
    public String recipientName;
    public String address;
    public String phone;
    public String paymentMethod;
    public String notes;
    public List<CartItemDTO> items;

    public static class CartItemDTO {
        public Long productId;
        public int quantity;
    }
}
