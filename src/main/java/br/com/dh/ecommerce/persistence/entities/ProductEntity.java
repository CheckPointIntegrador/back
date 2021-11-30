package br.com.dh.ecommerce.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class ProductEntity {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
}
