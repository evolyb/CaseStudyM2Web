package com.codegym.controller;

import com.codegym.model.Player;
import com.codegym.model.Team;
import com.codegym.service.PlayerService;
import com.codegym.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Transactional
@Controller
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    TeamService teamService;
    @Autowired
    PlayerService playerService;

    @GetMapping
    public String listAllTeams(Model model){
        Iterable<Team> teamList = teamService.getAllTeam();
        model.addAttribute("teamList", teamList);
        return "/team/list";
    }
    @GetMapping("/create")
    public String openTeamForm(@ModelAttribute("team") Team team){
        return "/team/create";
    }
    @PostMapping("/create")
    public String createTeam(@Validated @ModelAttribute("team") Team team, BindingResult result){
        if (result.hasFieldErrors()) {
            return ("/team/create");
        }
        teamService.save(team);
        return "redirect:/teams";
    }
    @GetMapping("/edit/{id}")
    public String openTeamEditForm(@PathVariable("id") Long id, Model model){
        Team team = teamService.findById(id);
        model.addAttribute("team",team);
        return "/team/edit";
    }
    @PostMapping("/edit")
    public String saveTeam(@Validated @ModelAttribute("team") Team team, BindingResult result){
        if (result.hasFieldErrors()) {
            return ("/team/edit");
        }
        teamService.save(team);
        return "redirect:/teams";
    }
    @GetMapping("/delete/{id}")
    public String openTeamDeleteForm(@PathVariable("id") Long id, Model model){
        Team team = teamService.findById(id);
        model.addAttribute("team",team);
        return "/team/delete";
    }
    @PostMapping("/delete")
    public String delete(@ModelAttribute("team") Team team){
        Team teamRemove = teamService.findById(team.getId());
        playerService.deleteAllByTeam(teamRemove);
        teamService.remove(team.getId());
        return "redirect:/teams";
    }

    @GetMapping("/info/{id}")
    public String showInfo(@PathVariable("id") Long id, Model model){
        Team team = teamService.findById(id);
        Iterable<Player> players = playerService.findAllByTeam(team);
        model.addAttribute("team",team);
        model.addAttribute("players",players);
        return "/team/info";
    }
}
