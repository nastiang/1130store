package ru.store.store1130.db.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Accessors(chain = true)
@Entity
@Table(name = "sales_order")
@Data
@JsonIdentityInfo(
        property = "id",
        generator = ObjectIdGenerators.PropertyGenerator.class
)
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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "product_in_order",
            joinColumns = { @JoinColumn(name = "sales_order_id")},
            inverseJoinColumns = { @JoinColumn(name = "product_id")}
    )
    private List<Product> products;

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private SalesOrderStatus status;

    @ManyToOne
    @JoinColumn(name = "order_category_id", referencedColumnName = "id")
    private OrderCategory orderCategory;

    @Column(name = "order_type")
    @Enumerated(EnumType.STRING)
    private OrderType orderType;
}
