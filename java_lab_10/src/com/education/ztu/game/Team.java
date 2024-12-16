package com.education.ztu.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a team in the game.
 */
public class Team implements Serializable {
    private static final long serialVersionUID = 1L;

    private String teamName;
    private List<Player> players = new ArrayList<>();

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public String toString() {
        return "Team{teamName='" + teamName + "', players=" + players + "}";
    }
}
