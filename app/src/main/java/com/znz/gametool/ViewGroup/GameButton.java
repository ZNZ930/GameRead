package com.znz.gametool.ViewGroup;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;

import com.znz.gametool.R;

//废弃

@SuppressLint("AppCompatCustomView")
public class GameButton extends Button {

    /*
    将图片紧贴着文字并且居中显示
     */

    private Paint paint;
    private Rect rect;
    private Drawable imgid;
    private String tName;
    private int leftPadding;
    public GameButton(Context context) {
        super(context);
    }

    public GameButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = getPaint();
        rect = new Rect();
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CustomViewTest);
        tName = array.getString(R.styleable.CustomViewTest_znz_dp);
        imgid = array.getDrawable(R.styleable.CustomViewTest_znz_img);
        array.recycle();

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        DrawabelCenterText();
        SelectXg();
    }

    private void DrawabelCenterText()
    {
        Drawable [] drawables = getCompoundDrawables();
        Drawable drawableleft = drawables[0];
        if (drawableleft != null)
        {
            float textSize = getPaint().measureText(getText().toString());
            int contentWidth = drawableleft.getIntrinsicWidth();
            int width = (int)textSize + contentWidth;
            setPadding((getWidth()-width)/2,getPaddingTop(),0,getPaddingBottom());
            int Dpadding = getPaddingLeft()-30;
            setCompoundDrawablePadding(-Dpadding);
            requestLayout();
        }
    }
    //点击效果
    private void SelectXg()
    {
        Drawable backDrawable = getBackground();
    }

}

