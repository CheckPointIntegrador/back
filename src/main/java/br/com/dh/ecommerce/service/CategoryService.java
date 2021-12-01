package br.com.dh.ecommerce.service;

import br.com.dh.ecommerce.dto.CategoryDto;
import br.com.dh.ecommerce.dto.ProductDto;
import br.com.dh.ecommerce.persistence.entities.CategoryEntity;
import br.com.dh.ecommerce.persistence.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDto createCategory(String nameCategory){
        CategoryEntity category = new CategoryEntity();
        category.setName(nameCategory);
        return new CategoryDto(categoryRepository.save(category));
    }

    public List<CategoryDto>  listCategories(){
        List<CategoryEntity> listEntities = new ArrayList<>();
        listEntities.addAll(categoryRepository.findAll());
        List<CategoryDto> listDto = new ArrayList<>();
        listEntities.forEach( categoryEntity -> {
            CategoryDto productDto = new CategoryDto(categoryRepository.getById(categoryEntity.getId()));
            listDto.add(productDto);
        });
        return listDto;
    }

    public Set<ProductDto> listProductsCategory(String typeCategory){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(typeCategory);
        CategoryEntity category = new CategoryEntity(categoryDto);
        CategoryEntity getCategory = categoryRepository.getById(category.getId());

        Set<ProductDto> productDtoSet = new HashSet<>();
        getCategory.getProducts().forEach( productEntity -> {
            ProductDto productDto = new ProductDto(productEntity);
            productDtoSet.add(productDto);
        });

        return productDtoSet;
    }
}
