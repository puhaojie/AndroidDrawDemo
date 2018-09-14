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

public class ShadowLayerView extends View {
    private Paint mPaint = new Paint();
    private Bitmap mDogBmp;
    public ShadowLayerView(Context context) {
        super(context);
        init();
    }

    public ShadowLayerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ShadowLayerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        setLayerType( LAYER_TYPE_SOFTWARE , null);
        mPaint.setColor(Color.GREEN);
        mPaint.setTextSize(25);
        mPaint.setShadowLayer(1, 10, 10, Color.GRAY);
        mDogBmp = BitmapFactory.decodeResource(getResources(),R.drawable.game);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawText("启舰大SB",100,100,mPaint);

        canvas.drawCircle(200,200,50,mPaint);

        canvas.drawBitmap(mDogBmp,null,new Rect(200,300,200+mDogBmp.getWidth(),300+mDogBmp.getHeight()),mPaint);
    }
}

