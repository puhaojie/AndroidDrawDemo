package com.phj.draw.ColorMatrix;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * ColorMatrix test
 * 这里分两次绘制了一个bitmap，第一次绘制了一个原始图像，
 * 然后利用ColorMatrix生成了一个仅包含蓝色的图像，
 * 用过PhotoShop的同学应该很清楚这个跟PhotoShop中的蓝色通道的效果是一致的。
 */

public class SelfView extends View {

    Paint mPaint;
    ColorMatrix colorMatrix;
    ColorFilter colorFilter;

    public SelfView(Context context, @Nullable AttributeSet attrs) {
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
    }

    @Override
    protected void onDraw(Canvas canvas) {

        mPaint.setARGB(100,200,100,100);
        canvas.drawRect(0,0,500,500,mPaint);


        canvas.translate(450,0);
        mPaint.setColorFilter(colorFilter);
        canvas.drawRect(0,0,500,500,mPaint);

    }
}
