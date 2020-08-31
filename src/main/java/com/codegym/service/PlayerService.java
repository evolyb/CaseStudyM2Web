package com.codegym.service;

import com.codegym.model.Player;
import com.codegym.model.Team;

public interface PlayerService {
    Iterable<Player> findAll();
    Iterable<Player> findAllByTeam(Team team);
    void save(Player player);
    Player findById(Long id);
    Player findFirstByIdentity(String identity);
    void remove(Long id);
    void deleteAllByTeam(Team team);
}
