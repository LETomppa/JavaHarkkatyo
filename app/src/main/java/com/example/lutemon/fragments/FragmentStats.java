package com.example.lutemon.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.lutemon.Lutemon;
import com.example.lutemon.R;
import com.example.lutemon.Storage;

import java.util.ArrayList;


public class FragmentStats extends Fragment implements AdapterView.OnItemSelectedListener {

    private TextView txtWins, txtLosses, txtInfo, txtEmptyStats;
    private ImageView imageLutemon, imageWins, imageLosses;
    private Spinner spinner;
    private ArrayList<Lutemon> lutemons;
    private Lutemon selectedLutemon;
    private ArrayAdapter<Lutemon> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stats, container, false);
        setupUI(view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        setupUI(getView());
    }

    private void setupUI(View view) {
        spinner = view.findViewById(R.id.spinnerStats);
        imageLutemon = view.findViewById(R.id.imageStatsLutemon);
        txtWins = view.findViewById(R.id.txtWins);
        txtLosses = view.findViewById(R.id.txtLosses);
        imageWins = view.findViewById(R.id.imageWins);
        imageLosses = view.findViewById(R.id.imageLosses);
        txtInfo = view.findViewById(R.id.txtChooseStats);
        txtEmptyStats = view.findViewById(R.id.txtEmptyStats);
        lutemons = Storage.getInstance().getLutemons();
        if (lutemons.isEmpty()) {
            spinner.setVisibility(view.GONE);
            imageLutemon.setVisibility(view.GONE);
            txtWins.setVisibility(view.GONE);
            txtLosses.setVisibility(view.GONE);
            imageWins.setVisibility(view.GONE);
            imageLosses.setVisibility(view.GONE);
            txtInfo.setVisibility(view.GONE);
            txtEmptyStats.setVisibility(view.VISIBLE);
        }
        else{
            spinner.setVisibility(view.VISIBLE);
            imageLutemon.setVisibility(view.VISIBLE);
            txtWins.setVisibility(view.VISIBLE);
            txtLosses.setVisibility(view.VISIBLE);
            imageWins.setVisibility(view.VISIBLE);
            imageLosses.setVisibility(view.VISIBLE);
            txtInfo.setVisibility(view.VISIBLE);
            txtEmptyStats.setVisibility(view.GONE);
            adapter = new ArrayAdapter<>(getContext(),
                    android.R.layout.simple_spinner_dropdown_item, lutemons);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(this);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // Get the selected Lutemon object and display its image
        selectedLutemon = lutemons.get(i);
        imageLutemon.setImageResource(selectedLutemon.getImage());
        txtWins.setText(String.valueOf(selectedLutemon.getWins()));
        txtLosses.setText(String.valueOf(selectedLutemon.getLosses()));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // Do nothing
    }

}