package com.example.lutemon;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonViewHolder extends RecyclerView.ViewHolder {

    TextView textName, textColor, textLVL, textMAXHEALTH, textLine, textHEALTH, textDEFENCE, textATTACK;
    ImageView imageHealth, imageEXP, imageDefence, imageAttack, imageLutemon;






    public LutemonViewHolder(@NonNull View itemView) {
        super(itemView);
        textName = itemView.findViewById(R.id.textName);
        textColor = itemView.findViewById(R.id.textColor);
        textLVL = itemView.findViewById(R.id.textLVL);
        textMAXHEALTH = itemView.findViewById(R.id.textMAXHEALTH);
        textLine = itemView.findViewById(R.id.textVIIVA);
        textHEALTH = itemView.findViewById(R.id.textHEALTH);
        textDEFENCE = itemView.findViewById(R.id.textDEFENCE);
        textATTACK = itemView.findViewById(R.id.textATTACK);
        imageLutemon = itemView.findViewById(R.id.imageLutemon);
        imageHealth = itemView.findViewById(R.id.imageHealth);
        imageEXP = itemView.findViewById(R.id.imageEXP);
        imageDefence = itemView.findViewById(R.id.imageDefence);
        imageAttack = itemView.findViewById(R.id.imageAttack);
    }
}