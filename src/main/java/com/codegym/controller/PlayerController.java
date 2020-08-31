package com.codegym.controller;

import com.codegym.model.Player;
import com.codegym.model.Position;
import com.codegym.model.Team;
import com.codegym.model.validator.PlayerValidator;
import com.codegym.service.PlayerService;
import com.codegym.service.PositionService;
import com.codegym.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    PlayerService playerService;
    @Autowired
    TeamService teamService;
     @Autowired
    PositionService positionService;

    @ModelAttribute("teams")
    public Iterable<Team> teams(){
        return teamService.getAllTeam();
    }
    @ModelAttribute("positions")
    public Iterable<Position> positions(){return positionService.findAll();}

    @RequestMapping
    public String showAllPlayers(Model model){
        Iterable<Player> players = playerService.findAll();
        model.addAttribute("players",players);
        return "/player/list";
    }

    @GetMapping("/create")
    public String openCreatePlayerForm(@ModelAttribute("player")Player player){
        return "/player/create";
    }
    @PostMapping("/create")
    public String addPlayer(@Valid @ModelAttribute("player")Player player, BindingResult result){
        new PlayerValidator().validate(player,result);
        Player player1 = playerService.findFirstByIdentity(player.getIdentity());
        if (player1 != null){
            result.rejectValue("identity","identity.existed");
        }
        if (result.hasFieldErrors()) return "/player/create";
        playerService.save(player);
        return "redirect:/players";
    }

    @GetMapping("/delete/{id}")
    public String openDeleteForm(@PathVariable Long id, Model model){
        Player player = playerService.findById(id);
        model.addAttribute("player",player);
        return "/player/delete";
    }
    @PostMapping("/delete")
    public String deletePlayer(@ModelAttribute("player")Player player){
        playerService.remove(player.getId());
        return "redirect:/players";
    }
    @GetMapping("/edit/{id}")
    public String openEditForm(@PathVariable Long id, Model model){
        Player player = playerService.findById(id);
        model.addAttribute("player",player);
        return "/player/edit";
    }
    @PostMapping("/edit")
    public String savePlayer(@ModelAttribute("player")Player player){
        playerService.save(player);
        return "redirect:/players";
    }
}
