package br.com.dh.ecommerce.persistence.repository;

import br.com.dh.ecommerce.persistence.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    @Query("SELECT c.name FROM CategoryEntity c")
    List<String> findAllCategoryName();
}
