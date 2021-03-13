package com.znz.gametool.ViewGroup;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.znz.gametool.R;

public class HeadLineView extends View {

    private Paint Linepaint;
    private Paint textPaint;
    //文本内容
    private String text;
    //高度
    private int heightdp;
    public HeadLineView(Context context) {
        super(context);
    }

    public HeadLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Linepaint = new Paint();
        textPaint = new Paint();
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.HeadLineView);
        text = array.getString(R.styleable.HeadLineView_text);
        heightdp = array.getDimensionPixelSize(R.styleable.HeadLineView_line_dp,10);
        array.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    //设置宽度
    //设置高度
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //矩形框
        Linepaint.setColor(Color.parseColor("#FF0080"));
        Linepaint.setAlpha(70);
        canvas.drawRect(0,10,10,10,Linepaint);
    }
}
