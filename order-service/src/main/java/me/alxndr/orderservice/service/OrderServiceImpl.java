package me.alxndr.orderservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.alxndr.orderservice.dto.OrderDto;
import me.alxndr.orderservice.service.entity.Order;
import me.alxndr.orderservice.service.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author : Alexander Choi
 * @date : 2022/11/20
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper mapper;

    @Override
    public OrderDto createOrder(final OrderDto orderDto, final String userId) {
        orderDto.setUserId(userId);
        orderDto.setOrderId(UUID.randomUUID().toString());
        orderDto.setTotalPrice(orderDto.calculateTotalPrice());

        final Order newOrder = mapper.map(orderDto, Order.class);

        orderRepository.save(newOrder);

        return mapper.map(newOrder, OrderDto.class);
    }

    @Override
    public List<OrderDto.ResponseOrder> getOrdersByUserId(final String userId) {

        final List<Order> orders = orderRepository.findByUserId(userId);

        return orders.stream()
                .map(o -> mapper.map(o, OrderDto.ResponseOrder.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto.ResponseOrder getOrderByOrderId(final String orderId) {
        final Order order = orderRepository.findByOrderId(orderId);
        return mapper.map(order, OrderDto.ResponseOrder.class);
    }
}
