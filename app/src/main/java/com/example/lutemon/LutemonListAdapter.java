package com.example.lutemon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LutemonListAdapter extends RecyclerView.Adapter<LutemonViewHolder>{


    private Context context;


    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    public LutemonListAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }


    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemonview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position) {
        holder.textName.setText(lutemons.get(position).getName());
        holder.textColor.setText(lutemons.get(position).getColor());
        holder.textATTACK.setText(String.valueOf(lutemons.get(position).getAttack()));
        holder.textDEFENCE.setText(String.valueOf(lutemons.get(position).getDefence()));
        holder.textLVL.setText(String.valueOf(lutemons.get(position).getExperience()));
        holder.textHEALTH.setText(String.valueOf(lutemons.get(position).getHealth()));
        holder.textMAXHEALTH.setText(String.valueOf(lutemons.get(position).getMaxHealth()));
        holder.imageLutemon.setImageResource(lutemons.get(position).getImage());
        holder.imageHealth.setImageResource(R.drawable.image_health);
        holder.imageEXP.setImageResource(R.drawable.image_xp);
        holder.imageDefence.setImageResource(R.drawable.image_defence);
        holder.imageAttack.setImageResource(R.drawable.image_attack);

        holder.imageTrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                Storage.getInstance().removeLutemon(lutemons.get(pos).getId());
                notifyItemRemoved(pos);
            }
        });
    }


    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}