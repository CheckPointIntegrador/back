package br.com.dh.ecommerce.dto;

import br.com.dh.ecommerce.persistence.entities.CategoryEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto {
    private Integer id;
    private String name;

    public CategoryDto(){}

    public CategoryDto(CategoryEntity category){
        this.id = category.getId();
        this.name = category.getName();
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
               "id=" + id +
               ", name='" + name + '\'' +
               '}';
    }
}
