package com.spring.ordersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderRequest {
    private int restaurantId;
    private List<OrderRequestDto> foods;
}
