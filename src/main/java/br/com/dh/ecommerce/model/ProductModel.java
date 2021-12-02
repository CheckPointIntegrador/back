package br.com.dh.ecommerce.model;

import br.com.dh.ecommerce.persistence.entities.ProductEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductModel {

    private Integer id;
    private String title;
    private Double price;
    private String description;
    private String imageUrl;
    private CategoryModel category;


    public ProductModel(ProductEntity product){
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.imageUrl = product.getImageUrl();
        this.category = new CategoryModel(product.getCategory());
    }

}
