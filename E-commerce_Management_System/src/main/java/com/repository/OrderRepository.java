package com.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer>{

    List<Order> findByUserEid(int eid);

    List<Order> findByProductPid(int pid);
}