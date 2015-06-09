package com.wangjie.designsupportlibrarysample.example;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.wangjie.androidinject.annotation.annotations.base.AIClick;
import com.wangjie.androidinject.annotation.annotations.base.AILayout;
import com.wangjie.androidinject.annotation.present.AIActionBarActivity;
import com.wangjie.designsupportlibrarysample.example.collapsingtoolbar.CollapsingToolbarTestActivity;
import com.wangjie.designsupportlibrarysample.example.coordinatorlayout.CoordinatorLayoutTestActivity;
import com.wangjie.designsupportlibrarysample.example.navigationview.NavigationViewTestActivity;
import com.wangjie.designsupportlibrarysample.example.snackbar.SnackbarTestActivity;
import com.wangjie.designsupportlibrarysample.example.tablayout.TabLayoutTestActivity;
import com.wangjie.designsupportlibrarysample.example.textinputlayout.TextInputLayoutTestActivity;

@AILayout(R.layout.activity_main)
public class MainActivity extends AIActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    @AIClick({R.id.activity_main_navigation_view_test_btn, R.id.activity_main_text_input_layout_test_btn, R.id.activity_main_snack_bar_test_btn,
                R.id.activity_main_tab_layout_test_btn, R.id.activity_main_coordinator_layout_test_btn, R.id.activity_main_collapsing_tool_bar_test_btn})
    public void onClickCallbackSample(View view) {
        switch (view.getId()) {
            case R.id.activity_main_navigation_view_test_btn:
                startActivity(new Intent(context, NavigationViewTestActivity.class));
                break;
            case R.id.activity_main_text_input_layout_test_btn:
                startActivity(new Intent(context, TextInputLayoutTestActivity.class));
                break;
            case R.id.activity_main_snack_bar_test_btn:
                startActivity(new Intent(context, SnackbarTestActivity.class));
                break;
            case R.id.activity_main_tab_layout_test_btn:
                startActivity(new Intent(context, TabLayoutTestActivity.class));
                break;
            case R.id.activity_main_coordinator_layout_test_btn:
                startActivity(new Intent(context, CoordinatorLayoutTestActivity.class));
                break;
            case R.id.activity_main_collapsing_tool_bar_test_btn:
                startActivity(new Intent(context, CollapsingToolbarTestActivity.class));
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
