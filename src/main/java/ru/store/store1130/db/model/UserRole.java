package ru.store.store1130.db.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;


import javax.persistence.*;
@Accessors(chain = true)
@Entity
@Table(name = "user_role")
@Data

public class UserRole implements GrantedAuthority{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "name_of_role")
    //@JsonView(Views.NoOrders.class)
    private String nameOfRole;


    @Override
    public String getAuthority() {
        return getNameOfRole();
    }
}
