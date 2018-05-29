package com.android.preetampatil.paintapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by preetampatil on 5/24/18.
 */

public class PaintView extends View {

    private Context mContext;

    private Paint mPaint;
    private Path mPath;
    private Paint mCanvasColor;

    private Canvas mCanvas;
    private Bitmap mBitmap;

    //Define default paint color
    private int mDefaultPaintColor;

    //Define default brush size
    private float defaultBrushSize;

    public PaintView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }


    // Initialize all variables with appropriate values.
    private void init(){

        mDefaultPaintColor = ContextCompat.getColor(mContext,R.color.defaultPaintColor);
        defaultBrushSize = mContext.getResources().getDimension(R.dimen.default_brush_size);

        mPath = new Path();
        mPaint = new Paint();

        mPaint.setColor(mDefaultPaintColor);
        mPaint.setStrokeWidth(defaultBrushSize);

        mPaint.setAntiAlias(true);

        //Setting brush configuration
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(mBitmap, 0 , 0, mCanvasColor);
        canvas.drawPath(mPath, mPaint);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        //create Bitmap of certain w,h
        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);

        //apply bitmap to graphic to start drawing.
        mCanvas = new Canvas(mBitmap);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float touchX = event.getX();
        float touchY = event.getY();
        //respond to down, move and up events
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:
                mPath.lineTo(touchX, touchY);
                mCanvas.drawPath(mPath, mPaint);
                mPath.reset();
                break;
            default:
                return false;
        }
        //redraw
        invalidate();
        return true;
    }

    public void cleanCanvas(){

        mCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        invalidate();


    }
}
