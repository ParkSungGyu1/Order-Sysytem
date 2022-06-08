package com.spring.ordersystem.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "menu")
@NoArgsConstructor(access = AccessLevel.PROTECTED) // protected로 생성자 만들기
public class Menu {
    @Id
    @GeneratedValue
    @Column(name = "menu_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    private String foodName;
    private String foodprice;

    //==생성 메서드==//
    public static Menu createMenu(String foodName, String foodprice){
        Menu menu = new Menu();
        menu.setFoodprice(foodprice);
        menu.setFoodName(foodName);
        return menu;
    }
}
