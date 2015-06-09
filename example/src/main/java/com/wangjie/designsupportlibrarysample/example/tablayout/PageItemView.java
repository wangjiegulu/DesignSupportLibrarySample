package com.wangjie.designsupportlibrarysample.example.tablayout;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Author: wangjie
 * Email: tiantian.china.2@gmail.com
 * Date: 6/8/15.
 */
public class PageItemView extends LinearLayout {
    private String title = PageItemView.class.getSimpleName();
    public PageItemView(Context context, int color, String title) {
        super(context);
        this.title = title;
        init(color);
    }

    public PageItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(Color.WHITE);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public PageItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(Color.WHITE);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public PageItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(Color.WHITE);
    }

    private void init(int color) {
        this.setBackgroundColor(color);
    }

    public String getTitle() {
        return title;
    }
}
