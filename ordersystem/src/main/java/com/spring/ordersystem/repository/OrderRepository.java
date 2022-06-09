package com.spring.ordersystem.repository;

import com.spring.ordersystem.dto.OrderResponse;
import com.spring.ordersystem.dto.OrderResponseDto;
import com.spring.ordersystem.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {
    private final EntityManager em;

    public void order(Order order){
        em.persist(order);
    }

    public OrderResponse findOrder(){
          return em.createQuery("select new com.spring.ordersystem.dto.OrderResponse(r.restaurantName, r.deliveryFee, o.totalPrice)" +
                " from Order o"
                + " join o.orderItems i"
                + " join i.menu m"
                + " join m.restaurant r", OrderResponse.class)
                  .setMaxResults(1)
                  .getSingleResult();
    }

    public List<OrderResponseDto> findAll(){
            return em.createQuery("select new com.spring.ordersystem.dto.OrderResponseDto(m.foodName,i.quantity,i.orderPrice)"
                + " from Order o"
                + " join o.orderItems i"
                + " join i.menu m"
                + " join m.restaurant r", OrderResponseDto.class)
                    .getResultList();
    }
}
