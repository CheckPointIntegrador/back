package br.com.dh.ecommerce.service.impl;

import br.com.dh.ecommerce.model.CategoryModel;
import br.com.dh.ecommerce.persistence.entities.CategoryEntity;
import br.com.dh.ecommerce.persistence.repository.CategoryRepository;
import br.com.dh.ecommerce.service.IecommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService implements IecommerceService<CategoryModel> {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public CategoryModel searchById(Integer id){
        return new CategoryModel(categoryRepository.getById(id));
    }

    @Override
    public List<CategoryModel>listAll(){
        List<CategoryEntity> listEntities = new ArrayList<>();
        listEntities.addAll(categoryRepository.findAll());
        List<CategoryModel> listModel = new ArrayList<>();
        listEntities.forEach(categoryEntity -> {
            CategoryModel productDto = new CategoryModel(categoryRepository.getById(categoryEntity.getId()));
            listModel.add(productDto);
        });
        return listModel;
    }

    public List<String>listAllCategoryName(){
        return categoryRepository.findAllCategoryName();
    }

    public CategoryModel save(CategoryModel categoryModel){
        CategoryEntity category = categoryRepository.save(new CategoryEntity(categoryModel));
        return new CategoryModel(category);
    }

}
