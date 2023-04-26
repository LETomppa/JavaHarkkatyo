package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FightActivity extends AppCompatActivity {

    private Lutemon lutemon1;
    private Lutemon lutemon2;
    private ImageView imgLutemon1;
    private ImageView imgLutemon2;
    private TextView txtLutemon1;
    private TextView txtLutemon2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);

        /*lutemon1 = getIntent().getParcelableExtra("Lutemon1");
        lutemon2 = getIntent().getParcelableExtra("Lutemon2");
        imgLutemon1 = findViewById(R.id.lutemon1_image);
        imgLutemon2 = findViewById(R.id.lutemon2_image);
        txtLutemon1 = findViewById(R.id.lutemon1_name);
        txtLutemon2 = findViewById(R.id.lutemon2_name);
        imgLutemon1.setImageResource(lutemon1.getImage());
        imgLutemon2.setImageResource(lutemon2.getImage());
        txtLutemon1.setText(lutemon1.getName());
        txtLutemon2.setText(lutemon2.getName());*/
    }
}
