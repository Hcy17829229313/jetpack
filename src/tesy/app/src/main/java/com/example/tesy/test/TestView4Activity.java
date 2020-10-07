package com.example.tesy.test;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tesy.R;

import java.util.LinkedList;

public class TestView4Activity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    private Button btn_1;
    private Button btn_2;
    private Button btn_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_view4);
        initView();
    }

    private void initView() {
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);

        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                btn_1.setOnClickListener(this);
                btn_1.setOnTouchListener(this);

                break;
            case R.id.btn_2:
                btn_2.setOnClickListener(this);
                btn_2.setOnTouchListener(this);

                break;
            case R.id.btn_3:
                btn_3.setOnClickListener(this);
                btn_3.setOnTouchListener(this);

                break;
        }
    }



    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Log.d("tag", "onTouch: "+motionEvent);
        return false;
    }
}
