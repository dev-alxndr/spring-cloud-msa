package me.alxndr.catalogservice.service;

import me.alxndr.catalogservice.entity.Catalog;
import me.alxndr.catalogservice.vo.ResponseCatalog;
import org.springframework.stereotype.Service;

/**
 * @author : Alexander Choi
 * @date : 2022/11/17
 */
public interface CatalogService {

    Iterable<ResponseCatalog> getAllCatalogs();

}
