package com.muen.huarongdao.main;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class CubeView extends AppCompatTextView {
    private Position mPosition;
    private int mNumber;

    public CubeView(Context context) {
        super(context);
        init();
    }

    public CubeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CubeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
    }

    public void setNumber(int n) {
        mNumber = n;
        setText(String.valueOf(n));
    }

    public int getNumber() {
        return mNumber;
    }

    public Position getPosition() {
        return mPosition;
    }

    public void setPosition(Position position) {
        this.mPosition = position;
    }

    @Override
    public String toString() {
        return "CubeView{" +
                "mPosition=" + mPosition +
                ", mNumber=" + mNumber +
                '}';
    }
}
