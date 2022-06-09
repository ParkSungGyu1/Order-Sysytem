package com.spring.ordersystem.controller;

import com.spring.ordersystem.dto.JsonResult;
import com.spring.ordersystem.dto.RestaurantRegisterDto;
import com.spring.ordersystem.dto.RestaurantResponse;
import com.spring.ordersystem.model.Restaurant;
import com.spring.ordersystem.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping("/restaurant/register")
    public void save(@RequestBody @Valid RestaurantRegisterDto restaurantRegisterDto){
        restaurantService.save(restaurantRegisterDto);
    }

    @GetMapping("/restaurant")
    public JsonResult findAll(){
        List<Restaurant> findRt = restaurantService.findAll();

        List<RestaurantResponse> collect = findRt.stream()
                .map(m -> new RestaurantResponse(m.getId(), m.getRestaurantName(), m.getMinOrderPrice(), m.getDeliveryFee()))
                .collect(Collectors.toList());
        return new JsonResult(collect);
    }

}
