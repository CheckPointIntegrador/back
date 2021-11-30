package br.com.dh.ecommerce.controller;

import br.com.dh.ecommerce.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ctdcommerce.com/products")
public class ProductController {


    //Método GET - 'https://ctdcommerce.com/products':
    // este end-point deverá disponibilizar os dados de todos os produtos cadastrados em um JSON
    @GetMapping
    public ResponseEntity<ProductDto> metodo(){
        return null;
    }

    //Método GET - https://ctdcommerce.com/products/1:
    // este end-point deverá disponibilizar os dados de um produto específico em um JSON
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> metodo2(@PathVariable Integer id){
        return null;
    }

}
