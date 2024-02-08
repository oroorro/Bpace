package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class BlockShapeView extends View {

    private Paint paint;

    public BlockShapeView(Context context) {
        super(context);
        init();
    }

    public BlockShapeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BlockShapeView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
//        paint = new Paint();
//        paint.setColor(Color.DKGRAY); // Set the color to red
//        paint.setStyle(Paint.Style.FILL); // Set the style to fill
    }

//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//
//        // Draw a rectangle
//        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
//        invalidate();
//    }
}
