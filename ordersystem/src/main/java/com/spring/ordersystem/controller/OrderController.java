package com.spring.ordersystem.controller;

import com.spring.ordersystem.dto.OrderRequest;
import com.spring.ordersystem.dto.OrderRequestDto;
import com.spring.ordersystem.dto.OrderResponse;
import com.spring.ordersystem.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/order/request")
    public void order(@RequestBody OrderRequest orderRequest){
        orderService.order(orderRequest.getFoods());
    }

    @GetMapping("/orders")
    public OrderResponse findOrder(){
        return orderService.findOrder();
    }

}
