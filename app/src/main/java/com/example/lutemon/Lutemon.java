package com.example.lutemon;

import java.io.Serializable;

public class Lutemon implements Serializable {
    protected String name;
    protected String color;
    protected int attack;
    protected int defence;
    protected int experience;
    protected int health;
    protected int maxHealth;
    protected int id;
    protected int image;
    private static int idCounter;

    protected int wins;
    protected int losses;

    public Lutemon(String name, String color, int attack, int defence, int experience, int health, int maxHealth, int image) {
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defence = defence;
        this.experience = experience;
        this.health = health;
        this.maxHealth = maxHealth;
        this.id = idCounter;
        this.image = image;
        idCounter++;
    }
    public String getName(){
        return name;
    }

    public String getColor(){
        return color;
    }

    public int getAttack(){
        return attack;
    }

    public int getDefence(){
        return defence;
    }

    public int getExperience(){
        return experience;
    }

    public int getHealth(){
        return health;
    }

    public int getMaxHealth(){
        return maxHealth;
    }

    public int getImage() {
        return image;
    }

    public int getId() {
        return id;
    }
    public void setAttack(int attack){
        this.attack = attack;
    }

    public void setDefence(int defence){
        this.defence = defence;
    }
    public void setHealth(int health) {this.health = health;}

    public void setIdCounter(int number) {
        idCounter = number;
    }

    public void setWins() {
        wins++;
        experience = experience + 2;
        maxHealth += 2;
        health = maxHealth;
    }
    public void setLosses() {
        losses++;
        experience = experience + 1;
        maxHealth += 1;
        health = maxHealth;
    }

    public int getWins() {return wins;}
    public int getLosses() {return losses;}

    public Boolean isAlive(){
        if (health > 0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }
}
