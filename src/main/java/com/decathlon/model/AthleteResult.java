package com.decathlon.model;

public class AthleteResult {

    private String name;
    private int score;
    private int ranking;

    public AthleteResult(String name, int score, int ranking) {
        this.name = name;
        this.score = score;
        this.ranking = ranking;
    }

    public int getRanking() {
        return ranking;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
