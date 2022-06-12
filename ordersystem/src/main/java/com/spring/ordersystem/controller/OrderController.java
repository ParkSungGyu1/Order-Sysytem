package com.spring.ordersystem.controller;

import com.spring.ordersystem.dto.OrderRequest;
import com.spring.ordersystem.dto.OrderRequestDto;
import com.spring.ordersystem.dto.OrderResponse;
import com.spring.ordersystem.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/order/request")
    public void order(@RequestBody @Valid OrderRequest orderRequest){
        orderService.order(orderRequest.getFoods());
    }

    @GetMapping("/orders")
    public OrderResponse findOrder(){
        return orderService.findOrder();
    }

}
