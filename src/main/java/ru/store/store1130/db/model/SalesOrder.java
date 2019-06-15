package ru.store.store1130.db.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
@Accessors(chain = true)
@Entity
@Table(name = "sales_order")
@Data

public class SalesOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime date;

    @Column(name = "sum")
    private BigDecimal sum;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", referencedColumnName = "id" )
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_in_order_id", referencedColumnName = "id")
    private List<ProductInOrder> productInOrders;

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private SalesOrderStatus status;

    @ManyToOne
    @JoinColumn(name = "order_category_id", referencedColumnName = "id")
    private OrderCategory orderCategory;

}
