package br.com.dh.ecommerce.service.impl;

import br.com.dh.ecommerce.dto.ProductDto;
import br.com.dh.ecommerce.model.ProductModel;
import br.com.dh.ecommerce.persistence.entities.ProductEntity;
import br.com.dh.ecommerce.persistence.repository.CategoryRepository;
import br.com.dh.ecommerce.persistence.repository.ProductRepository;
import br.com.dh.ecommerce.service.IecommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IecommerceService<ProductDto> {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public List<ProductDto>searchByCategoryName(String category){
        return productRepository.searchByCategoryName(category)
                .stream()
                .map(ProductDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto searchById(Integer id){
        return new ProductDto(productRepository.getById(id));
    }

    public List<ProductDto> searchByCategoryOrTitle(String input){
        return productRepository.searchByCategoryOrTitle(input)
                .stream()
                .map(ProductDto::new)
                .collect(Collectors.toList());
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

    public ProductModel save(ProductModel productModel){
        ProductEntity product = new ProductEntity(productModel);
        product.setCategory(categoryRepository.getById(productModel.getCategory().getId()));
        return new ProductModel(productRepository.save(product));
    }

}
