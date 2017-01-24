package com.muxistudio.viewpractice.loadingview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;

/**
 * Created by ybao on 17/1/22.
 */

public class LoadingActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CalendarView calendarView = new CalendarView(this);
    }
}
