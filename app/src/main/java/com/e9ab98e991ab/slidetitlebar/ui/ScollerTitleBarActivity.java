package com.e9ab98e991ab.slidetitlebar.ui;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;

import com.e9ab98e991ab.slidetitlebar.R;
import com.e9ab98e991ab.slidetitlebar.databinding.ScollerTitleBarBinding;
import com.e9ab98e991ab.slidetitlebar.moduler.scoller.RecycleViewDivider;
import com.e9ab98e991ab.slidetitlebar.moduler.scoller.StatusBarUtil;
import com.e9ab98e991ab.slidetitlebar.ui.adapter.BindingAdapter;
import com.e9ab98e991ab.slidetitlebar.ui.adapter.BindingAdapterItem;
import com.e9ab98e991ab.slidetitlebar.ui.item.RecycleItem;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ScollerTitleBarActivity extends AppCompatActivity {


    private ScollerTitleBarBinding stbb;
    private int height;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stbb = DataBindingUtil.setContentView(this,R.layout.scoller_title_bar);
        StatusBarUtil.darkMode(this);
        initListView();
        initOnClick();
        initListeners();
    }

    private void initListView() {
        stbb.ivBanner.setFocusable(true);
        stbb.ivBanner.setFocusableInTouchMode(true);
        stbb.ivBanner.requestFocus();

        stbb.rvContent.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.data)));
    }
    private void initOnClick() {
        stbb.images.setOnClickListener(v -> {
            finish();
        });
        stbb.linear.setPadding(0,StatusBarUtil.getStatusBarHeight(this),0,0);

    }
    /**
     * 获取顶部图片高度后，设置滚动监听
     */
    private void initListeners() {

        ViewTreeObserver vto = stbb.ivBanner.getViewTreeObserver();

        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

                stbb.linear.getViewTreeObserver().removeGlobalOnLayoutListener(
                        this);
                height = stbb.ivBanner.getHeight();

                stbb.scrollview.setScrollViewListener((scrollView, x, y, oldx, oldy) -> {
                    //设置标题的背景颜色
                    if (y <= 0) {
                        stbb.linear.setBackgroundColor(Color.argb((int) 0, 144,151,166));

                    }
                    //滑动距离小于banner图的高度时，设置背景和字体颜色颜色透明度渐变
                    else if (y <= height) {
                        float scale = (float) y / height;
                        float alpha = (255 * scale);
                        stbb.images.setColorFilter(Color.argb((int) alpha, 255,255,255));
                        stbb.textview.setTextColor(Color.argb((int) alpha, 255,255,255));
                        stbb.linear.setBackgroundColor(Color.argb((int) alpha, 144,151,166));

                    }
                    //滑动到banner下面设置普通颜色
                    else {
                        stbb.linear.setBackgroundColor(Color.argb((int) 255, 144,151,166));
                    }
                });
            }
        });
    }
}
