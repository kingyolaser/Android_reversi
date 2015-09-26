package com.example.user.othello;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
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

    Paint paint = new Paint();
    @Override
    protected void onDraw(Canvas canvas){
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        paint.setAntiAlias(true);

        float ban_width = getWidth()-20;
        final float offset=10;
        for( int i=0; i<=8; i++){
            canvas.drawLine(offset,offset+i*ban_width/8,
                    offset+ban_width, offset+i*ban_width/8, paint);
        }
        for( int i=0; i<=8; i++){
            canvas.drawLine(offset+i*ban_width/8,offset,
                    offset+i*ban_width/8, offset+ban_width, paint);
        }
    }

    public boolean onTouchEvent(@NonNull MotionEvent e){
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
