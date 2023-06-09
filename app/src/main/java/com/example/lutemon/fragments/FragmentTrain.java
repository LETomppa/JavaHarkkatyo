package com.example.lutemon.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lutemon.Lutemon;
import com.example.lutemon.R;
import com.example.lutemon.Storage;

import java.util.ArrayList;

public class FragmentTrain extends Fragment implements AdapterView.OnItemSelectedListener {
    private ImageButton imageButton;
    private TextView txtAttack;
    private TextView txtDefence;
    private TextView txtClicksLeft;
    private ArrayList<Lutemon> lutemons;
    private Lutemon selectedLutemon;
    private static int clickCounter = 0;
    private static final int clicksLeft = 40;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_train, container, false);
        setupUI(view);
        return view;
    }
    @Override
    public void onResume() { // refreshes the list every time the tab has been resumed
        super.onResume();
        setupUI(getView());
    }
    private void setupUI(View view) { // Set up the UI components
        Spinner spinner = view.findViewById(R.id.spinnerTrain);
        imageButton = view.findViewById(R.id.imageButton);
        lutemons = Storage.getInstance().getLutemons();
        TextView emptyText = view.findViewById(R.id.txtEmpty);
        txtAttack = view.findViewById(R.id.txtAttack);
        txtDefence = view.findViewById(R.id.txtDefence);
        txtClicksLeft = view.findViewById(R.id.txtPresses);
        TextView txtTrain = view.findViewById(R.id.txtTrain);
        TextView txtInfo = view.findViewById(R.id.txtInfo);
        ImageView imgSword = view.findViewById(R.id.imgSword);
        ImageView imgShield = view.findViewById(R.id.imgShield);
        RadioGroup rgTrain = view.findViewById(R.id.rgTrain);
        TextView txtAddedAttack = view.findViewById(R.id.txtAddedAttack);
        TextView txtAddedDefence = view.findViewById(R.id.txtAddedDefence);
        if (lutemons.isEmpty()) { // if theres no lutemons, the fragment is empty and suggests to create some
            emptyText.setVisibility(View.VISIBLE);
            spinner.setVisibility(View.GONE);
            imageButton.setVisibility(View.GONE);
            txtAttack.setVisibility(View.GONE);
            txtDefence.setVisibility(View.GONE);
            txtClicksLeft.setVisibility(View.GONE);
            txtTrain.setVisibility(View.GONE);
            txtInfo.setVisibility(View.GONE);
            imgSword.setVisibility(View.GONE);
            imgShield.setVisibility(View.GONE);
            rgTrain.setVisibility(View.GONE);
        } else { // displays the fragment when lutemons have been created
            // Create an ArrayAdapter to populate the spinner with Lutemon names
            ArrayAdapter<Lutemon> adapter = new ArrayAdapter<>(getContext(),
                    android.R.layout.simple_spinner_dropdown_item, lutemons);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(this);
            emptyText.setVisibility(View.GONE);
            spinner.setVisibility(View.VISIBLE);
            imageButton.setVisibility(View.VISIBLE);
            txtAttack.setVisibility(View.VISIBLE);
            txtDefence.setVisibility(View.VISIBLE);
            txtClicksLeft.setVisibility(View.VISIBLE);
            txtTrain.setVisibility(View.VISIBLE);
            txtInfo.setVisibility(View.VISIBLE);
            imgSword.setVisibility(View.VISIBLE);
            imgShield.setVisibility(View.VISIBLE);
            rgTrain.setVisibility(View.VISIBLE);
            // Update the click counter and show the result in the UI
            txtClicksLeft.setText(String.valueOf(clicksLeft-clickCounter));
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int selectedRadioButtonId = rgTrain.getCheckedRadioButtonId();
                    if (selectedRadioButtonId == View.NO_ID) { // makes the user select a stat they want to train
                        Toast.makeText(getContext(), "Valitse kumpaa statsia haluat treenata", Toast.LENGTH_SHORT).show();
                    }
                    else {clickCounter++;
                        if (clickCounter == 40) {
                            switch (rgTrain.getCheckedRadioButtonId()) {
                                // Does the animation for attaack
                                case R.id.rbAttack:
                                    txtAddedAttack.setVisibility(View.VISIBLE);
                                    selectedLutemon.setAttack(selectedLutemon.getAttack() + 1);
                                    txtAddedAttack.animate()
                                            .alpha(1.0f) // smoothly appear
                                            .setDuration(500) // 500 milliseconds
                                            .withEndAction(new Runnable() {
                                                @Override
                                                public void run() {
                                                    txtAddedAttack.animate()
                                                            .alpha(0.0f) // smoothly fade away
                                                            .setDuration(500) // 100 milliseconds
                                                            .withEndAction(new Runnable() {
                                                                @Override
                                                                public void run() {
                                                                    txtAddedAttack.setVisibility(View.GONE);
                                                                }
                                                            })
                                                            .start();
                                                }
                                            })
                                            .start();
                                    break;
                                case R.id.rbDefence:
                                    // Does the animation for attaack
                                    txtAddedDefence.setVisibility(View.VISIBLE);
                                    selectedLutemon.setDefence(selectedLutemon.getDefence() + 1);
                                    txtAddedDefence.animate()
                                            .alpha(1.0f) // smoothly appear
                                            .setDuration(500) // 500 milliseconds
                                            .withEndAction(new Runnable() {
                                                @Override
                                                public void run() {
                                                    txtAddedDefence.animate()
                                                            .alpha(0.0f) // smoothly fade away
                                                            .setDuration(500) // 500 milliseconds
                                                            .withEndAction(new Runnable() {
                                                                @Override
                                                                public void run() {
                                                                    txtAddedDefence.setVisibility(View.GONE);
                                                                }
                                                            })
                                                            .start();
                                                }
                                            })
                                            .start();
                                    break;

                            }
                            FragmentHome.adapter.notifyDataSetChanged();
                            txtAttack.setText(String.valueOf(selectedLutemon.getAttack()));
                            txtDefence.setText(String.valueOf(selectedLutemon.getDefence()));
                            clickCounter = 0;
                        }
                        txtClicksLeft.setText(String.valueOf(clicksLeft-clickCounter));
                    }}
            });
        }
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // Get the selected Lutemon object and display its image
        selectedLutemon = lutemons.get(i);
        imageButton.setImageResource(selectedLutemon.getImage());
        txtAttack.setText(String.valueOf(selectedLutemon.getAttack()));
        txtDefence.setText(String.valueOf(selectedLutemon.getDefence()));
        clickCounter = 0;
        txtClicksLeft.setText(String.valueOf(clicksLeft-clickCounter));

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // Do nothing
    }

}