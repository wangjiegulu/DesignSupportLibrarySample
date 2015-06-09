package com.wangjie.designsupportlibrarysample.example.textinputlayout;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import com.wangjie.androidinject.annotation.annotations.base.AILayout;
import com.wangjie.androidinject.annotation.annotations.base.AIView;
import com.wangjie.androidinject.annotation.present.AIActionBarActivity;
import com.wangjie.designsupportlibrarysample.example.R;

/**
 * Author: wangjie
 * Email: tiantian.china.2@gmail.com
 * Date: 6/3/15.
 */
@AILayout(R.layout.text_input_layout_test)
public class TextInputLayoutTestActivity extends AIActionBarActivity{
    @AIView(R.id.text_input_layout_test_til)
    private TextInputLayout textInputLayout;
    @AIView(R.id.text_input_layout_test_b_til)
    private TextInputLayout textInputLayoutB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textInputLayout.setHint("hello hint");
        textInputLayoutB.setHint("hello hint 2");


    }
}
