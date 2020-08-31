package com.codegym.service.impl;

import com.codegym.model.Player;
import com.codegym.model.Team;
import com.codegym.repository.PlayerRepository;
import com.codegym.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerServiceImpl implements PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    @Override
    public Iterable<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public Iterable<Player> findAllByTeam(Team team) {
        return playerRepository.findAllByTeam(team);
    }

    @Override
    public void save(Player player) {
        playerRepository.save(player);
    }

    @Override
    public Player findById(Long id) {
        return playerRepository.findOne(id);
    }

    @Override
    public Player findFirstByIdentity(String identity) {
        return playerRepository.findFirstByIdentity(identity);
    }

    @Override
    public void remove(Long id) {
        playerRepository.delete(id);
    }

    @Override
    public void deleteAllByTeam(Team team) {
        playerRepository.deleteAllByTeam(team);
    }

}
