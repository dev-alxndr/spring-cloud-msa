package me.alxndr.orderservice.service;

import me.alxndr.orderservice.dto.OrderDto;

import java.util.List;

/**
 * @author : Alexander Choi
 * @date : 2022/11/20
 */
public interface OrderService {

    OrderDto createOrder(final OrderDto orderDto, String userId);

    List<OrderDto.ResponseOrder> getOrdersByUserId(final String userId);

    OrderDto.ResponseOrder getOrderByOrderId(final String orderId);
}
