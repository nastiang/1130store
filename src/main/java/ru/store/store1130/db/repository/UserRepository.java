package ru.store.store1130.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.store.store1130.db.model.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository <User, Long> {

    Optional<User> findByEmailAndPassword(String email, String password);
    User findByEmail(String email);

}
