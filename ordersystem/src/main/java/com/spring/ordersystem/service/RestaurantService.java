package com.spring.ordersystem.service;

import com.spring.ordersystem.dto.RestaurantRegisterDto;
import com.spring.ordersystem.dto.RestaurantResponse;
import com.spring.ordersystem.model.Restaurant;
import com.spring.ordersystem.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    //레스토랑 등록
    @Transactional
    public void save(RestaurantRegisterDto restaurantRegisterDto){
        Restaurant restaurant = Restaurant.createRestaurant(restaurantRegisterDto.getName(),restaurantRegisterDto.getMinOrderPrice(),restaurantRegisterDto.getDeliveryFee());
        restaurantRepository.save(restaurant);
    }

    //레스토랑 조회
    public Restaurant findOne(Long id){
        return restaurantRepository.findOne(id);
    }

    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }
}
