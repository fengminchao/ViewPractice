package com.muxistudio.viewpractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.muxistudio.viewpractice.pie.PieActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_pie)
    Button mBtnPie;
    @BindView(R.id.activity_main)
    LinearLayout mActivityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mBtnPie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PieActivity.start(MainActivity.this);
            }
        });
    }
}
