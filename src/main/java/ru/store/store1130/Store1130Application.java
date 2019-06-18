package ru.store.store1130;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.store.store1130.db.model.User;
import ru.store.store1130.db.repository.UserRepository;

import static java.util.Arrays.asList;

@SpringBootApplication
public class Store1130Application {

    public static void main(String[] args) {
        SpringApplication.run(Store1130Application.class, args);
        
    }
}
