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
        // this method is called when the user taps on the image
        imgPikseli = findViewById(R.id.imgPikseli);
        petCounter++;
        txtCounter.setText(String.valueOf(petCounter));
        if (imgPikseli.getRotationX() != 0) { // if the image is not upright, rotate it back to upright
            imgPikseli.setRotationX(0);
        }
        imgPikseli.animate().rotationXBy(360); // animate the image to rotate on the X-axis by 360 degrees

        // if the user has petted the image 25 times and has not found the Easter egg before
        if (petCounter == 25 && !Storage.getInstance().getEasterEggBoolean()){
            Lutemon Pikseli = new SecretHedgehog();
            Storage.getInstance().addLutemon(Pikseli);
            Storage.getInstance().setEasterEggBoolean();
            Toast.makeText(this, "PIKSELI LIITTYY MUKAASI!", Toast.LENGTH_SHORT).show();
        }
    }

    // this method is called when the user taps on the back button
    public void switchBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent); // goes back to the main activity
    }

}