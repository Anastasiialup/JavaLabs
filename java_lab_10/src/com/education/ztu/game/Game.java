package com.education.ztu.game;

import java.io.Serializable;

/**
 * Represents a game entity.
 */
public class Game implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Team team;

    public Game(String name, Team team) {
        this.name = name;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public Team getTeam() {
        return team;
    }

    @Override
    public String toString() {
        return "Game{name='" + name + "', team=" + team + "}";
    }
}
