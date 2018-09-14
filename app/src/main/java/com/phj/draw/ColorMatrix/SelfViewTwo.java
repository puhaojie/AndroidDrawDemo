package com.phj.draw.ColorMatrix;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.phj.draw.R;

/**
 * ColorMatrix test
 */

public class SelfViewTwo extends View {

    Paint mPaint;
    ColorMatrix colorMatrix;
    ColorFilter colorFilter;
    Bitmap mBitmap;

    public SelfViewTwo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        // 只去了Read
        colorMatrix = new ColorMatrix(new float[]{
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 1, 0, 0,
                0, 0, 0, 1, 0,
        });
        colorFilter = new ColorMatrixColorFilter(colorMatrix);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.game);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        mPaint.setARGB(200,200,100,100);
        canvas.drawBitmap(mBitmap,null,new Rect(0,0,500,500),mPaint);


        canvas.translate(450,0);
        mPaint.setColorFilter(colorFilter);
        canvas.drawBitmap(mBitmap,null,new Rect(0,0,500,500),mPaint);

    }
}
