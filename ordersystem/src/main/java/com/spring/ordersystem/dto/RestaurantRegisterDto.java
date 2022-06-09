package com.spring.ordersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


@Data
public class RestaurantRegisterDto {
    private String name;

    @Max(value = 100000, message = "10만원 이하로 입력 받아야합니다.")
    @Min(value = 1000, message = "1000원 이상으로 입력 받아야 합니다.")
    private int minOrderPrice;

    @Max(value = 10000, message = "만원 이하로 입력 받아야 합니다.")
    @Min(value = 0, message = "값을 입력하세요")
    private int deliveryFee;

    @AssertTrue(message = "500원 단위로 입력하세요.")
    private boolean feeCheck;

    public boolean deliveryFeeBound(){
        if(getDeliveryFee() % 500 == 0){
            return true;
        }else{
            return false;
        }
    }
    public RestaurantRegisterDto(String name, int minOrderPrice, int deliveryFee) {
        this.name = name;
        this.minOrderPrice = minOrderPrice;
        this.deliveryFee = deliveryFee;
        this.feeCheck = deliveryFeeBound();
    }
}
