package com.player.demo;

import com.player.demo.model.Player;
import com.player.demo.repository.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean CommandLineRunner commandLineRunner(PlayerRepository playerRepository) {
        return (args -> {
            Stream.of("mostafa", "olivier").map(Player::new).forEach(playerRepository::save);
        });
    }

}
