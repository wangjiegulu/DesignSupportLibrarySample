package com.wangjie.designsupportlibrarysample.example.tablayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import com.wangjie.androidinject.annotation.annotations.base.AILayout;
import com.wangjie.androidinject.annotation.annotations.base.AIView;
import com.wangjie.androidinject.annotation.present.AIActionBarActivity;
import com.wangjie.designsupportlibrarysample.example.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: wangjie
 * Email: tiantian.china.2@gmail.com
 * Date: 6/8/15.
 */
@AILayout(R.layout.tab_layout_test)
public class TabLayoutTestActivity extends AIActionBarActivity {
    @AIView(R.id.tab_layout_test_tl)
    private TabLayout tabLayout;
    @AIView(R.id.tab_layout_test_vp)
    private ViewPager viewPager;

    private List<PageItemView> pages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tabLayout.addTab(tabLayout.newTab()/*.setText("tab a")*/);
        tabLayout.addTab(tabLayout.newTab()/*.setText("tab b")*/);
        tabLayout.addTab(tabLayout.newTab()/*.setText("tab c")*/);

        pages.add(new PageItemView(context, Color.GRAY, "tab a"));
        pages.add(new PageItemView(context, Color.GREEN, "tab b"));
        pages.add(new PageItemView(context, Color.BLUE, "tab c"));

        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return pages.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View itemView = pages.get(position);
                container.addView(itemView);
                return itemView;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return pages.get(position).getTitle();
            }
        });
        tabLayout.setupWithViewPager(viewPager);
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            private int mScrollState;
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                tabLayout.setScrollPosition(position, positionOffset, mScrollState == ViewPager.SCROLL_STATE_DRAGGING);
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                tabLayout.getTabAt(position).select();
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//                mScrollState = state;
//            }
//        });

    }



}
