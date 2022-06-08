package com.spring.ordersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MenuRegisterDto {
    private Long restaurantId;
    private String name;
    private int price;
}
