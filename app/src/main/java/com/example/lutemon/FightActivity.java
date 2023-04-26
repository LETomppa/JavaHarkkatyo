package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lutemon.fragments.FragmentFight;

import java.sql.Time;
import java.util.ArrayList;

public class FightActivity extends AppCompatActivity {

    private Lutemon lutemon1;
    private Lutemon lutemon2;
    private ImageView imgLutemon1, imgLutemon2;

    private TextView txtLutemon1, txtLutemon2, attF1, attF2, defF1, defF2, healthF1, healthF2, healthMaxF1,
            healthMaxF2, expF1, expF2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);

        attF1 = findViewById(R.id.battleAttackF1);
        attF2 = findViewById(R.id.battleAttackF2);
        defF1 = findViewById(R.id.battleDefenceF1);
        defF2 = findViewById(R.id.battleDEFENCEF2);
        healthF1 = findViewById(R.id.battleHealthF1);
        healthF2 = findViewById(R.id.battleHEALTHF2);
        healthMaxF1 = findViewById(R.id.battleMAXHEALTHF1);
        healthMaxF2 = findViewById(R.id.battleMAXHEALTHF2);
        expF1 = findViewById(R.id.battletextLVLF1);
        expF2 = findViewById(R.id.battletextLVLF2);

        txtLutemon1 = findViewById(R.id.lutemon1_name);
        txtLutemon2 = findViewById(R.id.lutemon2_name);
        imgLutemon1 = findViewById(R.id.lutemon1_image);
        imgLutemon2 = findViewById(R.id.lutemon2_image);

        lutemon1 = (Lutemon) getIntent().getSerializableExtra("selectedLutemon1");
        lutemon2 = (Lutemon) getIntent().getSerializableExtra("selectedLutemon2");
        if (lutemon1 != null && lutemon2 != null) {
            imgLutemon1.setImageResource(lutemon1.getImage());
            imgLutemon2.setImageResource(lutemon2.getImage());
            txtLutemon1.setText(lutemon1.getName());
            txtLutemon2.setText(lutemon2.getName());
            attF1.setText(String.valueOf(lutemon1.getAttack()));
            defF1.setText(String.valueOf(lutemon1.getDefence()));
            healthF1.setText(String.valueOf(lutemon1.getHealth()));
            healthMaxF1.setText(String.valueOf(lutemon1.getMaxHealth()));
            expF1.setText(String.valueOf(lutemon1.getExperience()));
            attF2.setText(String.valueOf(lutemon2.getAttack()));
            defF2.setText(String.valueOf(lutemon2.getDefence()));
            healthF2.setText(String.valueOf(lutemon2.getHealth()));
            healthMaxF2.setText(String.valueOf(lutemon2.getMaxHealth()));
            expF2.setText(String.valueOf(lutemon2.getExperience()));
        }
    }
    public void switchBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void fightStart(View view) {
        int dmg;
        int hp;
        int def;
        Lutemon attacker = lutemon1;
        Lutemon defender = lutemon2;
        Lutemon defenderCache;

        healthF1.setText(String.valueOf(lutemon1.getMaxHealth()));
        healthF2.setText(String.valueOf(lutemon2.getMaxHealth()));

        while (true) {
            if (defender.isAlive()) {
                def = defender.getDefence();
                hp = defender.getHealth();
                dmg = attacker.getAttack();

                //CRIT
                if (Math.random() * (10 - 1) + 1 == 7) {
                    dmg = +2;
                    Toast.makeText(this, "CRITICAL STRIKE! (dmg + 2)", Toast.LENGTH_SHORT).show();
                }
                dmg = dmg - def;
                if (dmg < 0) {
                    dmg = 0;
                }
                defender.setHealth(hp - dmg);
            }
            healthF1.setText(String.valueOf(lutemon1.getHealth()));
            healthF2.setText(String.valueOf(lutemon2.getHealth()));
            if (defender.isAlive()) {
                defenderCache = defender;
                defender = attacker;
                attacker = defenderCache;
            } else {
                break;
            }
        }
        fightEnd();
    }

    public void fightEnd() {
        ArrayList<Lutemon> lutemons = Storage.getInstance().getLutemons();


        for (Lutemon lutemon : lutemons) {
            if (lutemon.getId() == lutemon1.getId()) {
                if (lutemon1.isAlive()) {
                    lutemon.setWins();
                } else {
                    lutemon.setLosses();
                    healthF1.setText("0");
                }
                lutemon.setHealth(lutemon.getMaxHealth());
                lutemon1.setHealth(lutemon1.getMaxHealth());
                expF1.setText(String.valueOf(lutemon.getExperience()));
            }

            if (lutemon.getId() == lutemon2.getId()) {
                if (lutemon2.isAlive()) {
                    lutemon.setWins();
                } else {
                    lutemon.setLosses();
                    healthF2.setText("0");
                }
                lutemon.setHealth(lutemon.getMaxHealth());
                lutemon2.setHealth(lutemon2.getMaxHealth());

                expF2.setText(String.valueOf(lutemon.getExperience()));
            }

        }
    }


}