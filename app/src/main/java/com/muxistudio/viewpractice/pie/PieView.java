package com.muxistudio.viewpractice.pie;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by ybao on 17/1/20.
 */

public class PieView extends View {
    private int[] mColors =
            {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
                    0xFFE6B800, 0xFF7CFC00};
    private float mStartAngle = 0;
    private ArrayList<PieData> mData;
    private int mWidth, mHeight;
    private Paint mPaint = new Paint();

    public PieView(Context context) {
        this(context, null);
    }

    public PieView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (null == mData) {
            return;
        }
        canvas.translate(mWidth / 2, mHeight / 2);
        RectF rectF = new RectF(-500,-500,500,500);
        float startAngle = mStartAngle;
        for (int i = 0;i < mData.size();i ++){
            mPaint.setColor(mData.get(i).getColor());
            canvas.drawArc(rectF,startAngle,mData.get(i).getAngle(),true,mPaint);
            startAngle += mData.get(i).getAngle();
        }

    }

    public void setStartAngle(int mStartAngle) {
        this.mStartAngle = mStartAngle;
        invalidate();   // 刷新
    }

    public void setData(ArrayList<PieData> mData) {
        this.mData = mData;
        initData(mData);
        invalidate();
    }

    private void initData(ArrayList<PieData> data){
        if (data == null || data.size() == 0){
            return;
        }

        float sum = 0;
        for (int i = 0;i < data.size();i ++){
            sum += data.get(i).getValue();
        }

        for (int i = 0;i < data.size();i ++){
            PieData pieData = data.get(i);
            pieData.setColor(mColors[i % mColors.length]);
            pieData.setPercent(pieData.getValue() / sum);
            Log.d("percent",pieData.getPercent() + "");
            pieData.setAngle(pieData.getPercent()  * 360);
        }


    }

}