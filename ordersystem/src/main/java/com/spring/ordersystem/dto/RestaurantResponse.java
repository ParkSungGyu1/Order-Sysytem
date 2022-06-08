package com.spring.ordersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@AllArgsConstructor
public class RestaurantResponse {
    private Long id;
    private String name;
    private int minOrderPirce;
    private int deliveryFee;
}
