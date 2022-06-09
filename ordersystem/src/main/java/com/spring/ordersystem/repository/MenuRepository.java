package com.spring.ordersystem.repository;


import com.spring.ordersystem.model.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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

    public Menu findOne(Long menuId){
        return em.find(Menu.class, menuId);
    }

    public Menu findByName(String menuName){
        try {
            return em.createQuery(" select  m from Menu m where m.foodName = :menuName",Menu.class)
                    .setParameter("menuName", menuName)
                    .getSingleResult();
        }catch (NoResultException e){
            return null;
        }

    }
}
