package com.phj.draw.setColorFilter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.phj.draw.R;

/**
 * 1、PorterDuffColorFilter只能实现与一个特定颜色值的合成。
 * 2、通过Mode.ADD(饱和度相加)，Mode.DARKEN（变暗），Mode.LIGHTEN（变亮），Mode.MULTIPLY（正片叠底），Mode.OVERLAY（叠加），Mode.SCREEN（滤色）可以实现与指定颜色的复合。
 * 3、通过Mode.SRC、Mode.SRC_IN、Mode.SRC_ATOP能够实现setTint()的功能，可以改变纯色图标的颜色。
 * Created by Administrator on 2018/9/9.
 */

public class SelfViewTwo extends View {

    private Paint mPaint;
    private Bitmap mBmp;

    public SelfViewTwo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();

        mBmp = BitmapFactory.decodeResource(getResources(), R.drawable.game);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setAntiAlias(true);

        drawPorterDuffFilter2(canvas);
    }

    private void drawPorterDuffFilter(Canvas canvas){
        int width  = 300;
        int height = width * mBmp.getHeight()/mBmp.getWidth();

        mPaint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.ADD));//饱和度相加
        canvas.drawBitmap(mBmp,null,new Rect(0,0,width,height),mPaint);


        canvas.translate(350,0);
        mPaint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DARKEN));//变暗
        canvas.drawBitmap(mBmp,null,new Rect(0,0,width,height),mPaint);

        canvas.translate(-350,350);
        mPaint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.LIGHTEN));//变亮
        canvas.drawBitmap(mBmp,null,new Rect(0,0,width,height),mPaint);

        canvas.translate(350,0);
        mPaint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY));//正片叠底
        canvas.drawBitmap(mBmp,null,new Rect(0,0,width,height),mPaint);

        canvas.translate(-350,350);
        mPaint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.OVERLAY));//叠加
        canvas.drawBitmap(mBmp,null,new Rect(0,0,width,height),mPaint);

        canvas.translate(350,0);
        mPaint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.SCREEN));//滤色
        canvas.drawBitmap(mBmp,null,new Rect(0,0,width,height),mPaint);
    }

    /**
     * 清空模式
     * PorterDuff.Mode.CLEAR 和 PorterDuff.Mode.XOR 不会显示的
     */
    private void drawPorterDuffFilter2(Canvas canvas){
        int width  = 300;
        int height = width * mBmp.getHeight()/mBmp.getWidth();

        canvas.drawBitmap(mBmp,null,new Rect(0,0,width,height),mPaint);

        canvas.save();
        canvas.translate(350,0);
        mPaint.setColorFilter(new PorterDuffColorFilter(0x1FFF0000, PorterDuff.Mode.CLEAR));
        canvas.drawBitmap(mBmp,null,new Rect(0,0,width,height),mPaint);
        canvas.restore();


        canvas.translate(0,400);
        mPaint.setColorFilter(new PorterDuffColorFilter(0x1FFF0000, PorterDuff.Mode.XOR));
        canvas.drawBitmap(mBmp,null,new Rect(0,0,width,height),mPaint);
    }


    /**
     * 目标图像模式
     * Mode.DST、Mode.DST_IN、Mode.DST_OUT、Mode.DST_OVER、Mode.DST_ATOP
     * 除了Mode.DST_OUT显示完全透明图片以外，其它全部显示目标图像；
     */
    private void drawPorterDuffFilter3(Canvas canvas){
        int width  = 500;
        int height = width * mBmp.getHeight()/mBmp.getWidth();

        canvas.drawBitmap(mBmp,null,new Rect(0,0,width,height),mPaint);

        canvas.translate(550,0);
        mPaint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DST));
        canvas.drawBitmap(mBmp,null,new Rect(0,0,width,height),mPaint);

        canvas.translate(-550,550);
        mPaint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DST_IN));
        canvas.drawBitmap(mBmp,null,new Rect(0,0,width,height),mPaint);

        canvas.translate(550,0);
        mPaint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DST_OUT));
        canvas.drawBitmap(mBmp,null,new Rect(0,0,width,height),mPaint);

        canvas.translate(-550,550);
        mPaint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DST_OVER));
        canvas.drawBitmap(mBmp,null,new Rect(0,0,width,height),mPaint);

        canvas.translate(550,0);
        mPaint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DST_ATOP));
        canvas.drawBitmap(mBmp,null,new Rect(0,0,width,height),mPaint);
    }

    /**
     * 源图模式
     * Mode.SRC、Mode.SRC_IN、Mode.SRC_OUT、Mode.SRC_OVER、Mode.SRC_ATOP
     * 除了Mode.SRC_OUT显示完全透明图片以外，其它全部显示源图像；
     */
    private void drawPorterDuffFilter4(Canvas canvas){
        int width  = 500;
        int height = width * mBmp.getHeight()/mBmp.getWidth();

        canvas.drawBitmap(mBmp,null,new Rect(0,0,width,height),mPaint);

        canvas.translate(550,0);
        mPaint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.SRC));
        canvas.drawBitmap(mBmp,null,new Rect(0,0,width,height),mPaint);

        canvas.translate(-550,550);
        mPaint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(mBmp,null,new Rect(0,0,width,height),mPaint);

        canvas.translate(550,0);
        mPaint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.SRC_OUT));
        canvas.drawBitmap(mBmp,null,new Rect(0,0,width,height),mPaint);

        canvas.translate(-550,550);
        mPaint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.SRC_OVER));
        canvas.drawBitmap(mBmp,null,new Rect(0,0,width,height),mPaint);

        canvas.translate(550,0);
        mPaint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(mBmp,null,new Rect(0,0,width,height),mPaint);
    }


    /**
     * SRC相关的模式，只有Mode.SRC_ATOP和SRC_IN能够实现SetTint的功能
     */
    private void drawPorterDuffFilter5(Canvas canvas){
        int width  = 100;
        int height = width * mBmp.getHeight()/mBmp.getWidth();

        canvas.drawBitmap(mBmp,null,new Rect(0,0,width,height),mPaint);

        canvas.translate(150,0);
        mPaint.setColorFilter(new PorterDuffColorFilter(0xffff00ff, PorterDuff.Mode.SRC));
        canvas.drawBitmap(mBmp,null,new Rect(0,0,width,height),mPaint);

        canvas.translate(150,0);
        mPaint.setColorFilter(new PorterDuffColorFilter(0xff00f0ff, PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(mBmp,null,new Rect(0,0,width,height),mPaint);

        canvas.translate(150,0);
        mPaint.setColorFilter(new PorterDuffColorFilter(0xfff0f0ff, PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(mBmp,null,new Rect(0,0,width,height),mPaint);

        canvas.translate(150,0);
        mPaint.setColorFilter(new PorterDuffColorFilter(0xffffff00, PorterDuff.Mode.SRC_OVER));
        canvas.drawBitmap(mBmp,null,new Rect(0,0,width,height),mPaint);


        canvas.translate(150,0);
        mPaint.setColorFilter(new PorterDuffColorFilter(0xff000000, PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(mBmp,null,new Rect(0,0,width,height),mPaint);
    }


}
