package com.example.lutemon.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.lutemon.Lutemon;
import com.example.lutemon.R;
import com.example.lutemon.Storage;

import java.util.ArrayList;

public class FragmentTrain extends Fragment implements AdapterView.OnItemSelectedListener {
    private Spinner spinner;
    private ImageButton imageButton;
    private ArrayList<Lutemon> lutemons;
    private Lutemon selectedLutemon;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_train, container, false);
        spinner = view.findViewById(R.id.spinner);
        imageButton = view.findViewById(R.id.imageButton);
        lutemons = Storage.getInstance().getLutemons();
        // Create an ArrayAdapter to populate the spinner with Lutemon names
        ArrayAdapter<Lutemon> adapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_spinner_dropdown_item, lutemons);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        return view;
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // Get the selected Lutemon object and display its image
        selectedLutemon = lutemons.get(i);
        imageButton.setImageResource(selectedLutemon.getImage());
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // Do nothing
    }
}