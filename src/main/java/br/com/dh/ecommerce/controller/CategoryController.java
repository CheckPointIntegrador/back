package br.com.dh.ecommerce.controller;

import br.com.dh.ecommerce.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ctdcommerce.com/products")
public class CategoryController {

    //Método GET - https://ctdcommerce.com/products/categories:
    // este end-point deverá disponibilizar uma lista de categorias cadastradas em um JSON  com o formato que segue:
    @GetMapping("/categories")
    public ResponseEntity<ProductDto> metodo(){
        return null;
    }

    //Método GET - https://ctdcommerce.com/products/category/jewelery:
    // este end-point deverá disponibilizar os produtos de uma determinada categoria, em um JSON  com o formato a seguir:
    @GetMapping("/category/{type}")
    public ResponseEntity<ProductDto> metodo2(@PathVariable String type){
        return null;
    }
}
