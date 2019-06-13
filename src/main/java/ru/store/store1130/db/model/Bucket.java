package ru.store.store1130.db.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "bucket")
@Data
@Accessors(chain = true)
public class Bucket {
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

}
