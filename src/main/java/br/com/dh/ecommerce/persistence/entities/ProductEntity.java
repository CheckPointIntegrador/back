package br.com.dh.ecommerce.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "price")
    private Double price;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "image")
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
    
}
