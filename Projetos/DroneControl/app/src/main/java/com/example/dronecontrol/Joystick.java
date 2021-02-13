package com.example.dronecontrol;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class Joystick extends SurfaceView implements SurfaceHolder.Callback
{
    private float CenterX;
    private float CenterY;
    private float baseRadius;
    private float hatRadius;

    private void setupDimensions()
    {
        CenterX = getWidth() / 2;
        CenterY = getHeight() / 2;
        baseRadius = Math.min(getWidth(),getHeight()) / 3;
        hatRadius = Math.min(getWidth(),getHeight()) / 5;
    }

    public Joystick(Context context){
        super(context);
        getHolder().addCallback(this);
        setOnTouchListener(this);
    }
    public Joystick(Context context,AttributeSet attributes, int style){
        super(context, attributes, style);
        getHolder().addCallback(this);
        setOnTouchListener(this);
    }
    public Joystick(Context context, AttributeSet attributes){
        super(context, attributes);
        getHolder().addCallback(this);
        setOnTouchListener(this);
    }

    private void DrawJoystick(float newX, float newY){
        if (getHolder().getSurface().isValid())
        {
            Canvas myCanvas = this.getHolder().lockCanvas();
            Paint colors = new Paint();
            myCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
            colors.setARGB(255,50,50,50);
            myCanvas.drawCircle(CenterX,CenterY,baseRadius,colors);
            colors.setARGB(255,0,0,255);
            myCanvas.drawCircle(newX,newY,hatRadius,colors);
            getHolder().unlockCanvasAndPost(myCanvas);
        }

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder){
    setupDimensions();
    DrawJoystick(CenterX,CenterY);
    }
    @Override
    public void surfaceChanged(SurfaceHolder, int format, int width, int height){

    }
    @Override
    public void surfaceDestroyed(SurfaceHolder holder){

    }
    public boolean onTouch(View v, MotionEvent e){

        if(v.equals(this)){
            if(e.getAction() != e.ACTION_UP)
            {
                DrawJoystick(e.getX(),e.getY());
            }
            else{
                DrawJoystick(CenterX,CenterY);
            }
            return true;
        }
    }
}
