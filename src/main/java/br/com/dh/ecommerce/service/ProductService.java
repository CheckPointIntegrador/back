package br.com.dh.ecommerce.service;

import br.com.dh.ecommerce.dto.ProductDto;
import br.com.dh.ecommerce.persistence.entities.ProductEntity;
import br.com.dh.ecommerce.persistence.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService{

    @Autowired
    private ProductRepository productRepository;

    public Optional<List<ProductEntity>> listCategory(String category){

        return productRepository.searchByCategory(category);
    }

    public ProductDto createProduct(ProductDto productDto){
        ProductEntity product = new ProductEntity(productDto);
        return new ProductDto(productRepository.save(product));
    }

    public ProductDto searchById(Integer id){
        ProductDto productDto = new ProductDto(productRepository.getById(id));
        return productDto;
    }

    public List<ProductDto> listAll(){
        List<ProductEntity> productEntityList = new ArrayList<>();
        productEntityList.addAll(productRepository.findAll());
        List<ProductDto> productDtoList = new ArrayList<>();
        productEntityList.forEach(productEntity -> {
            ProductDto productDto = new ProductDto(productEntity);
            productDtoList.add(productDto);
        });

        return productDtoList;
    }
}
