package com.phj.draw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 *
 * Created by Administrator on 2018/9/9.
 */

public class ExtractAlphaView extends View {
    private Paint mPaint;
    private Bitmap mBitmap,mAlphaBmp;
    public ExtractAlphaView(Context context) {
        super(context);
        init();
    }

    public ExtractAlphaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ExtractAlphaView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        mPaint = new Paint();
        mBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.game);
        mAlphaBmp = mBitmap.extractAlpha();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = 200;
        int height = width * mAlphaBmp.getHeight()/mAlphaBmp.getWidth();
        mPaint.setColor(Color.RED);
        canvas.drawBitmap(mBitmap,null,new Rect(0,0,width,height),mPaint);

        mPaint.setColor(Color.GREEN);
        canvas.drawBitmap(mAlphaBmp,null,new Rect(0,height,width,2*height),mPaint);
    }
}