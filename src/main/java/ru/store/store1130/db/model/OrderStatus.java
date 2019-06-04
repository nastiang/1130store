package ru.store.store1130.db.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "order_status")
@Data
@Accessors(chain = true)
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "name_of_status")
    private String nameOfStatus;

}
