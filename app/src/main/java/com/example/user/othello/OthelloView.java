package com.example.user.othello;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by T.Nogami on 2015/09/26.
 */
public class OthelloView extends View {
    public OthelloView(Context context){
        super(context);
        setFocusable(true);
    }
    public OthelloView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFocusable(true);
    }

    public OthelloView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setFocusable(true);
    }


    @Override
    protected void onDraw(Canvas canvas){
        Paint paint = new Paint();
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(10);
        paint.setAntiAlias(true);
        canvas.drawCircle(100, 100, 50, paint);
    }

    public boolean onTouchEvent(MotionEvent e){
        switch(e.getAction()){
            case MotionEvent.ACTION_DOWN:
                //x=(int)e.getX();
                //y=(int)e.getY();
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                //x=(int)e.getX();
                //y=(int)e.getY();
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                performClick();
                break;
        }
        return true;
    }

}
