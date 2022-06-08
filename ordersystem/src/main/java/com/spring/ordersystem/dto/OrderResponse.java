package com.spring.ordersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class OrderResponse {
    private String restaurantName;
    private List<OrderResponseDto> foods;
    private int deliveryFee;
    private int totalPrice;



    public OrderResponse(String restaurantName, int deliveryFee, int totalPrice) {
        this.restaurantName = restaurantName;
        this.deliveryFee = deliveryFee;
        this.totalPrice = totalPrice;
    }
}
