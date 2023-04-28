package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EasterEggActivity extends AppCompatActivity {
    private static int petCounter;
    private ImageView imgPikseli;
    private TextView txtCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easter_egg);
        txtCounter = findViewById(R.id.txtSilitetty);
        txtCounter.setText(String.valueOf(petCounter));
    }

    public void petPikseli(View view) {
        imgPikseli = findViewById(R.id.imgPikseli);
        petCounter++;
        txtCounter.setText(String.valueOf(petCounter));
        if (imgPikseli.getRotationX() != 0) {
            imgPikseli.setRotationX(0);
        }
        imgPikseli.animate().rotationXBy(360);

        if (petCounter == 25){
            if (!Storage.getInstance().getEasterEggBoolean()) {
                Lutemon Pikseli = new SecretHedgehog();
                Storage.getInstance().addLutemon(Pikseli);
                Storage.getInstance().setEasterEggBoolean();
            }
            Toast.makeText(this, "Löysit Pikselin!", Toast.LENGTH_SHORT).show();
        }

    }

    public void switchBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}