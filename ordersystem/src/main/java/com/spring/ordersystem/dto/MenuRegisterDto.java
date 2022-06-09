package com.spring.ordersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class MenuRegisterDto {
    private Long restaurantId;
    private String name;
    @Max(value = 1000000)
    @Min(value = 100)
    private int price;

    @AssertTrue(message = "100원 단위로 입력하세요.")
    private boolean priceCheck;

    public boolean priceBound(){
        if(getPrice() % 100 == 0){
            return true;
        }else{
            return false;
        }
    }

    public MenuRegisterDto(Long restaurantId, String name, int price, boolean priceCheck) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.price = price;
        this.priceCheck = priceBound();
    }
}
