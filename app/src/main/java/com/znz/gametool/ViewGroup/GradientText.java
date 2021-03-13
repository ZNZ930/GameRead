package com.znz.gametool.ViewGroup;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.znz.gametool.R;

@SuppressLint("AppCompatCustomView")
public class GradientText extends TextView {
    private boolean JbColor;
    public GradientText(Context context) {
        super(context);
    }

    public GradientText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.DrwaCenterTextView);
        JbColor = array.getBoolean(R.styleable.DrwaCenterTextView_gradientColor,false);
        array.recycle();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Paint paint = getPaint();
        if (JbColor == true)
        {
            getPaint().setShader(new LinearGradient(
                    0, 0, getWidth(), getHeight(),
                    new int[]{Color.parseColor("#FF0080"), Color.parseColor("#00E3E3"),Color.parseColor("#3C3C3C")}, new float[]{0f, 0.5f, 1f},
                    Shader.TileMode.CLAMP));
        }
    }
}
