package com.example.demo.services;

import com.example.demo.entities.Game;
import com.example.demo.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public List<Game> list() { return gameRepository.findAll(); }

    public Game get(Long id) { return gameRepository.findById(id).orElseThrow(); }

    public Game save(Game g) {
        var now = LocalDateTime.now();
        if (g.getId() == null) g.setCreatedAt(now);
        g.setUpdatedAt(now);
        return gameRepository.save(g);
    }

    public void delete(Long id) { gameRepository.deleteById(id); }

}

