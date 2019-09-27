package ru.store.store1130.db.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.List;
import java.util.Set;
@Accessors(chain = true)
@Entity
@Table(name = "usr")
@Data

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "roles",
    joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_role_id", referencedColumnName = "id")})
    private List<UserRole> roles;


}
