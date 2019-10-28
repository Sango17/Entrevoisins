package com.openclassrooms.entrevoisins.ui.neighbour_detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.openclassrooms.entrevoisins.R;

public class DetailNeighbourActivity extends AppCompatActivity {

    private TextView nameTextView;
    private TextView phoneTextView;
    private TextView mailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_neighbour);
    }
}
