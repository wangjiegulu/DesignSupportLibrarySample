package com.wangjie.designsupportlibrarysample.example.util;

import android.content.res.ColorStateList;

/**
 * Author: wangjie
 * Email: tiantian.china.2@gmail.com
 * Date: 6/8/15.
 */
public class CommonUtil {

    /**
     * 对TextView设置不同状态时其文字颜色。
     */
    public static ColorStateList createColorStateList(int normal, int pressed, int focused, int checked, int unable) {
        int[] colors = new int[]{pressed, focused, checked, normal, unable};
        int[][] states = new int[5][];
        states[0] = new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled};
        states[1] = new int[]{android.R.attr.state_focused, android.R.attr.state_enabled};
        states[2] = new int[]{android.R.attr.state_checked, android.R.attr.state_enabled};
        states[3] = new int[]{android.R.attr.state_enabled};
        states[4] = new int[]{};
        return new ColorStateList(states, colors);
    }

}
