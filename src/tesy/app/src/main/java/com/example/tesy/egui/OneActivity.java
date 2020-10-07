package com.example.tesy.egui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tesy.R;

public class OneActivity extends AppCompatActivity {

    private RecyclerView OneRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        initView();
    }

    private void initView() {
        OneRecycler = (RecyclerView) findViewById(R.id.OneRecycler);
    }
}
