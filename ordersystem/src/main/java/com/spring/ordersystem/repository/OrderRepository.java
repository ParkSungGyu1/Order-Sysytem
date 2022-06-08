package com.spring.ordersystem.repository;

import com.spring.ordersystem.model.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class OrderRepository {
    private final EntityManager em;


}
