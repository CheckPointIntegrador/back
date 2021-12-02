package br.com.dh.ecommerce.controller;

import br.com.dh.ecommerce.model.CategoryModel;
import br.com.dh.ecommerce.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<String>> listCategories(){
        List<String> categoryDtos = categoryService.listAllCategoryName();
        if(!categoryDtos.isEmpty())
            return ResponseEntity.ok(categoryDtos);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/add")
    public ResponseEntity<CategoryModel> createCategory(@RequestBody CategoryModel categoryDto){
        return ResponseEntity.ok(categoryService.save(categoryDto));
    }

}
