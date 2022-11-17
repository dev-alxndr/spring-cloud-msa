package me.alxndr.catalogservice.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : Alexander Choi
 * @date : 2022/11/17
 */
@Data
public class CatalogDto implements Serializable {

    private String productId;
    private Integer quantity;
    private Integer unitPrice;
    private Integer totalPrice;

    private String orderId;
    private String userId;
}
