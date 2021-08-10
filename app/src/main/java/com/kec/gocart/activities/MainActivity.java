package com.kec.gocart.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kec.gocart.HomeActivity;
import com.kec.gocart.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView counterTv;
    //textView

    private TextView tvPlusCounter;
    //textView4

    private TextView tvMinusCounter;
    //textView3

    private int counterValue = 0;


    private Button btn;


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
        btn = findViewById(R.id.btn1);

    }


    private void initListener() {

        tvPlusCounter.setOnClickListener(this);
        tvMinusCounter.setOnClickListener(this);
        btn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {


        switch (v.getId()){
            case R.id.textView4:

                // plus counter

                doCounterIncreaseWork();

                break;

            case R.id.textView3:

                // minus counter
                doCounterDecreaseWork();



                break;

            case R.id.btn1:


                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                intent.putExtra("COUNTER_VALUE",counterTv.getText());
                startActivity(intent);
//                overridePendingTransition(R.anim.fade_in_animation,R.anim.fade_in_animation);


                break;
        }

    }

    private void doCounterDecreaseWork() {

        if (counterValue < 0){
            return;
        }
        counterValue = counterValue--;

        counterTv.setText(String.valueOf(counterValue));



    }

    private void doCounterIncreaseWork() {


        counterValue = counterValue++;
        counterTv.setText(String.valueOf(counterValue));



    }


}