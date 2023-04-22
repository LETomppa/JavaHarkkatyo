package com.example.lutemon;

public class Lutemon {
    protected String name;
    protected String color;
    protected int attack;
    protected int defence;
    protected int experience;
    protected int health;
    protected int maxHealth;
    protected int id;
    private int idCounter;

    public Lutemon(String name, String color, int attack, int defence, int experience, int health, int maxHealth) {
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defence = defence;
        this.experience = experience;
        this.health = health;
        this.maxHealth = maxHealth;
        this.id = idCounter;
        idCounter++;
    }
}
