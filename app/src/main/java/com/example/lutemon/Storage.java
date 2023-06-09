package com.example.lutemon;


import static com.example.lutemon.fragments.FragmentHome.adapter;

import android.content.Context;

import com.example.lutemon.fragments.FragmentHome;
import com.example.lutemon.fragments.FragmentTrain;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Storage {
    protected String name;
    private static boolean EasterEggBoolean = false;
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

    public void removeLutemon(int id) { // removes a lutemon from the ArrayList
        int i = 0;
        for (Lutemon l : lutemons){
            if (l.getId() == (id)) {
                break;
            }
            i++;
        }
        lutemons.remove(i);
    }

    public void saveLutemons(Context context) {
        try {
            ObjectOutputStream userWriter = new ObjectOutputStream(context.openFileOutput("lutemons.data", Context.MODE_PRIVATE));
            userWriter.writeObject(lutemons);
            userWriter.close();
        }
        catch (IOException e) {
            System.out.println("Lutemonien tallentaminen ei onnistunut");
        }
    }
    public void loadLutemons(Context context) {
        try {
            ObjectInputStream userReader = new ObjectInputStream(context.openFileInput("lutemons.data"));
            lutemons = (ArrayList<Lutemon>) userReader.readObject();
            userReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Lutemonien lukeminen ei onnistunut");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Lutemonien lukeminen ei onnistunut");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Lutemonien lukeminen ei onnistunut");
            e.printStackTrace();
        }
        int number = 1;
        for(Lutemon lutemon: lutemons) {
            lutemon.setIdCounter(number);
            number++;
        }
        adapter.notifyDataSetChanged();
    }

    public void setEasterEggBoolean() {
        EasterEggBoolean = true;
    }

    public boolean getEasterEggBoolean() {
        return EasterEggBoolean;
    } // returns the boolean to determine if the hedgehog has been found or not

}
