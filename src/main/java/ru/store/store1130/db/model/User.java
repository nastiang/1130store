package ru.store.store1130.db.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Accessors(chain = true)
@Entity
@Table(name = "usr")
@Data

public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "email")
    //@JsonView(Views.NoOrders.class)
    private String email;

    @Column(name = "enabled", nullable = false)
    //@JsonView(Views.NoOrders.class)
    private boolean enabled;

    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    //@JsonView(Views.NoOrders.class)
    private UserRole role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<UserRole> roles = new HashSet<>();
        roles.add(getRole());
        return roles;
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
