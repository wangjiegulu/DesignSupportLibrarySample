package com.wangjie.designsupportlibrarysample.example.navigationview;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import com.wangjie.androidinject.annotation.annotations.base.AILayout;
import com.wangjie.androidinject.annotation.annotations.base.AIView;
import com.wangjie.androidinject.annotation.present.AIActionBarActivity;
import com.wangjie.designsupportlibrarysample.example.R;
import com.wangjie.designsupportlibrarysample.example.util.CommonUtil;

/**
 * Author: wangjie
 * Email: tiantian.china.2@gmail.com
 * Date: 6/3/15.
 */
@AILayout(R.layout.navigation_view_test)
public class NavigationViewTestActivity extends AIActionBarActivity implements NavigationView.OnNavigationItemSelectedListener {
    @AIView(R.id.navigation_view_drawer_view)
    private DrawerLayout drawerLayout;
    @AIView(R.id.navigation_view_test_nv)
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navigationView.setItemIconTintList(CommonUtil.createColorStateList(0xff000000, 0xaa000000, 0xffaa0000, 0xffaa0000, 0xffcccccc));
        navigationView.setItemTextColor(CommonUtil.createColorStateList(0xffcccccc, 0xffaabbcc, 0xffaabbcc, 0xffaabbcc, 0xff999999));
        navigationView.setNavigationItemSelectedListener(this);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED, Gravity.RIGHT);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        menuItem.setChecked(true);
        showToastMessage(menuItem.getTitle().toString());
        return false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(KeyEvent.ACTION_DOWN == event.getAction()){
            if(drawerLayout.isDrawerOpen(navigationView)){
                drawerLayout.closeDrawer(navigationView);
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
