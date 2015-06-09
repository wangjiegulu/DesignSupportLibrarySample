package com.wangjie.designsupportlibrarysample.example.collapsingtoolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Author: wangjie
 * Email: tiantian.china.2@gmail.com
 * Date: 6/8/15.
 */
@AILayout(R.layout.collapsing_tool_bar_test)
public class CollapsingToolbarTestActivity extends AIActionBarActivity {
    @AIView(R.id.collapsing_tool_bar_test_rv)
    private RecyclerView recyclerView;
    private List<String> stringList = new ArrayList<>();
    @AIView(R.id.collapsing_tool_bar_test_tb)
    private Toolbar toolbar;
    @AIView(R.id.collapsing_tool_bar_test_ctl)
    private CollapsingToolbarLayout collapsingToolbarLayout;
    @AIView(R.id.collapsing_tool_bar_test_abl)
    private AppBarLayout appBarLayout;
    @AIView(R.id.collapsing_tool_bar_test_fab)
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 标题的文字需在setSupportActionBar之前，不然会无效
        setSupportActionBar(toolbar);

        collapsingToolbarLayout.setTitle("hello collapsing");
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
//        collapsingToolbarLayout.setContentScrimResource(R.mipmap.ic_launcher);

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
