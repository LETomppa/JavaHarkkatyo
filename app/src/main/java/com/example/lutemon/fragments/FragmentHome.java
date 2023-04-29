package com.example.lutemon.fragments;

import android.annotation.SuppressLint;
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

    @SuppressLint("StaticFieldLeak")
    public static LutemonListAdapter adapter;


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
    public void onResume() { // refreshes the list every time the tab has been resumed
        super.onResume();
        setupUI(getView());
    }
    private void setupUI(View view) { // Set up the UI components
        ArrayList<Lutemon> lutemons = Storage.getInstance().getLutemons();
        adapter = new LutemonListAdapter(getActivity(), Storage.getInstance().getLutemons());
        RecyclerView recyclerView = view.findViewById(R.id.rvListItems);
        TextView txtEmptyHome = view.findViewById(R.id.txtEmptyHome);
        if (lutemons.isEmpty()) { // if theres no lutemons, the fragment is empty and suggests to create some
            recyclerView.setVisibility(View.GONE);
            txtEmptyHome.setVisibility(View.VISIBLE);
        }
        else { // displays the fragment when lutemons have been created
            recyclerView.setVisibility(View.VISIBLE);
            txtEmptyHome.setVisibility(View.GONE);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(adapter);
        }
    }
}