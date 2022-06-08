package com.spring.ordersystem.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED) // protected로 생성자 만들기
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    private int totalPrice;

    //==연관관계 메서드==//
    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    //==생성 메서드==//
    public static Order createOrder(int deliveryFee, List<OrderItem> orderItems){
        Order order = new Order();
        int price = 0;
        for(OrderItem orderItem : orderItems){
            order.addOrderItem(orderItem);
            price += orderItem.getOrderPrice();
        }

        order.setTotalPrice(price+deliveryFee);
        return order;
    }
}
