package com.example.lutemon.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lutemon.Lutemon;
import com.example.lutemon.LutemonListAdapter;
import com.example.lutemon.R;
import com.example.lutemon.Storage;

import java.util.ArrayList;

public class FragmentHome extends Fragment {

    private RecyclerView recyclerView;

    public static LutemonListAdapter adapter;
    private ArrayList<Lutemon> lutemons;
    private TextView txtEmptyHome;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new LutemonListAdapter(getActivity(), Storage.getInstance().getLutemons());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        setupUI(view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        setupUI(getView());
    }
    private void setupUI(View view) {
        lutemons = Storage.getInstance().getLutemons();
        adapter = new LutemonListAdapter(getActivity(), Storage.getInstance().getLutemons());
        recyclerView = view.findViewById(R.id.rvListItems);
        txtEmptyHome = view.findViewById(R.id.txtEmptyHome);
        if (lutemons.isEmpty()) {
            recyclerView.setVisibility(view.GONE);
            txtEmptyHome.setVisibility(view.VISIBLE);
        }
        else {
            recyclerView.setVisibility(view.VISIBLE);
            txtEmptyHome.setVisibility(view.GONE);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(adapter);
        }
    }
}