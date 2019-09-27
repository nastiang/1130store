package ru.store.store1130.service.security.jwt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.store.store1130.db.model.User;
import ru.store.store1130.service.UserService;

@Service
@Slf4j
public class JwtUserDatailService implements UserDetailsService {
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findByEmail(email);

        if( user == null){
            throw new UsernameNotFoundException("user name" + email + "not found");
        }

        JwtUser jwtUser = jwtUserFactory.create(user);

        log.info("IN loadUserByUsername user whith email{} loaded",email);

        return jwtUser;
    }
}
