package com.wangjie.designsupportlibrarysample.example.snackbar;

import android.support.design.widget.Snackbar;
import android.view.View;
import com.wangjie.androidinject.annotation.annotations.base.AIClick;
import com.wangjie.androidinject.annotation.annotations.base.AILayout;
import com.wangjie.androidinject.annotation.present.AIActionBarActivity;
import com.wangjie.designsupportlibrarysample.example.R;

/**
 * Author: wangjie
 * Email: tiantian.china.2@gmail.com
 * Date: 6/8/15.
 */
@AILayout(R.layout.snack_bar_test)
public class SnackbarTestActivity extends AIActionBarActivity {

    @Override
    @AIClick({R.id.snack_bar_test_btn})
    public void onClickCallbackSample(View view) {
        switch (view.getId()) {
            case R.id.snack_bar_test_btn:
                Snackbar.make(view, "snackbar test", Snackbar.LENGTH_LONG)
                        .setAction("undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                showToastMessage("undo clicked");
                            }
                        })
//                        .setActionTextColor(Color.WHITE)
                        .show();
                break;
            default:
                break;
        }
    }
}
