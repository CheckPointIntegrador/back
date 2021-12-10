package br.com.dh.ecommerce.persistence.repository;

import br.com.dh.ecommerce.persistence.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    List<ProductEntity> searchByCategoryName(String category);

    @Query("SELECT p FROM ProductEntity p WHERE p.category LIKE CONCAT('%', :input, '%') OR p.title LIKE CONCAT('%', :input, '%')")
    List<ProductEntity> searchByCategoryOrTitle(String input);

}
