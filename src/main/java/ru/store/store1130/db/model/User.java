package ru.store.store1130.db.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usr")
@Data
@Accessors(chain = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "email")
    @JsonView(Views.NoOrders.class)
    private String email;

    @Column(name = "enabled", nullable = false)
    @JsonView(Views.NoOrders.class)
    private boolean enabled;

    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @JsonView(Views.NoOrders.class)
    private UserRole role;


}
