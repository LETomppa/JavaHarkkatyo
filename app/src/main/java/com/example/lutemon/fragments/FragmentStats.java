package com.example.lutemon.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.anychart.palettes.DistinctColors;
import com.example.lutemon.Lutemon;
import com.example.lutemon.R;
import com.example.lutemon.Storage;

import java.util.ArrayList;
import java.util.List;


public class FragmentStats extends Fragment implements AdapterView.OnItemSelectedListener {

    private Pie pie;
    private TextView txtWins;
    private TextView txtLosses;
    private ImageView imageLutemon;
    private ArrayList<Lutemon> lutemons;

    private AnyChartView anyChartView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stats, container, false);;
        anyChartView = view.findViewById(R.id.chartView);
        pie = AnyChart.pie();
        anyChartView.setChart(pie);
        setupUI(view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        setupUI(getView());
    }

    private void setupUI(View view) {
        Spinner spinner = view.findViewById(R.id.spinnerStats);
        imageLutemon = view.findViewById(R.id.imageStatsLutemon);
        txtWins = view.findViewById(R.id.txtWins);
        txtLosses = view.findViewById(R.id.txtLosses);
        ImageView imageWins = view.findViewById(R.id.imageWins);
        ImageView imageLosses = view.findViewById(R.id.imageLosses);
        TextView txtInfo = view.findViewById(R.id.txtChooseStats);
        TextView txtEmptyStats = view.findViewById(R.id.txtEmptyStats);
        lutemons = Storage.getInstance().getLutemons();
        if (lutemons.isEmpty()) {
            spinner.setVisibility(View.GONE);
            imageLutemon.setVisibility(View.GONE);
            txtWins.setVisibility(View.GONE);
            txtLosses.setVisibility(View.GONE);
            imageWins.setVisibility(View.GONE);
            imageLosses.setVisibility(View.GONE);
            txtInfo.setVisibility(View.GONE);
            txtEmptyStats.setVisibility(View.VISIBLE);
        }
        else{
            spinner.setVisibility(View.VISIBLE);
            imageLutemon.setVisibility(View.VISIBLE);
            txtWins.setVisibility(View.VISIBLE);
            txtLosses.setVisibility(View.VISIBLE);
            imageWins.setVisibility(View.VISIBLE);
            imageLosses.setVisibility(View.VISIBLE);
            txtInfo.setVisibility(View.VISIBLE);
            txtEmptyStats.setVisibility(View.GONE);
            ArrayAdapter<Lutemon> adapter = new ArrayAdapter<>(getContext(),
                    android.R.layout.simple_spinner_dropdown_item, lutemons);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(this);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // Get the selected Lutemon object and display its image
        Lutemon selectedLutemon = lutemons.get(i);
        imageLutemon.setImageResource(selectedLutemon.getImage());
        txtWins.setText(String.valueOf(selectedLutemon.getWins()));
        txtLosses.setText(String.valueOf(selectedLutemon.getLosses()));

        chart(selectedLutemon);
    }

    public void chart(Lutemon lutemon){
        String[] colors = {"#8fce00", "#f44336",};
        pie.palette(colors);

        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("Wins", lutemon.getWins()));
        data.add(new ValueDataEntry("Losses", lutemon.getLosses()));
        pie.data(data);


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // Do nothing
    }

}