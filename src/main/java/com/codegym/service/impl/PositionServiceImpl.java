package com.codegym.service.impl;

import com.codegym.model.Position;
import com.codegym.repository.PositionRepository;
import com.codegym.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionRepository positionRepository;
    @Override
    public Iterable<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Position findById(Integer id) {
        return positionRepository.findOne(id);
    }
}
