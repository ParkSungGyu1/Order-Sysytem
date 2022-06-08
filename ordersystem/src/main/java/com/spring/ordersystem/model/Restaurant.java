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
@Table(name = "restaurant")
@NoArgsConstructor(access = AccessLevel.PROTECTED) // protected로 생성자 만들기
public class Restaurant {
    @Id
    @GeneratedValue
    @Column(name = "restaurant_id")
    private Long id;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Menu> menus = new ArrayList<>();

    private String restaurantName;
    private int minOrderPrice;
    private int deliveryFee;

    //==연관관계 메서드==//
    public void addMenu(Menu menu) {
        menus.add(menu);
        menu.setRestaurant(this);
    }


    //==생성 메서드==//
    public static Restaurant createRestaurant(String restaurantName, int minOrderPrice, int deliveryFee){
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName(restaurantName);
        restaurant.setMinOrderPrice(minOrderPrice);
        restaurant.setDeliveryFee(deliveryFee);
        return restaurant;
    }

    public static Restaurant createMenu(Menu... menus){
        Restaurant restaurant = new Restaurant();
        for (Menu menu : menus){
            restaurant.addMenu(menu);
        }
        return restaurant;
    }

}
