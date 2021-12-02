package br.com.dh.ecommerce.model;

import br.com.dh.ecommerce.persistence.entities.CategoryEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CategoryModel {
    private Integer id;
    private String name;


    public CategoryModel(CategoryEntity category){
        this.id = category.getId();
        this.name = category.getName();
    }

}
