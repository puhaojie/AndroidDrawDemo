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
 * PhotoShop中的反相功能，ColorMatrix中的值不一样，拿255-之前的值
 */


public class SelfViewThree extends View {

    Paint mPaint;
    ColorMatrix colorMatrix;
    ColorFilter colorFilter;
    Bitmap mBitmap;

    public SelfViewThree(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();

        mPaint.setAntiAlias(true);
//        colorMatrix.setConcat(ColorMatrix matA, ColorMatrix matB) // 设置矩阵相乘
//        colorMatrix.setRotate(); // 设置旋转
//        colorMatrix.setSaturation();  // setSaturation——设置饱和度，同时增加RGB值
//        colorMatrix.setScale(); // 色彩缩放
        // 只去了Read
        colorMatrix = new ColorMatrix(new float[]{
                -1,0,0,0,255,
                0,-1,0,0,255,
                0,0,-1,0,255,
                0,0,0,1,0
        });

//        色彩的缩放运算
        colorMatrix = new ColorMatrix(new float[]{
                1.2f, 0, 0, 0, 0,
                0, 1.2f, 0, 0, 50,
                0, 0, 1.2f, 0, 0,
                0, 0, 0, 1.2f, 0,
        });


//        色彩反色 （红绿反色）
        colorMatrix = new ColorMatrix(new float[]{
                0,1,0,0,0,
                1,0,0,0,0,
                0,0,1,0,0,
                0,0,0,1,0
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
