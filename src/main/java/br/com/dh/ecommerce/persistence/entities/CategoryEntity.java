package br.com.dh.ecommerce.persistence.entities;

import br.com.dh.ecommerce.dto.CategoryDto;
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
    @SequenceGenerator(name = "sequenceCategory", sequenceName = "sequenceCategory", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceCategory")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private Set<ProductEntity> products = new HashSet<>();

    public CategoryEntity(){}

    public CategoryEntity(CategoryDto category) {
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
