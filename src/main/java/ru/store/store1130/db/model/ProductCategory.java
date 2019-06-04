package ru.store.store1130.db.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "product_category")
@Data
@Accessors(chain = true)

public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "name_of_product_category")
    private String nameOfProductCategory;
}
