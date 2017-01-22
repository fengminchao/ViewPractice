package com.muxistudio.viewpractice.pie;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.muxistudio.viewpractice.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ybao on 17/1/20.
 */

public class PieActivity extends AppCompatActivity {

    @BindView(R.id.pie_view)
    PieView mPieView;

    public static void start(Context context) {
        Intent starter = new Intent(context, PieActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie);
        ButterKnife.bind(this);

        ArrayList<PieData> pieDatas = new ArrayList<>();
        for (int i = 0;i < 10;i ++){
            PieData piedata = new PieData();
            piedata.setValue(i * 3);
            pieDatas.add(piedata);
        }
        mPieView.setData(pieDatas);

    }

}
