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

    private TextView txtWins;
    private TextView txtLosses;
    private ImageView imageLutemon;
    private ArrayList<Lutemon> lutemons;

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
        Spinner spinner = view.findViewById(R.id.spinnerStats);
        imageLutemon = view.findViewById(R.id.imageStatsLutemon);
        txtWins = view.findViewById(R.id.txtWins);
        txtLosses = view.findViewById(R.id.txtLosses);
        ImageView imageWins = view.findViewById(R.id.imageWins);
        ImageView imageLosses = view.findViewById(R.id.imageLosses);
        TextView txtInfo = view.findViewById(R.id.txtChooseStats);
        TextView txtEmptyStats = view.findViewById(R.id.txtEmptyStats);
        lutemons = Storage.getInstance().getLutemons();
        if (lutemons.isEmpty()) {
            spinner.setVisibility(View.GONE);
            imageLutemon.setVisibility(View.GONE);
            txtWins.setVisibility(View.GONE);
            txtLosses.setVisibility(View.GONE);
            imageWins.setVisibility(View.GONE);
            imageLosses.setVisibility(View.GONE);
            txtInfo.setVisibility(View.GONE);
            txtEmptyStats.setVisibility(View.VISIBLE);
        }
        else{
            spinner.setVisibility(View.VISIBLE);
            imageLutemon.setVisibility(View.VISIBLE);
            txtWins.setVisibility(View.VISIBLE);
            txtLosses.setVisibility(View.VISIBLE);
            imageWins.setVisibility(View.VISIBLE);
            imageLosses.setVisibility(View.VISIBLE);
            txtInfo.setVisibility(View.VISIBLE);
            txtEmptyStats.setVisibility(View.GONE);
            ArrayAdapter<Lutemon> adapter = new ArrayAdapter<>(getContext(),
                    android.R.layout.simple_spinner_dropdown_item, lutemons);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(this);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // Get the selected Lutemon object and display its image
        Lutemon selectedLutemon = lutemons.get(i);
        imageLutemon.setImageResource(selectedLutemon.getImage());
        txtWins.setText(String.valueOf(selectedLutemon.getWins()));
        txtLosses.setText(String.valueOf(selectedLutemon.getLosses()));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // Do nothing
    }

}