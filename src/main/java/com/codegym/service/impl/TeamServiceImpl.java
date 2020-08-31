package com.codegym.service.impl;

import com.codegym.model.Team;
import com.codegym.repository.TeamRepository;
import com.codegym.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeamServiceImpl implements TeamService {
    @Autowired
    TeamRepository teamRepository;

    @Override
    public Iterable<Team> getAllTeam() {
        return teamRepository.findAll();
    }

    @Override
    public void save(Team team) {
        teamRepository.saveAndFlush(team);
    }

    @Override
    public Team findById(Long id) {
        return teamRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        teamRepository.delete(id);
    }
}
