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
    Ban ban = null;
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

        if( ban == null){
            return;
        }

        for(int x=1; x<=8; x++){
            for( int y=1; y<=8; y++){
                switch(ban.ban[x][y]){
                    case Ban.WHITE:
                        paint.setColor(Color.WHITE);
                        break;
                    case Ban.BLACK:
                        paint.setColor(Color.BLACK);
                        break;
                    default:
                        continue;
                }
                canvas.drawCircle( offset+(x-1)*ban_width/8+ ban_width/16,
                        offset+(y-1)*ban_width/8 + ban_width/16,
                        ban_width/8*0.4f, paint);
            }
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

    public void setBan(Ban b){
        ban = b;
    }

}
