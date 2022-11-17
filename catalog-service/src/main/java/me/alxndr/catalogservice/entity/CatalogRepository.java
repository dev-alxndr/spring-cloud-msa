package me.alxndr.catalogservice.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Alexander Choi
 * @date : 2022/11/17
 */
@Repository
public interface CatalogRepository extends CrudRepository<Catalog, Long> {

    Catalog findByProductId(final String productId);

}
