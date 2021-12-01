package br.com.dh.ecommerce.controller;

import br.com.dh.ecommerce.dto.ProductDto;
import br.com.dh.ecommerce.persistence.entities.ProductEntity;
import br.com.dh.ecommerce.service.ProductService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    //Método GET - 'https://ctdcommerce.com/products':
    // este end-point deverá disponibilizar os dados de todos os produtos cadastrados em um JSON
    @GetMapping
    public ResponseEntity<List<ProductDto>> metodo(){
        return ResponseEntity.ok(productService.listAll());
    }

    //Método GET - https://ctdcommerce.com/products/1:
    // este end-point deverá disponibilizar os dados de um produto específico em um JSON
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> metodo2(@PathVariable Integer id){
        return ResponseEntity.ok(productService.searchById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<ProductDto> createProduct (@RequestBody ProductDto productDto){
        return ResponseEntity.ok(productService.createProduct(productDto));
    }

    @GetMapping("/category/{type}")
    public ResponseEntity<Optional<List<ProductEntity>>> findByCategory(@PathVariable String type){
        return ResponseEntity.ok(productService.listCategory(type));
    }
}
