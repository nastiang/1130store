package ru.store.store1130.db.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Accessors(chain = true)
@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "name")
    @JsonView(Views.NoOrders.class)
    private String nameOfProduct;

    @Column(name = "price")
    @JsonView(Views.NoOrders.class)
    private BigDecimal price;

    @Column(name = "cost")
    @JsonView(Views.NoOrders.class)
    private BigDecimal cost;

    @Column(name = "count")
    @JsonView(Views.NoOrders.class)
    private int count;

    @ManyToOne
    @JoinColumn(name = "product_category_id", referencedColumnName = "id")
    @JsonView(Views.NoOrders.class)
    private ProductCategory productCategory;

    @ManyToMany(mappedBy = "products")
    @JsonIdentityInfo(
            property = "id",
            generator = ObjectIdGenerators.PropertyGenerator.class
    )
    private Set<SalesOrder> salesOrders;
}
