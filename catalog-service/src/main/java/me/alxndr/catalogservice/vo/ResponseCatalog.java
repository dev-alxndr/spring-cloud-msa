package me.alxndr.catalogservice.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author : Alexander Choi
 * @date : 2022/11/17
 */
@Data
public class ResponseCatalog {

    private String productId;
    private String productName;
    private Integer unitPrice;
    private Integer stock;
    private LocalDateTime createdAt;

}
