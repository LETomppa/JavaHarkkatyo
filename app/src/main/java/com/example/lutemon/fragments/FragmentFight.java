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

    private ImageView imageF1;
    private ImageView imageF2;

    private TextView attF1;
    private TextView attF2;
    private TextView defF1;
    private TextView defF2;
    private TextView healthF1;
    private TextView healthF2;
    private TextView healthMaxF1;
    private TextView healthMaxF2;
    private TextView expF1;
    private TextView expF2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fight, container, false);
        // Inflate the layout for this fragment
        setupUI(view);
        return view;
    }

    @Override
    public void onResume(){ // refreshes the list every time the tab has been resumed
        super.onResume();
        setupUI(getView());
    }

    private void setupUI(View view){ // Set up the UI components
        ArrayList<Lutemon> lutemons = Storage.getInstance().getLutemons();

        Spinner spinnerF1 = view.findViewById(R.id.spinnferFOne);
        Spinner spinnerF2 = view.findViewById(R.id.spinnerFTwo);
        Button buttonFight = view.findViewById(R.id.btnFight);
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
        ImageView imageF1hp = view.findViewById(R.id.imageF1HP);
        ImageView imageF2hp = view.findViewById(R.id.imageF2HP);
        ImageView imageF1def = view.findViewById(R.id.imageF1Def);
        ImageView imageF2def = view.findViewById(R.id.imageF2Def);
        ImageView imageF1att = view.findViewById(R.id.imageF1Att);
        ImageView imageF2att = view.findViewById(R.id.imageF2Att);
        ImageView imageF1xp = view.findViewById(R.id.imageF1XP);
        ImageView imageF2xp = view.findViewById(R.id.imageF2XP);
        TextView textVIIVA4 = view.findViewById(R.id.textVIIVA4);
        TextView textVIIVA3 = view.findViewById(R.id.textVIIVA3);
        TextView textFighterselect = view.findViewById(R.id.textFighterSelect);
        TextView txtEmptyFight = view.findViewById(R.id.txtEmptyFight);

        ArrayAdapter<Lutemon> adapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_spinner_dropdown_item, lutemons);
        spinnerF1.setAdapter(adapter);
        spinnerF2.setAdapter(adapter);
        if (lutemons.isEmpty()) { // if theres no lutemons, the fragment is empty and suggests to create some
            spinnerF1.setVisibility(View.GONE);
            spinnerF2.setVisibility(View.GONE);
            buttonFight.setVisibility(View.GONE);
            imageF1.setVisibility(View.GONE);
            imageF2.setVisibility(View.GONE);
            attF1.setVisibility(View.GONE);
            attF2.setVisibility(View.GONE);
            defF1.setVisibility(View.GONE);
            defF2.setVisibility(View.GONE);
            healthF1.setVisibility(View.GONE);
            healthF2.setVisibility(View.GONE);
            healthMaxF1.setVisibility(View.GONE);
            healthMaxF2.setVisibility(View.GONE);
            expF1.setVisibility(View.GONE);
            expF2.setVisibility(View.GONE);
            imageF1hp.setVisibility(View.GONE);
            imageF2hp.setVisibility(View.GONE);
            imageF1def.setVisibility(View.GONE);
            imageF2def.setVisibility(View.GONE);
            imageF1att.setVisibility(View.GONE);
            imageF2att.setVisibility(View.GONE);
            imageF1xp.setVisibility(View.GONE);
            imageF2xp.setVisibility(View.GONE);
            textVIIVA4.setVisibility(View.GONE);
            textVIIVA3.setVisibility(View.GONE);
            textFighterselect.setVisibility(View.GONE);
            txtEmptyFight.setVisibility(View.VISIBLE);
        }
        else { // displays the fragment when lutemons have been created
            spinnerF1.setVisibility(View.VISIBLE);
            spinnerF2.setVisibility(View.VISIBLE);
            buttonFight.setVisibility(View.VISIBLE);
            imageF1.setVisibility(View.VISIBLE);
            imageF2.setVisibility(View.VISIBLE);
            attF1.setVisibility(View.VISIBLE);
            attF2.setVisibility(View.VISIBLE);
            defF1.setVisibility(View.VISIBLE);
            defF2.setVisibility(View.VISIBLE);
            healthF1.setVisibility(View.VISIBLE);
            healthF2.setVisibility(View.VISIBLE);
            healthMaxF1.setVisibility(View.VISIBLE);
            healthMaxF2.setVisibility(View.VISIBLE);
            expF1.setVisibility(View.VISIBLE);
            expF2.setVisibility(View.VISIBLE);
            imageF1hp.setVisibility(View.VISIBLE);
            imageF2hp.setVisibility(View.VISIBLE);
            imageF1def.setVisibility(View.VISIBLE);
            imageF2def.setVisibility(View.VISIBLE);
            imageF1att.setVisibility(View.VISIBLE);
            imageF2att.setVisibility(View.VISIBLE);
            imageF1xp.setVisibility(View.VISIBLE);
            imageF2xp.setVisibility(View.VISIBLE);
            textVIIVA4.setVisibility(View.VISIBLE);
            textVIIVA3.setVisibility(View.VISIBLE);
            textFighterselect.setVisibility(View.VISIBLE);
            txtEmptyFight.setVisibility(View.GONE);
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
        intent.putExtra("selectedLutemon1", selectedLutemon);
        intent.putExtra("selectedLutemon2", selectedLutemon2);
        startActivity(intent); // switches to fight activity
    }
}