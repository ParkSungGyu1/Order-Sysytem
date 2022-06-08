package com.spring.ordersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MenuResponse {
    private Long id;
    private String name;
    private int price;
}
