package com.future.ditmar.drawingexample;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * Created by ditmar on 9/28/15.
 */
public class DibujoView extends View {
    private int x,y;
    private Drawable git;
    private float width,height;
    private float scale;
    public DibujoView(Context contexto)
    {
        super(contexto);
        this.x=0;
        this.y=0;
        git=getResources().getDrawable(R.drawable.github);
        scale=1;
        width=git.getIntrinsicWidth();
        height=git.getIntrinsicHeight();
    }
    public void setScale(float scale)
    {
        this.scale=scale;
    }
    public void setXY(float x,float y)
    {
        this.x=(int)x-(int)(width/2);
        this.y=(int)y-(int)(height/2);
    }
    @Override
    protected void onDraw(Canvas canvas)
    {

        git.setBounds(this.x,this.y,this.x+(int)(this.width*this.scale),this.y+(int)(this.height*this.scale));
        git.draw(canvas);
       // canvas.save();
    }

}
