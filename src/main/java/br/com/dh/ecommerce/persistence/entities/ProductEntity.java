package br.com.dh.ecommerce.persistence.entities;

import br.com.dh.ecommerce.model.ProductModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Column(name = "price")
    private Double price;

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "image", columnDefinition = "TEXT", nullable = false)
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    public ProductEntity(){}

    public ProductEntity(ProductModel product){
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.imageUrl = product.getImageUrl();
        this.category = new CategoryEntity(product.getCategory());
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
               "id=" + id +
               ", title='" + title + '\'' +
               ", price=" + price +
               ", description='" + description + '\'' +
               ", imageUrl='" + imageUrl + '\'' +
               ", category=" + category +
               '}';
    }
}
