package com.codegym.model;

import java.time.LocalDate;

public class Match {
    int Id;
    LocalDate date;
    Long team1Id;
    Long team2Id;
    int score1;
    int score2;
    String stadium;

    public Match(int id, LocalDate date, Long team1Id, Long team2Id, int score1, int score2, String stadium) {
        Id = id;
        this.date = date;
        this.team1Id = team1Id;
        this.team2Id = team2Id;
        this.score1 = score1;
        this.score2 = score2;
        this.stadium = stadium;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getTeam1Id() {
        return team1Id;
    }

    public void setTeam1Id(Long team1Id) {
        this.team1Id = team1Id;
    }

    public Long getTeam2Id() {
        return team2Id;
    }

    public void setTeam2Id(Long team2Id) {
        this.team2Id = team2Id;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }
}
