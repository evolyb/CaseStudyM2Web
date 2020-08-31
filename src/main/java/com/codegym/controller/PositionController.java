package com.codegym.controller;

import com.codegym.model.Position;
import com.codegym.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/positions")
public class PositionController {
    @Autowired
    PositionService positionService;

    @RequestMapping
    public String showPositionList(Model model){
        Iterable<Position> positions = positionService.findAll();
        model.addAttribute("positions",positions);
        return "/position/list";
    }
}
