package me.alxndr.orderservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.alxndr.orderservice.dto.OrderDto;
import me.alxndr.orderservice.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Alexander Choi
 * @date : 2022/11/20
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/order-service")
public class OrderController {

    private final Environment env;
    private final OrderService orderService;
    private final ModelMapper mapper;


    @PostMapping("/{userId}/orders")
    public ResponseEntity<OrderDto.ResponseOrder> createOrder(@PathVariable final String userId,
                                                              @RequestBody final OrderDto.RequestOrder requestOrder) {

        OrderDto orderDto = mapper.map(requestOrder, OrderDto.class);
        final OrderDto createdOrder = orderService.createOrder(orderDto, userId);

        final OrderDto.ResponseOrder responseOrder = mapper.map(createdOrder, OrderDto.ResponseOrder.class);

        return ResponseEntity.ok(responseOrder);
    }

    @GetMapping("/{userId}/orders")
    public ResponseEntity<List<OrderDto.ResponseOrder>> getOrdersByUserId(@PathVariable final String userId) {

        final List<OrderDto.ResponseOrder> ordersByUserId = orderService.getOrdersByUserId(userId);

        return ResponseEntity.ok(ordersByUserId);
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<OrderDto.ResponseOrder> getOrderByOrderId(@PathVariable final String orderId) {

        final OrderDto.ResponseOrder orderByOrderId = orderService.getOrderByOrderId(orderId);

        return ResponseEntity.ok(orderByOrderId);

    }



    @GetMapping("/health-check")
    public String status() {
        return String.format("Order Service is UP! on PORT %s", env.getProperty("local.server.port"));
    }



}
