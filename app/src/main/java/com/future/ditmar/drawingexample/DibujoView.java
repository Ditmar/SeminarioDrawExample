package com.future.ditmar.drawingexample;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by ditmar on 9/28/15.
 */
public class DibujoView extends View {
    private float x,y;

    public DibujoView(Context contexto)
    {
        super(contexto);
        this.x=0;
        this.y=0;
    }
    public void setXY(float x,float y)
    {
        this.x=x;
        this.y=y;
    }
    @Override
    protected void onDraw(Canvas canvas)
    {
        Paint pincel=new Paint();
        pincel.setColor(getResources().getColor(R.color.negro));
        canvas.drawCircle(this.x,this.y-50,50f,pincel);
        canvas.save();
    }

}
