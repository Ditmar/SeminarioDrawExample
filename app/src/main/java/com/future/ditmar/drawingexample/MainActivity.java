package com.future.ditmar.drawingexample;

import android.renderscript.Float4;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.NumberFormat;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{
    private DibujoView dibujo;
    private float scale;
    private EditText txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scale=1;
        dibujo=new DibujoView(this);
        LoadComponents();
    }
    private void LoadComponents()
    {
        txt=(EditText)this.findViewById(R.id.escala);
        Button btn=(Button)this.findViewById(R.id.button);
        btn.setOnClickListener(this);
        //String txtText= txt.getText().toString();
    }
    @Override
    public boolean onTouchEvent(MotionEvent e)
    {
        int action=e.getAction();

        switch (action)
        {
            case MotionEvent.ACTION_MOVE:
            {
                dibujo.setXY(e.getX(),e.getY());
                setContentView(dibujo);
                break;
            }
        }
        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id)
        {
            case R.id.button:
            {
                String data=txt.getText().toString();
                float scale =Float.parseFloat(data);
                dibujo.setScale(scale);
                break;
            }
        }
    }
}
