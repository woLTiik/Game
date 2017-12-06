package com.example.woltik.game.dataInput;

import java.util.Date;

/**
 * Created by woLTik on 25-Nov-17.
 */

public class Score {



    private int id;
    private String date;
    private int score;
    private String name1;
    private String name2;


    public Score(String date, int score, String name1, String name2) {
        this.date = date;
        this.score = score;
        this.name1 = name1;
        this.name2 = name2;
    }

    public Score() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }


    public String getDate() {
        return date;
    }

    public int getScore() {
        return score;
    }

    public String getName1() {
        return name1;
    }

    public String getName2() {
        return name2;
    }
}
