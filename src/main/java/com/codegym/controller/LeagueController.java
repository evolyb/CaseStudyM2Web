package com.codegym.controller;

import com.codegym.model.Team;
import com.codegym.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("leagues")
public class LeagueController {
    @Autowired
    TeamService teamService;

    @GetMapping
    public String showLeague(Model model){
        Team team = teamService.findById(1L);
        model.addAttribute(team);
        return "/league/list";
    }
}
