package com.spring.ordersystem.repository;


import com.spring.ordersystem.model.Menu;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MenuRepository {
    private final EntityManager em;

    //메뉴 저장
    public void save(Menu menu){
        em.persist(menu);
    }

    public List<Menu> findAll(Long restaurantId){
        return em.createQuery("select m from Menu m where m.restaurant.id = :restaurantId", Menu.class)
                .setParameter("restaurantId", restaurantId)
                .getResultList();
    }
}
