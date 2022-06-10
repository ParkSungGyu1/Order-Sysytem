package com.spring.ordersystem.service;

import com.spring.ordersystem.dto.MenuRegisterDto;
import com.spring.ordersystem.model.Menu;
import com.spring.ordersystem.model.Restaurant;
import com.spring.ordersystem.repository.MenuRepository;
import com.spring.ordersystem.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;

    //메뉴 저장
    @Transactional
    public void save(List<MenuRegisterDto> menuRegisters, Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findOne(restaurantId);
        for(MenuRegisterDto menuRegister:menuRegisters){
            Menu menu = Menu.createMenu(restaurant,menuRegister.getName(), menuRegister.getPrice());
            Menu byName = menuRepository.findByName(menu.getFoodName(), restaurantId);
            if (byName == null){
                menuRepository.save(menu);
            }else {
                throw new IllegalArgumentException("해당 메뉴가 존재합니다.");
            }

        }
    }
    //메뉴 조회
    public List<Menu> findAll(Long restaurantId){
        return menuRepository.findAll(restaurantId);
    }
}
