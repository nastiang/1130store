package ru.store.store1130.db.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;

@Entity
@Table(name = "sales_order")
@Data
@Accessors(chain = true)
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

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private LinkedHashMap<Long,Integer> salesBucket;

    @ManyToOne
    @JoinColumn(name = "order_status_id", referencedColumnName = "id")
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "order_category_id", referencedColumnName = "id")
    private OrderCategory orderCategory;

}
