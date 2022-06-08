package com.spring.ordersystem.repository;

import com.spring.ordersystem.model.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RestaurantRepository {
    private final EntityManager em;

    //레스토랑 등록
    public void save(Restaurant restaurant){
        em.persist(restaurant);
    }
    //레스토랑 조회
    public Restaurant findOne(Long id){
        return em.find(Restaurant.class, id);
    }

    public List<Restaurant> findAll() {
        return em.createQuery("select r from Restaurant r", Restaurant.class).getResultList();
    }
}
