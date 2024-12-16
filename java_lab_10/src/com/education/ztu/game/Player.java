package com.education.ztu.game;

import java.io.Serializable;

public class Player implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int score;
    private transient String email; // Поле виключене з серіалізації

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Player(String name, int score, String email) {
        this.name = name;
        this.score = score;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Player{name='" + name + "', score=" + score + "}";
    }
}
