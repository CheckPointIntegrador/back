package br.com.dh.ecommerce.controller;

import br.com.dh.ecommerce.dto.CategoryDto;
import br.com.dh.ecommerce.dto.ProductDto;
import br.com.dh.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //Método GET - https://ctdcommerce.com/products/categories:
    // este end-point deverá disponibilizar uma lista de categorias cadastradas em um JSON  com o formato que segue:
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> metodo(){
        return ResponseEntity.ok(categoryService.listCategories());
    }

    //Método GET - https://ctdcommerce.com/products/category/jewelery:
    // este end-point deverá disponibilizar os produtos de uma determinada categoria, em um JSON  com o formato a seguir:
    @GetMapping("/{type}")
    public ResponseEntity<Set<ProductDto>> metodo2(@PathVariable String type){
        return ResponseEntity.ok(categoryService.listProductsCategory(type));
    }

    @GetMapping("/add/{type}")
    public ResponseEntity<CategoryDto> createCategory(@PathVariable String type){
        return ResponseEntity.ok(categoryService.createCategory(type));
    }


}
