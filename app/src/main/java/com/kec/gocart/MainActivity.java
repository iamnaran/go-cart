package com.kec.gocart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView counterTv;
    //textView

    private TextView tvPlusCounter;
    //textView4

    private TextView tvMinusCounter;
    //textView3

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListener();

    }

    private void initViews() {

        counterTv = findViewById(R.id.textView);
        tvPlusCounter = findViewById(R.id.textView4);
        tvMinusCounter = findViewById(R.id.textView3);

    }


    private void initListener() {

        tvPlusCounter.setOnClickListener(this);
        tvMinusCounter.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.textView4:

                // plus counter



                break;

            case R.id.textView3:

                // minus counter


                break;
        }

    }
}