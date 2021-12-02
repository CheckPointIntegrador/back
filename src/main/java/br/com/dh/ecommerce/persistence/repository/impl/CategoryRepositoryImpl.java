package br.com.dh.ecommerce.persistence.repository.impl;

import br.com.dh.ecommerce.persistence.repository.CategoryRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public abstract class CategoryRepositoryImpl implements CategoryRepository {
    @Query("SELECT c.name FROM CategoryEntity c")
    public abstract List<String> findAllCategoryName();
}
