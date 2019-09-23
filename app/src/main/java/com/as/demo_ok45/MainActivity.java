package com.as.demo_ok45;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import com.as.demo_ok45.adapter.SampleAdapter;
import com.as.demo_ok45.application.App;
import com.as.demo_ok45.fragment.FloatFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import me.yokeyword.fragmentation.SupportActivity;


public class MainActivity extends SupportActivity {

    private ArrayList<String> list;
    private FloatFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<String>() {{
            for (int i = 0; i < 30; i++) {
                add("  我是第  " + i + "  条  ");
            }
        }};

        fragment = findFragment(FloatFragment.class);


        RecyclerView rv_main = findViewById(R.id.rv_main);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        SampleAdapter sampleAdapter = new SampleAdapter(R.layout.item_text, list);

        rv_main.setLayoutManager(linearLayoutManager);
        rv_main.setAdapter(sampleAdapter);

        sampleAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (fragment == null) {
                    FloatFragment instance = FloatFragment.getInstance(list);
                    instance.setPostion(position);
                    loadRootFragment(R.id.root, instance);
                }
            }
        });
        startActivity(new Intent("android.settings.VIBRATE_ON"));
    }

}
