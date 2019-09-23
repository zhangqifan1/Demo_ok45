package com.as.demo_ok45.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.as.demo_ok45.layoutmanager.CoverFlowLayoutManger;
import com.as.demo_ok45.R;
import com.as.demo_ok45.TopSmoothScroller;
import com.as.demo_ok45.adapter.SampleAdapter;
import com.as.demo_ok45.layoutmanager.RecyclerCoverFlow;
import com.azoft.carousellayoutmanager.CarouselLayoutManager;
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.azoft.carousellayoutmanager.CenterScrollListener;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;

import me.yokeyword.fragmentation.SupportFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class FloatFragment extends SupportFragment {


    private int curPosition;

    public static FloatFragment getInstance(ArrayList<String> list) {
        FloatFragment floatFragment = new FloatFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("data", list);
        floatFragment.setArguments(bundle);
        return floatFragment;
    }

    public void setPostion(int postion) {
        curPosition = postion;
    }

    /*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_float, container, false);

        final RecyclerView rv_frag = view.findViewById(R.id.rv_frag);
        ArrayList<String> data = getArguments().getStringArrayList("data");

        final CarouselLayoutManager layoutManager = new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL);

        SampleAdapter sampleAdapter = new SampleAdapter(R.layout.item_text_large, data);

        rv_frag.setLayoutManager(layoutManager);
        rv_frag.setAdapter(sampleAdapter);

        rv_frag.setHasFixedSize(true);

        layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());

        rv_frag.scrollToPosition(curPosition);


        final RecyclerView btm_rv = view.findViewById(R.id.btm_rv);
        SampleAdapter sampleAdapter1 = new SampleAdapter(R.layout.item_text_btm, data);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        btm_rv.setAdapter(sampleAdapter1);
        btm_rv.setLayoutManager(linearLayoutManager);

        btm_rv.smoothScrollToPosition(curPosition);
        btm_rv.addOnScrollListener(new CenterScrollListener());


//        sampleAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                btm_rv.smoothScrollToPosition(position);
////                pop();
//            }
//        });

        sampleAdapter1.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                rv_frag.smoothScrollToPosition(position);
            }
        });

        layoutManager.addOnItemSelectionListener(new CarouselLayoutManager.OnCenterItemSelectionListener() {
            @Override
            public void onCenterItemChanged(int adapterPosition) {
                if (adapterPosition > 0) {
                    final TopSmoothScroller mScroller = new TopSmoothScroller(getActivity());
                    mScroller.setTargetPosition(adapterPosition - 1);
                    linearLayoutManager.startSmoothScroll(mScroller);
                }

//                btm_rv.smoothScrollToPosition(adapterPosition);
            }
        });


        return view;

    }*/


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_float, container, false);

        final RecyclerCoverFlow rv_frag = view.findViewById(R.id.rv_frag);
        ArrayList<String> data = getArguments().getStringArrayList("data");


        SampleAdapter sampleAdapter = new SampleAdapter(R.layout.item_text_large, data);

        rv_frag.setAdapter(sampleAdapter);

        rv_frag.setHasFixedSize(true);

        rv_frag.scrollToPosition(curPosition);


        final RecyclerView btm_rv = view.findViewById(R.id.btm_rv);
        SampleAdapter sampleAdapter1 = new SampleAdapter(R.layout.item_text_btm, data);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        btm_rv.setAdapter(sampleAdapter1);
        btm_rv.setLayoutManager(linearLayoutManager);

        btm_rv.smoothScrollToPosition(curPosition);
        btm_rv.addOnScrollListener(new CenterScrollListener());



        sampleAdapter1.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                rv_frag.smoothScrollToPosition(position);
            }
        });

        CoverFlowLayoutManger layoutManager = (CoverFlowLayoutManger) rv_frag.getLayoutManager();
        layoutManager.setOnSelectedListener(new CoverFlowLayoutManger.OnSelected() {
            @Override
            public void onItemSelected(int position) {
                if (position > 0) {

                    final TopSmoothScroller mScroller = new TopSmoothScroller(getActivity());

                    mScroller.setTargetPosition(position - 1);
                    linearLayoutManager.startSmoothScroll(mScroller);

                }
            }
        });

        return view;
    }

}
