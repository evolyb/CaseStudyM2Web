package com.codegym.service;

import com.codegym.model.Position;
import com.codegym.model.Team;

import java.util.List;

public interface PositionService {
    Iterable<Position> findAll();
    Position findById(Integer id);
}
