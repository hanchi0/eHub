package com.jaemion.eHub.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.method.Touch;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.io.OutputStream;

public class CustomCanvas extends View {
    Paint paint = new Paint();
    Canvas mCanvas;
    Bitmap mBitmap;
    Boolean isTouched = false;
    TouchListener listener;

    int lastX, lastY, x, y;

    public CustomCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomCanvas(Context context) {
        super(context);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10f);

        lastX = -1;
        lastY = -1;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        Bitmap img = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas();
        canvas.setBitmap(img);
        canvas.drawColor(Color.WHITE);

        mBitmap = img;
        mCanvas = canvas;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(mBitmap != null){
            canvas.drawBitmap(mBitmap,0,0,paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = (int)event.getX();
        y = (int)event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                if (lastX != -1 && lastY != -1) {
                    mCanvas.drawLine(lastX, lastY, x, y, paint);
                    isTouched = true;
                    if(listener != null)
                        listener.onTouch();
                }
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_UP:
                lastX = -1;
                lastY = -1;
                break;
        }
        invalidate();
        return true;
    }

    public boolean Save(OutputStream outstream) {
        try {
            mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, outstream);
            invalidate();

            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean getIsTouched(){
        return isTouched;
    }

    public void setTouchListener(TouchListener listener){
        this.listener = listener;
    }

    public interface TouchListener{
        void onTouch();
    }
}
