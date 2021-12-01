package br.com.dh.ecommerce.persistence.repository.impl;

import br.com.dh.ecommerce.dto.ProductDto;
import br.com.dh.ecommerce.persistence.entities.ProductEntity;
import br.com.dh.ecommerce.persistence.repository.ProductRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public abstract class ProductRepositoryImpl implements ProductRepository {
    @Query("SELECT p FROM products p WHERE p.category_id = ?1")
    public abstract Optional<List<ProductEntity>> searchByCategory(String type);
}
