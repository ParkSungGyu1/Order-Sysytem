package com.spring.ordersystem.controller;

import com.spring.ordersystem.dto.JsonResult;
import com.spring.ordersystem.dto.MenuRegisterDto;
import com.spring.ordersystem.dto.MenuResponse;
import com.spring.ordersystem.model.Menu;
import com.spring.ordersystem.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void save(@RequestBody List<MenuRegisterDto> menuRegisters, @PathVariable Long restaurantId){
        menuService.save(menuRegisters, restaurantId);
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public JsonResult findAll(@PathVariable Long restaurantId){
        List<Menu> menus = menuService.findAll(restaurantId);

        List<MenuResponse> collect = menus.stream()
                .map(m -> new MenuResponse(m.getId(), m.getFoodName(), m.getFoodPrice()))
                .collect(Collectors.toList());

        return new JsonResult(collect);
    }
}
