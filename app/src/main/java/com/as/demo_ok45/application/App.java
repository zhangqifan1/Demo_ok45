package com.as.demo_ok45.application;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * -----------------------------
 * Created by zqf on 2019/9/20.
 * ---------------------------
 */
public class App extends Application {

    public static int currentPositon;
    public static List<String> dataList;


    @Override
    public void onCreate() {
        super.onCreate();

        dataList = new ArrayList<>();

    }
}
