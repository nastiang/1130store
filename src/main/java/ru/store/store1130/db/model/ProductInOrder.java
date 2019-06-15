package ru.store.store1130.db.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
@Accessors(chain = true)
@Entity
@Table(name = "bucket")
@Data

public class ProductInOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_id", referencedColumnName = "id" )
    private Product product;


    @Column
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sales_order_id", referencedColumnName = "id")
    private SalesOrder salesOrder;

    @Column
    private int quantity;

}
