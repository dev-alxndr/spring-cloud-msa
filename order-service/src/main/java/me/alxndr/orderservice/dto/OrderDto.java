package me.alxndr.orderservice.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author : Alexander Choi
 * @date : 2022/11/20
 */
@Data
public class OrderDto {

    private String productId;
    private Integer quantity;
    private Integer unitPrice;
    private Integer totalPrice;

    private String orderId;
    private String userId;

    public Integer calculateTotalPrice() {
        return this.unitPrice * this.quantity;
    }

    @Data
    public static class RequestOrder {
        private String productId;
        private Integer quantity;
        private Integer unitPrice;
    }

    @Data
    public static class ResponseOrder {
        private String productId;
        private Integer quantity;
        private Integer unitPrice;
        private Integer totalPrice;
        private String orderId;
        private LocalDateTime createdAt;
    }

}
