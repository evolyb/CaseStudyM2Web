package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany(targetEntity = Player.class)
    private List<Player>players;

    public Position(){}

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getTeams() {
        return players;
    }

    public void setTeams(List<Player> players) {
        this.players = players;
    }
}
