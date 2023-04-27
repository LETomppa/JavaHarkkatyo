package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Random;

public class FightActivity extends AppCompatActivity {

    private Lutemon lutemon1;
    private Lutemon lutemon2;
    private ImageView imgLutemon1, imgLutemon2;

    private Button fightButton, backButton;

    private TextView healthF1;
    private TextView healthF2;
    private TextView expF1;
    private TextView expF2;

    private TextView txtResult;
    private ImageView imgCritical;
    private TextView dmgL1, dmgL2;
    private boolean isLutemon1Attacking = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);

        fightButton = findViewById(R.id.battleButtonFight);
        backButton = findViewById(R.id.buttonBack);
        txtResult = findViewById(R.id.txtResult);

        TextView attF1 = findViewById(R.id.battleAttackF1);
        TextView attF2 = findViewById(R.id.battleAttackF2);
        TextView defF1 = findViewById(R.id.battleDefenceF1);
        TextView defF2 = findViewById(R.id.battleDEFENCEF2);
        healthF1 = findViewById(R.id.battleHealthF1);
        healthF2 = findViewById(R.id.battleHEALTHF2);
        TextView healthMaxF1 = findViewById(R.id.battleMAXHEALTHF1);
        TextView healthMaxF2 = findViewById(R.id.battleMAXHEALTHF2);
        expF1 = findViewById(R.id.battletextLVLF1);
        expF2 = findViewById(R.id.battletextLVLF2);

        TextView txtLutemon1 = findViewById(R.id.lutemon1_name);
        TextView txtLutemon2 = findViewById(R.id.lutemon2_name);
        imgLutemon1 = findViewById(R.id.lutemon1_image);
        imgLutemon2 = findViewById(R.id.lutemon2_image);

        imgCritical = findViewById(R.id.imgCritical);
        dmgL1 = findViewById(R.id.dmgL1);
        dmgL2 = findViewById(R.id.dmgL2);


        lutemon1 = (Lutemon) getIntent().getSerializableExtra("selectedLutemon1");
        lutemon2 = (Lutemon) getIntent().getSerializableExtra("selectedLutemon2");


        if (lutemon1 != null && lutemon2 != null) {
            if (lutemon1.getExperience() > lutemon2.experience) {
                lutemon1.setAttack(lutemon1.getAttack() + 2);
                Toast.makeText(this, lutemon1.getName() + ":n kokemus on korkeampi! hänen hyökkäys on parempi!", Toast.LENGTH_LONG).show();
            }
            if (lutemon2.getExperience() > lutemon1.experience) {
                lutemon2.setAttack(lutemon2.getAttack() + 2);
                Toast.makeText(this, lutemon2.getName() + ":n kokemus on korkeampi! hänen hyökkäys on parempi!", Toast.LENGTH_LONG).show();

            }
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


    public void fightStart(View view) throws InterruptedException {
        final float F1PosX = imgLutemon1.getX();
        final float F1PosY = imgLutemon1.getY();
        final float F2PosX = imgLutemon2.getX();
        final float F2PosY = imgLutemon2.getY();

        int dmg = 0;
        int hp;
        int def;
        Lutemon attacker;
        Lutemon defender;

        fightButton.setVisibility(View.GONE);
        healthF1.setText(String.valueOf(lutemon1.getMaxHealth()));
        healthF2.setText(String.valueOf(lutemon2.getMaxHealth()));

        if (isLutemon1Attacking) {
            attacker = lutemon1;
            defender = lutemon2;
        } else {
            attacker = lutemon2;
            defender = lutemon1;
        }

            // Animate lutemon1
        if(isLutemon1Attacking) {
            imgLutemon1.bringToFront();
            imgLutemon1.animate().x(F2PosX).y(F2PosY);
            new Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            imgLutemon1.animate().x(F1PosX).y(F1PosY);
                        }
                        },
                    500);

            }

        // Animate lutemon2
        if(!isLutemon1Attacking) {
            imgLutemon2.bringToFront();
            imgLutemon2.animate().x(F1PosX).y(F1PosY);
            new Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            imgLutemon2.animate().x(F2PosX).y(F2PosY);
                        }
                    },
                    500);
        }

        if (defender.isAlive()) {
            def = defender.getDefence();
            hp = defender.getHealth();
            dmg = attacker.getAttack();


            //CRIT
            Random random = new Random();
            int randomNumber = random.nextInt(10) + 1;
            if (randomNumber == 7) {
                dmg += 2;
                Toast.makeText(this, "CRITICAL STRIKE! (dmg + 2)", Toast.LENGTH_SHORT).show();
                if (isLutemon1Attacking) {
                    imgCritical.setX(F2PosX);
                    imgCritical.setY(F2PosY);
                    imgCritical.bringToFront();
                    imgLutemon1.bringToFront();
                    imgCritical.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            imgCritical.setVisibility(View.GONE);
                        }
                    }, 1000); // 1000 milliseconds = 1 second
                }
                if (!isLutemon1Attacking) {
                    imgCritical.setX(F1PosX);
                    imgCritical.setY(F1PosY);
                    imgCritical.bringToFront();
                    imgLutemon2.bringToFront();
                    imgCritical.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            imgCritical.setVisibility(View.GONE);
                        }
                    }, 1000); // 1000 milliseconds = 1 second
                }
            }


            dmg = dmg - def;

            if (dmg < 0) {
                dmg = 0;
            }
            if(isLutemon1Attacking){
                dmgL2.setText("-" + dmg);
                dmgL2.bringToFront();
                dmgL1.setVisibility(View.GONE);
                dmgL2.setVisibility(View.VISIBLE);
            }
            if(!isLutemon1Attacking){
                dmgL1.setText("-" + dmg);
                dmgL1.bringToFront();
                dmgL1.setVisibility(View.VISIBLE);
                dmgL2.setVisibility(View.GONE);
            }



            defender.setHealth(hp - dmg);
        }

        // Show current health values
        healthF1.setText(String.valueOf(lutemon1.getHealth()));
        healthF2.setText(String.valueOf(lutemon2.getHealth()));



        // Check if the defender is still alive
        if (defender.isAlive()) {
            isLutemon1Attacking = !isLutemon1Attacking;
        }
        Toast.makeText(this, attacker.getName() + " teki " + dmg + " vauriota!", Toast.LENGTH_SHORT).show();
        // Call fightEnd() method when the fight is over
        if (!attacker.isAlive() || !defender.isAlive()){
            fightEnd();
        }
        else{
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    fightButton.setVisibility(View.VISIBLE);
                }
            }, 2000); // Delay for 2 seconds (2000 milliseconds)

        }
    }


    public void fightEnd() {
        ArrayList<Lutemon> lutemons = Storage.getInstance().getLutemons();


        for (Lutemon lutemon : lutemons) {
            if (lutemon.getId() == lutemon1.getId()) {
                if (lutemon1.isAlive()) {
                    txtResult.setVisibility(View.VISIBLE);
                    txtResult.setText(lutemon.getName() + " voittaa!");
                    lutemon.setWins();
                } else {
                    imgLutemon1.setImageResource(R.drawable.losses);
                    lutemon.setLosses();
                    healthF1.setText("0");
                }
                lutemon.setHealth(lutemon.getMaxHealth());
                lutemon1.setHealth(lutemon1.getMaxHealth());
                expF1.setText(String.valueOf(lutemon.getExperience()));
            }

            if (lutemon.getId() == lutemon2.getId()) {
                if (lutemon2.isAlive()) {
                    txtResult.setVisibility(View.VISIBLE);
                    txtResult.setText(lutemon.getName() + " voittaa!");
                    lutemon.setWins();
                } else {
                    imgLutemon2.setImageResource(R.drawable.losses);
                    lutemon.setLosses();
                    healthF2.setText("0");
                }

                expF2.setText(String.valueOf(lutemon.getExperience()));
            }

        }
        backButton.setVisibility(View.VISIBLE);
    }


}