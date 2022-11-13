package me.alxndr.userservice.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * @author : Alexander Choi
 * @date : 2022/11/13
 */
@Data
public class ResponseOrder {

    private String productId;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;
    private LocalDateTime createdAt;

    private String orderId;

}
