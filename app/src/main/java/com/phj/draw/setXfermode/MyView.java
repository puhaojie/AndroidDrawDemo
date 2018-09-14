package com.phj.draw.setXfermode;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.phj.draw.R;

/**
 * Created by Administrator on 2018/9/11.
 */

public class MyView extends View {
    private int width = 100;
    private int height = 100;
    private Bitmap dstBmp;
    private Bitmap srcBmp;
    private Paint mPaint;
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        dstBmp = makeDst(width,height);
        srcBmp = makeSrc(width,height);
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        int layerID = canvas.saveLayer(0,0,width*2,height*2,mPaint,Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(dstBmp, 0, 0, mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        canvas.drawBitmap(srcBmp, width/2, height/2, mPaint);
        mPaint.setXfermode(null);
        canvas.restoreToCount(layerID);
//
        canvas.translate(200,0);
        layerID = canvas.saveLayer(0,0,width*2,height*2,mPaint,Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(dstBmp, 0, 0, mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawBitmap(srcBmp, width/2, height/2, mPaint);
        mPaint.setXfermode(null);
        canvas.restoreToCount(layerID);

    }

    static Bitmap makeDst(int w, int h) {
        Bitmap bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bm);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);

        p.setColor(0xFFFFCC44);
        c.drawOval(new RectF(0, 0, w, h), p);
        return bm;
    }

    static Bitmap makeSrc(int w, int h) {
        Bitmap bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bm);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);

        p.setColor(0xFF66AAFF);
        c.drawRect(0, 0,w,h, p);
        return bm;
    }
}


