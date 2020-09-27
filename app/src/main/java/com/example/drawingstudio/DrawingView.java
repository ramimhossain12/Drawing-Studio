package com.example.drawingstudio;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import  android.view.View;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.TypedValue;
import android.content.Context;
import android.util.AttributeSet;


public class DrawingView extends View{

    private Path drawPath;
    private boolean erase = false;
    private Paint drawpaint,canvasPaint;
    private Canvas drawCanvas;
    private  int painColor = 0xFF660000;
    private Bitmap canvasBitmap;
    private float brushSize,lastBrushSize;
    public DrawingView(Context context,AttributeSet attrs) {
        super(context,attrs);
        setupDrawing();
    }



    public  void startNew(){
        drawCanvas.drawColor(0,PorterDuff.Mode.CLEAR);
        invalidate();
    }
    public void setErase(boolean isErase){
        erase  = isErase;
        if (erase) drawpaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        else drawpaint.setXfermode(null);
    }
    public void setBrushSize(float newSize){
        float pixelAmount = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,newSize,getResources().getDisplayMetrics());
        brushSize = pixelAmount;
        drawpaint.setStrokeWidth(brushSize);
    }

    public  void  setLastBrushSize(float lastsize){
        lastBrushSize = lastsize;

    }
    public float getBrushSize(){
        return lastBrushSize;
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        canvasBitmap = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(canvasBitmap,0,0,canvasPaint);
        canvas.drawPath(drawPath,drawpaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        float touchX = event.getX();
        float touchY = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                drawPath.moveTo(touchX,touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                drawPath.lineTo(touchX,touchY);
                break;
            case MotionEvent.ACTION_UP:
                drawPath.reset();
                break;
            default:
                return false;
        }
        invalidate();
        return true;
    }

    private void setupDrawing() {


    }
}
