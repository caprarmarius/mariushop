package com.example.mariushop.repositories;

import com.example.mariushop.enteties.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
