package ru.store.store1130.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.store.store1130.db.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);
}
