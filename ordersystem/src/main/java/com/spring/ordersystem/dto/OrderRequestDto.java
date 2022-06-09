package com.spring.ordersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
public class OrderRequestDto {
    private Long id;
    @Max(value = 100)
    @Min(value = 1)
    private int quantity;
}
