package com.codegym.service;

import com.codegym.model.Team;

public interface TeamService {
    Iterable<Team> getAllTeam();
    void save(Team team);
    Team findById(Long id);
    void remove(Long id);
}
