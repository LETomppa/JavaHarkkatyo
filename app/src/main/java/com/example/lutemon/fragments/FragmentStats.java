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

import com.anychart.AnyChart; //COMMENT OUT IF DOESNT WORK
import com.anychart.AnyChartView; //COMMENT OUT IF DOESNT WORK
import com.anychart.chart.common.dataentry.DataEntry; //COMMENT OUT IF DOESNT WORK
import com.anychart.chart.common.dataentry.ValueDataEntry; //COMMENT OUT IF DOESNT WORK
import com.anychart.charts.Pie; //COMMENT OUT IF DOESNT WORK
import com.anychart.palettes.DistinctColors; //COMMENT OUT IF DOESNT WORK
import com.example.lutemon.Lutemon;
import com.example.lutemon.R;
import com.example.lutemon.Storage;

import java.util.ArrayList;
import java.util.List;

/*
                                READ ME IMPORTANT:
    PROJECT HAS IMPLEMENTED ANYCHART. IT NEEDS NEWEST VERSION OF ANDROID STUDIO TO WORK.
    IF DOES NOT WORK. TRY COMMENTING LINES OF CODE BELOW AS INSTRUCTED.
    ALSO GO TO FRAGMENT_STATS.XML AND COMMENT THE CODE FROM THE TOP OF THE FILE AS SHOWN:

        <!--    <androidx.constraintlayout.widget.ConstraintLayout
                android:layout_width="200dp"
                android:layout_height="200dp"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintStart_toEndOf="@+id/txtLosses"
                app:layout_constraintTop_toTopOf="@+id/txtWins">

                <com.anychart.AnyChartView
                    android:id="@+id/chartView"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    tools:layout_editor_absoluteX="0dp"
                    tools:layout_editor_absoluteY="0dp" />

            </androidx.constraintlayout.widget.ConstraintLayout>    -->

 */

//This fragment shows the stats of lutemons
public class FragmentStats extends Fragment implements AdapterView.OnItemSelectedListener {

    private Pie pie; //COMMENT OUT IF DOESNT WORK
    private TextView txtWins;
    private TextView txtLosses;
    private ImageView imageLutemon;
    private ArrayList<Lutemon> lutemons;

    private AnyChartView anyChartView;


    // IF YOU DONT HAVE THE LATEST VERSION OF ANDROID STUDIO, COMMENT OUT THE ANYCHART STUFF MARKED WITH A COMMENT LINES WITH //COMMENT OUT IF DOESNT WORK
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stats, container, false);;
        anyChartView = view.findViewById(R.id.chartView); //COMMENT OUT IF DOESNT WORK
        pie = AnyChart.pie(); //COMMENT OUT IF DOESNT WORK
        anyChartView.setChart(pie); //COMMENT OUT IF DOESNT WORK
        setupUI(view);
        return view;
    }

    @Override
    public void onResume() { // refreshes the list every time the tab has been resumed
        super.onResume();
        setupUI(getView());
    }

    private void setupUI(View view) { // Set up the UI components
        Spinner spinner = view.findViewById(R.id.spinnerStats);
        imageLutemon = view.findViewById(R.id.imageStatsLutemon);
        txtWins = view.findViewById(R.id.txtWins);
        txtLosses = view.findViewById(R.id.txtLosses);
        ImageView imageWins = view.findViewById(R.id.imageWins);
        ImageView imageLosses = view.findViewById(R.id.imageLosses);
        TextView txtInfo = view.findViewById(R.id.txtChooseStats);
        TextView txtEmptyStats = view.findViewById(R.id.txtEmptyStats);
        lutemons = Storage.getInstance().getLutemons();
        if (lutemons.isEmpty()) { // if theres no lutemons, the fragment is empty and suggests to create some
            spinner.setVisibility(View.GONE);
            imageLutemon.setVisibility(View.GONE);
            txtWins.setVisibility(View.GONE);
            txtLosses.setVisibility(View.GONE);
            imageWins.setVisibility(View.GONE);
            imageLosses.setVisibility(View.GONE);
            txtInfo.setVisibility(View.GONE);
            txtEmptyStats.setVisibility(View.VISIBLE);
        }
        else{ // displays the fragment when lutemons have been created
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

    public void chart(Lutemon lutemon){ //COMMENT THIS FUNCTION OUT IF DOESNT WORK. This adds a chart to the stats
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