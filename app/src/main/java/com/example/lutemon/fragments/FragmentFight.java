package com.example.lutemon.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lutemon.FightActivity;
import com.example.lutemon.Lutemon;
import com.example.lutemon.MainActivity;
import com.example.lutemon.R;
import com.example.lutemon.Storage;

import java.util.ArrayList;


public class FragmentFight extends Fragment {

    private Lutemon selectedLutemon, selectedLutemon2;

    private Button buttonFight;

    private Spinner spinnerF1, spinnerF2;

    private ArrayList<Lutemon> lutemons;

    private ArrayAdapter<Lutemon> adapter;

    private ImageView imageF1, imageF2, imageF1hp, imageF2hp, imageF1def, imageF2def,
            imageF1att, imageF2att, imageF1xp, imageF2xp;

    private TextView attF1, attF2, defF1, defF2, healthF1, healthF2, healthMaxF1,
            healthMaxF2, expF1, expF2, textVIIVA4, textVIIVA3, textFighterselect, txtEmptyFight;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fight, container, false);
        // Inflate the layout for this fragment
        setupUI(view);
        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
        setupUI(getView());
    }

    private void setupUI(View view){
        lutemons = Storage.getInstance().getLutemons();

        spinnerF1 = view.findViewById(R.id.spinnferFOne);
        spinnerF2 = view.findViewById(R.id.spinnerFTwo);
        buttonFight = view.findViewById(R.id.btnFight);
        imageF1 = view.findViewById(R.id.imageFighterOne);
        imageF2 = view.findViewById(R.id.imageFighterTwo);
        attF1 = view.findViewById(R.id.textATTACKF1);
        attF2 = view.findViewById(R.id.textATTACKF2);
        defF1 = view.findViewById(R.id.textDEFENCEF1);
        defF2 = view.findViewById(R.id.textDEFENCEF2);
        healthF1 = view.findViewById(R.id.textHEALTHF1);
        healthF2 = view.findViewById(R.id.textHEALTHF2);
        healthMaxF1 = view.findViewById(R.id.textMAXHEALTHF1);
        healthMaxF2 = view.findViewById(R.id.textMAXHEALTHF2);
        expF1 = view.findViewById(R.id.textLVLF1);
        expF2 = view.findViewById(R.id.textLVLF2);
        imageF1hp = view.findViewById(R.id.imageF1HP);
        imageF2hp = view.findViewById(R.id.imageF2HP);
        imageF1def = view.findViewById(R.id.imageF1Def);
        imageF2def = view.findViewById(R.id.imageF2Def);
        imageF1att = view.findViewById(R.id.imageF1Att);
        imageF2att = view.findViewById(R.id.imageF2Att);
        imageF1xp = view.findViewById(R.id.imageF1XP);
        imageF2xp = view.findViewById(R.id.imageF2XP);
        textVIIVA4 = view.findViewById(R.id.textVIIVA4);
        textVIIVA3 = view.findViewById(R.id.textVIIVA3);
        textFighterselect = view.findViewById(R.id.textFighterSelect);
        txtEmptyFight = view.findViewById(R.id.txtEmptyFight);

        adapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_spinner_dropdown_item, lutemons);
        spinnerF1.setAdapter(adapter);
        spinnerF2.setAdapter(adapter);
        if (lutemons.isEmpty()) {
            spinnerF1.setVisibility(view.GONE);
            spinnerF2.setVisibility(view.GONE);
            buttonFight.setVisibility(view.GONE);
            imageF1.setVisibility(view.GONE);
            imageF2.setVisibility(view.GONE);
            attF1.setVisibility(view.GONE);
            attF2.setVisibility(view.GONE);
            defF1.setVisibility(view.GONE);
            defF2.setVisibility(view.GONE);
            healthF1.setVisibility(view.GONE);
            healthF2.setVisibility(view.GONE);
            healthMaxF1.setVisibility(view.GONE);
            healthMaxF2.setVisibility(view.GONE);
            expF1.setVisibility(view.GONE);
            expF2.setVisibility(view.GONE);
            imageF1hp.setVisibility(view.GONE);
            imageF2hp.setVisibility(view.GONE);
            imageF1def.setVisibility(view.GONE);
            imageF2def.setVisibility(view.GONE);
            imageF1att.setVisibility(view.GONE);
            imageF2att.setVisibility(view.GONE);
            imageF1xp.setVisibility(view.GONE);
            imageF2xp.setVisibility(view.GONE);
            textVIIVA4.setVisibility(view.GONE);
            textVIIVA3.setVisibility(view.GONE);
            textFighterselect.setVisibility(view.GONE);
            txtEmptyFight.setVisibility(view.VISIBLE);
        }
        else {
            spinnerF1.setVisibility(view.VISIBLE);
            spinnerF2.setVisibility(view.VISIBLE);
            buttonFight.setVisibility(view.VISIBLE);
            imageF1.setVisibility(view.VISIBLE);
            imageF2.setVisibility(view.VISIBLE);
            attF1.setVisibility(view.VISIBLE);
            attF2.setVisibility(view.VISIBLE);
            defF1.setVisibility(view.VISIBLE);
            defF2.setVisibility(view.VISIBLE);
            healthF1.setVisibility(view.VISIBLE);
            healthF2.setVisibility(view.VISIBLE);
            healthMaxF1.setVisibility(view.VISIBLE);
            healthMaxF2.setVisibility(view.VISIBLE);
            expF1.setVisibility(view.VISIBLE);
            expF2.setVisibility(view.VISIBLE);
            imageF1hp.setVisibility(view.VISIBLE);
            imageF2hp.setVisibility(view.VISIBLE);
            imageF1def.setVisibility(view.VISIBLE);
            imageF2def.setVisibility(view.VISIBLE);
            imageF1att.setVisibility(view.VISIBLE);
            imageF2att.setVisibility(view.VISIBLE);
            imageF1xp.setVisibility(view.VISIBLE);
            imageF2xp.setVisibility(view.VISIBLE);
            textVIIVA4.setVisibility(view.VISIBLE);
            textVIIVA3.setVisibility(view.VISIBLE);
            textFighterselect.setVisibility(view.VISIBLE);
            txtEmptyFight.setVisibility(view.GONE);
            AdapterView.OnItemSelectedListener listener1 = new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    // Handle item selection for spinnerF1
                    selectedLutemon = (Lutemon) parent.getSelectedItem();
                    imageF1.setImageResource(selectedLutemon.getImage());
                    attF1.setText(String.valueOf(selectedLutemon.getAttack()));
                    defF1.setText(String.valueOf(selectedLutemon.getDefence()));
                    healthF1.setText(String.valueOf(selectedLutemon.getHealth()));
                    healthMaxF1.setText(String.valueOf(selectedLutemon.getMaxHealth()));
                    expF1.setText(String.valueOf(selectedLutemon.getExperience()));
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    // Handle case where nothing is selected for spinnerF1
                }
            };
            spinnerF1.setOnItemSelectedListener(listener1);

            // Create a listener for spinnerF2
            AdapterView.OnItemSelectedListener listener2 = new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    // Handle item selection for spinnerF2
                    selectedLutemon2 = (Lutemon) parent.getSelectedItem();
                    imageF2.setImageResource(selectedLutemon2.getImage());
                    attF2.setText(String.valueOf(selectedLutemon2.getAttack()));
                    defF2.setText(String.valueOf(selectedLutemon2.getDefence()));
                    healthF2.setText(String.valueOf(selectedLutemon2.getHealth()));
                    healthMaxF2.setText(String.valueOf(selectedLutemon2.getMaxHealth()));
                    expF2.setText(String.valueOf(selectedLutemon2.getExperience()));
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    // Handle case where nothing is selected for spinnerF2
                }
            };
            spinnerF2.setOnItemSelectedListener(listener2);

            buttonFight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (selectedLutemon == selectedLutemon2) {
                        Toast.makeText(getContext(), "Valitse kaksi eri lutemonia", Toast.LENGTH_LONG).show();
                    }
                    else {
                        switchToFight(view);
                    }
                }
            });


        }
    }

    public void switchToFight(View view) {
        Intent intent = new Intent(getActivity(), FightActivity.class);
        startActivity(intent);
    }
}