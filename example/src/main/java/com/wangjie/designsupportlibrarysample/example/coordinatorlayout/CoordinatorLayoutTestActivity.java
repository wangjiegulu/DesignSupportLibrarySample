package com.wangjie.designsupportlibrarysample.example.coordinatorlayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.wangjie.androidbucket.support.recyclerview.adapter.ABRecyclerViewAdapter;
import com.wangjie.androidbucket.support.recyclerview.adapter.ABRecyclerViewHolder;
import com.wangjie.androidbucket.support.recyclerview.layoutmanager.ABaseLinearLayoutManager;
import com.wangjie.androidbucket.utils.ABTextUtil;
import com.wangjie.androidinject.annotation.annotations.base.AILayout;
import com.wangjie.androidinject.annotation.annotations.base.AIView;
import com.wangjie.androidinject.annotation.present.AIActionBarActivity;
import com.wangjie.designsupportlibrarysample.example.R;
import com.wangjie.designsupportlibrarysample.example.util.CommonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: wangjie
 * Email: tiantian.china.2@gmail.com
 * Date: 6/8/15.
 */
@AILayout(R.layout.coordinator_layout_test)
public class CoordinatorLayoutTestActivity extends AIActionBarActivity {
    @AIView(R.id.coordinator_layout_test_rv)
    private RecyclerView recyclerView;
    private List<String> stringList = new ArrayList<>();
    @AIView(R.id.coordinator_layout_test_tb)
    private Toolbar toolbar;
    @AIView(R.id.coordinator_layout_test_tl)
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 标题的文字需在setSupportActionBar之前，不然会无效
        toolbar.setTitle("hello");
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(0xff3F51B5);
        toolbar.setTitleTextColor(0xffffffff);
        tabLayout.setBackgroundColor(0xff3F51B5);

        tabLayout.setTabTextColors(CommonUtil.createColorStateList(0xffffffff, 0xaaffffff, 0xaaffffff, 0xffffffff, 0x33ffffff));
        tabLayout.addTab(tabLayout.newTab().setText("tab a"));
        tabLayout.addTab(tabLayout.newTab().setText("tab b"));
        tabLayout.addTab(tabLayout.newTab().setText("tab c"));

        for (int i = 0; i < 30; i++) {
            stringList.add("wangjie_" + i);
        }

        ABaseLinearLayoutManager layoutManager = new ABaseLinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new ABRecyclerViewAdapter() {
            private int id = View.generateViewId();

            @Override
            public ABRecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                TextView textView = new TextView(context);
                textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                int padding = ABTextUtil.dip2px(context, 16);
                textView.setPadding(padding, padding, padding, padding);
                textView.setId(id);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                return new ABRecyclerViewHolder(textView);
            }

            @Override
            public void onBindViewHolder(ABRecyclerViewHolder abRecyclerViewHolder, int i) {
                TextView tv = abRecyclerViewHolder.obtainView(id);
                tv.setText(stringList.get(i));
            }

            @Override
            public int getItemCount() {
                return stringList.size();
            }
        });

    }


}
