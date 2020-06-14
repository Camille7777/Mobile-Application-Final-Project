package com.example.mobilefinalapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;


public class FontTextView extends AppCompatTextView {

    private final int CHA = 1;

    private final int GOU = 2;

    public FontTextView(Context context) {
        super(context);
    }

    public FontTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FontTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.FontTextView, defStyleAttr, 0);

        int fontType = a.getInt(R.styleable.FontTextView_fontType, 1);

        String fontPath = null;
        switch (fontType) {
                case CHA:
                    fontPath = "fonts/CHALKDUSTER.TTF";
                    break;
                case GOU:
                    fontPath = "fonts/GOUDOS.TTF";
                    break;
                default:
            }

            if (!TextUtils.isEmpty(fontPath)) {
                Typeface typeFace = Typeface.createFromAsset(getContext().getAssets(), fontPath);
                setTypeface(typeFace);

            }
        }
}

