package br.com.dh.ecommerce.persistence.entities;

import br.com.dh.ecommerce.model.CategoryModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 50, nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private Set<ProductEntity> products = new HashSet<>();

    public CategoryEntity(){}

    public CategoryEntity(CategoryModel category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", products=" + products +
               '}';
    }
}
