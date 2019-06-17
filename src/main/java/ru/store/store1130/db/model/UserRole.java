package ru.store.store1130.db.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
@Data
@Accessors(chain = true)
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "name_of_role")
    @JsonView(Views.NoOrders.class)
    private String nameOfRole;


}
