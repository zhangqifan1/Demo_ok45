package com.as.demo_ok45.adapter;

import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.as.demo_ok45.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * -----------------------------
 * Created by zqf on 2019/9/20.
 * ---------------------------
 */
public class SampleAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    private int[] colors=new int[]{Color.BLACK,Color.GRAY,Color.YELLOW,Color.GREEN,Color.BLUE};
    public SampleAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_item, item);
        helper.getView(R.id.tv_item).setBackgroundColor(colors[helper.getAdapterPosition()%colors.length]);

    }
}
