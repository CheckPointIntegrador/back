package br.com.dh.ecommerce.persistence.repository.impl;

import br.com.dh.ecommerce.persistence.entities.ProductEntity;
import br.com.dh.ecommerce.persistence.repository.ProductRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public abstract class ProductRepositoryImpl implements ProductRepository {
//    @Query("SELECT p FROM ProductEntity p WHERE p.category.name = ?1")/
    public abstract List<ProductEntity> searchByCategoryName(String category);

}
