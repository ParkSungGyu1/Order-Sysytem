package com.spring.ordersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@AllArgsConstructor
public class RestaurantRegisterDto {
    private String name;
    private int minOrderPrice;
    private int deliveryFee;
}
