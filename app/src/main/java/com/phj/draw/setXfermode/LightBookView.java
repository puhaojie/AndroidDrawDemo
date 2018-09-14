package com.phj.draw.setXfermode;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import com.phj.draw.R;

/**
 *
 * Created by Administrator on 2018/9/11.
 */

public class LightBookView extends View {
    private Paint mBitPaint;
    private Bitmap BmpDST,BmpSRC;

    public LightBookView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mBitPaint = new Paint();
        BmpDST = BitmapFactory.decodeResource(getResources(), R.drawable.book_bg,null);
        BmpSRC = BitmapFactory.decodeResource(getResources(),R.drawable.book_light,null);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        //先画书架，做为目标图像
        canvas.drawBitmap(BmpDST,0,0,mBitPaint);
        mBitPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN));
        //再图光点
        canvas.drawBitmap(BmpSRC,0,0,mBitPaint);

        // 设置回来
        mBitPaint.setXfermode(null);
        canvas.restoreToCount(layerId);

    }
}
