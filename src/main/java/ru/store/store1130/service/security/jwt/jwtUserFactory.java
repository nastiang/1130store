package ru.store.store1130.service.security.jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ru.store.store1130.db.model.User;
import ru.store.store1130.db.model.UserRole;
import ru.store.store1130.service.security.jwt.JwtUser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class jwtUserFactory {

    public jwtUserFactory() {
    }

    public static JwtUser create(User user){
        return new JwtUser(user.getEmail(), user.getPassword(), user.getId(), mapToGrantedAuthority(new ArrayList<>(user.getRoles())));
    }

    public static List<GrantedAuthority> mapToGrantedAuthority(List<UserRole> userRoles){
        return
                userRoles.stream().
                        map(nameOfRole -> new SimpleGrantedAuthority(nameOfRole.getNameOfRole())).
                        collect(Collectors.toList());
    }

}
