package org.example.sprintscoreapi;

public class Score {
    private int ties;
    private int losses;
    private int wins;

    public Score(int wins, int ties, int losses) {
        this.wins = wins;
        this.ties = ties;
        this.losses = losses;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }


}
