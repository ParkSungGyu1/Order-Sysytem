package com.spring.ordersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderRequest {
    private int restaurantId;
    @Valid
    private List<OrderRequestDto> foods;
}
