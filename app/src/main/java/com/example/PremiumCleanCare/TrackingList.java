package com.example.PremiumCleanCare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class TrackingList extends AppCompatActivity {

    private RecyclerView recycler_view;
    private TrackingAdapter adapter;
    private ArrayList<Tracking> trackingArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tracking);

        addData();

        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);

        adapter = new TrackingAdapter(trackingArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(TrackingList.this);

        recycler_view.setLayoutManager(layoutManager);

        recycler_view.setAdapter(adapter);

        recycler_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( TrackingList.this, DetailTracking.class);
                startActivity(intent);
                finish();
            }
        });

    }

    void addData() {
        trackingArrayList = new ArrayList<>();
        trackingArrayList.add(new Tracking("TN001", "2019-05-28", "Rp 80000"));
        trackingArrayList.add(new Tracking("TN002", "2019-05-28", "Rp 20000"));
        trackingArrayList.add(new Tracking("TN003", "2019-05-28", "Rp 5000"));
    }

}
