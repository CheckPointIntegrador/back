package br.com.dh.ecommerce.dto;

import br.com.dh.ecommerce.persistence.entities.ProductEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {

    private Integer id;
    private String title;
    private Double price;
    private String description;
    private String imageUrl;
    private String category;

    public ProductDto(ProductEntity product){
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.imageUrl = product.getImageUrl();
        this.category = product.getCategory().getName();
    }


}
