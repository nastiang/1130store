package ru.store.store1130.db.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


import javax.persistence.*;
@Accessors(chain = true)
@Entity
@Table(name = "order_category")
@Data

public class OrderCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "name_of_category")
    private String nameOfCategory;
}
