package br.com.dh.ecommerce.controller;

import br.com.dh.ecommerce.model.ProductModel;
import br.com.dh.ecommerce.dto.ProductDto;
import br.com.dh.ecommerce.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> listAllProducts(){
        List<ProductDto> productDtoList = productService.listAll();
        if(!productDtoList.isEmpty())
            return ResponseEntity.ok(productDtoList);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findProductById(@PathVariable Integer id){
        ProductDto productDto = productService.searchById(id);
        if(productDto!=null)
            return ResponseEntity.ok(productDto);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<ProductDto>>searchByCategory(@PathVariable String category){
        List<ProductDto> productDtoList = productService.searchByCategoryName(category);
        if(!productDtoList.isEmpty())
            return ResponseEntity.ok(productDtoList);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/add")
    public ResponseEntity<ProductModel> createProduct(@RequestBody ProductModel productModel){
        return ResponseEntity.ok(productService.save(productModel));
    }
}
