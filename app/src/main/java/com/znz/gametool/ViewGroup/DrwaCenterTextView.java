package com.znz.gametool.ViewGroup;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.icu.text.TimeZoneFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.znz.gametool.R;

@SuppressLint("AppCompatCustomView")
public class DrwaCenterTextView extends TextView {

    private Rect rect;
    private int drawablek;
    private int zongk;
    private int jianxik;
    private float textheight;
    private String DrawText;
    private int drawableh;

    public DrwaCenterTextView(Context context) {
        super(context);
    }

    public DrwaCenterTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        rect = new Rect();
    }

    public DrwaCenterTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.CustomViewTest);
        DrawText = array.getString(R.styleable.CustomViewTest_znz_dp);
        array.recycle();
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        CenterText();
    }

    private void CenterText()
    {
        Drawable drawables [] = getCompoundDrawables();
        Drawable left = drawables[0];
        if (left!=null)
        {
            float textSizek = getPaint().measureText(getText().toString());
             drawablek = left.getIntrinsicWidth();
             drawableh= left.getIntrinsicHeight();
             zongk = (int)textSizek + drawablek;
            jianxik = getWidth()-zongk;
            setPadding(jianxik/2-50,getPaddingTop(),0,getPaddingBottom());
        }
        requestLayout();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStrokeWidth(6);
        paint.setTextSize(40);
        canvas.drawText(getDrawText(),jianxik/2+drawablek-50,drawableh,paint);
    }

    public String getDrawText()
    {
        return  DrawText;
    }

    public void setDrawText(String DrawText)
    {
        this.DrawText = DrawText;
    }
}
