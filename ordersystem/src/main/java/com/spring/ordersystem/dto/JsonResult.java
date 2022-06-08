package com.spring.ordersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JsonResult<T> {
    private T data;
}
