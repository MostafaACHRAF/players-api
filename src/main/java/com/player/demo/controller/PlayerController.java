package com.player.demo.controller;

import com.player.demo.model.Player;
import com.player.demo.repository.PlayerRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController @RequestMapping("/api/players") public class PlayerController {
    private final PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping("/all") public List<Player> findAll() {
        return (List<Player>) this.playerRepository.findAll();
    }

    @PostMapping("/save") public void save(@RequestBody Player player) {
        this.playerRepository.save(player);
    }

    @DeleteMapping("/delete/{id}") public void delete(@PathVariable("id") Long id) {
        Optional<Player> playerToDelete = this.playerRepository.findById(id);
        if (playerToDelete.isPresent()) {
            this.playerRepository.delete(playerToDelete.get());
        } else {
            throw new IllegalArgumentException("Can't delete non found player");
        }
    }



}
