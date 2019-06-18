package ru.store.store1130;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.store.store1130.db.model.User;
import ru.store.store1130.db.repository.UserRepository;

import static java.util.Arrays.asList;

@SpringBootApplication
public class Store1130Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Store1130Application.class, args);

    }

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) {
        userRepository.saveAll(
                asList(
                        new User().setEmail("admindmitrich@mail.ru").setPassword("pochta1212"),
                        new User().setEmail("samplemail@mail.ru").setPassword("samplepassword")
                )
        );

    }
}
