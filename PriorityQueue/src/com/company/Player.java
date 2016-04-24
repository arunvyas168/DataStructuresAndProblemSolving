package com.company;

import java.util.Comparator;

/**
 * Created by arun on 4/24/16.
 */
public class Player {

    private String name;
    private Double score;

    public Player(String name, Double score) {
        this.score = score;
        this.name = name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        String info = "The player name is " +this.name+ " and their score is: " +this.score;
        return info;
    }

    /*@Override
    public int compare(Player o1, Player o2) {

        if (o1.score < o2.score)
        {
            return -1;
        }
        if (o1.score > o2.score)
        {
            return 1;
        }
        return 0;

    }*/
}
