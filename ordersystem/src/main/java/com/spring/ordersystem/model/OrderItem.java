package com.spring.ordersystem.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "order_items")
@NoArgsConstructor(access = AccessLevel.PROTECTED) // protected로 생성자 만들기
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    private int quantity;
    private int orderPrice;

    //==생성 메서드==//
    public static OrderItem createOrderItem(Menu menu, int foodPrice, int quantity){
        OrderItem orderItem = new OrderItem();
        orderItem.setMenu(menu);
        orderItem.setOrderPrice(foodPrice*quantity);
        orderItem.setQuantity(quantity);
        return orderItem;
    }

}
