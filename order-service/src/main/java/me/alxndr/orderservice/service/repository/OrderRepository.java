package me.alxndr.orderservice.service.repository;

import me.alxndr.orderservice.service.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : Alexander Choi
 * @date : 2022/11/17
 */
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    Order findByOrderId(final String productId);

    List<Order> findByUserId(String userId);
}
