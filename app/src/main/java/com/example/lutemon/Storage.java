package com.example.lutemon;

import java.util.ArrayList;

public class Storage {
    protected String name;
    ArrayList<Lutemon> lutemons = new ArrayList<>();
    private static Storage storage = null;

    private Storage() {}

    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public void addLutemon(Lutemon lutemon) {lutemons.add(lutemon);}

    public ArrayList<Lutemon> getLutemons() {return lutemons; }

    public void removeLutemon(int id) {
        int i = 0;
        for (Lutemon l : lutemons){
            if (l.getId() == (id)) {
                break;
            }
            i++;
        }
        lutemons.remove(i);
    }


}
