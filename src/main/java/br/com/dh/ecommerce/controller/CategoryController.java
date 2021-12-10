package br.com.dh.ecommerce.controller;

import br.com.dh.ecommerce.model.CategoryModel;
import br.com.dh.ecommerce.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<String>> defaultEndpoint(){
        List<String> endPoints = new ArrayList<>();
        endPoints.add("/categories");
        endPoints.add("/products");
        endPoints.add("/products/{id}");
        endPoints.add("/products/category/{category}");
        endPoints.add("/products/search/{input}");
        return ResponseEntity.ok(endPoints);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/categories")
    public ResponseEntity<List<String>> listCategories(){
        List<String> categoryDtos = categoryService.listAllCategoryName();
        if(!categoryDtos.isEmpty())
            return ResponseEntity.ok(categoryDtos);
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/add")
    public ResponseEntity<CategoryModel> createCategory(@RequestBody CategoryModel categoryDto){
        return ResponseEntity.ok(categoryService.save(categoryDto));
    }

}
