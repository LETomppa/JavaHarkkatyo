package com.example.lutemon.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.lutemon.Black;
import com.example.lutemon.Green;
import com.example.lutemon.Lutemon;
import com.example.lutemon.Orange;
import com.example.lutemon.Pink;
import com.example.lutemon.R;
import com.example.lutemon.Storage;
import com.example.lutemon.White;

public class FragmentCreate extends Fragment {

    private EditText name;
    private String stringName;
    private Lutemon l;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create, container, false);
        name = view.findViewById(R.id.txtName);
        Button addButton = view.findViewById(R.id.btnCreate);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringName = name.getText().toString();
                RadioGroup rgColorType = view.findViewById(R.id.rgColors);
                switch (rgColorType.getCheckedRadioButtonId()) {
                    case R.id.rbWhite:
                        l = new White(stringName);
                        break;
                    case R.id.rbGreen:
                        l = new Green(stringName);
                        break;
                    case R.id.rbPink:
                        l = new Pink(stringName);
                        break;
                    case R.id.rbOrange:
                        l = new Orange(stringName);
                        break;
                    case R.id.rbBlack:
                        l = new Black(stringName);
                        break;
                    default:
                        Toast.makeText(getContext(), "Valitse väri", Toast.LENGTH_LONG).show();
                }
                Storage.getInstance().addLutemon(l);
                FragmentHome.adapter.notifyDataSetChanged();

            }
        });

        return view;
    }
}
