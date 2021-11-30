package br.com.dh.ecommerce.persistence.repository;

import br.com.dh.ecommerce.persistence.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutRepository extends JpaRepository<ProductEntity, Integer> {
}
