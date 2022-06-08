package com.spring.ordersystem.service;

import com.spring.ordersystem.dto.OrderRequestDto;
import com.spring.ordersystem.dto.OrderResponse;
import com.spring.ordersystem.dto.OrderResponseDto;
import com.spring.ordersystem.model.Menu;
import com.spring.ordersystem.model.Order;
import com.spring.ordersystem.model.OrderItem;
import com.spring.ordersystem.model.Restaurant;
import com.spring.ordersystem.repository.MenuRepository;
import com.spring.ordersystem.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final MenuRepository menuRepository;
    @Transactional
    public void order(List<OrderRequestDto> orderRequestDto){
        List<OrderItem> orderItem = new ArrayList<>();
        int fee = 0;
        for(OrderRequestDto request : orderRequestDto){
            Menu menu = menuRepository.findOne(request.getId());
            orderItem.add(OrderItem.createOrderItem(menu,menu.getFoodPrice(),request.getQuantity()));
            fee = menu.getRestaurant().getDeliveryFee();
        }
        Order order = Order.createOrder(fee, orderItem);
        orderRepository.order(order);

    }

    public OrderResponse findOrder() {
        OrderResponse orderResponse = orderRepository.findOrder();
        List<OrderResponseDto> all = orderRepository.findAll();
        orderResponse.setFoods(all);
        return orderResponse;
    }
}
