package com.phj.draw;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 发光效果
 *
 * Created by Administrator on 2018/9/9.
 */

public class BlurMaskFilterView extends View {
    private Paint mPaint;
    public BlurMaskFilterView(Context context) {
        super(context);
        init();
    }

    public BlurMaskFilterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BlurMaskFilterView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.OUTER));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(200,200,100,mPaint);
    }
}
