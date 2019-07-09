package com.example.day20190708mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.day20190708mvp.R;
import com.example.day20190708mvp.presenter.BasePresenter;
import com.example.day20190708mvp.presenter.HomePresenter;

public class MainActivity extends  AppCompatActivity implements ImainView {

    private HomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();

    }

    private void initData() {
        homePresenter = new HomePresenter();
        homePresenter.attach(this);
        homePresenter.getData();
    }

    private void initView() {
    }


    @Override
    public void success(String data) {
        Log.e("MyMessage",""+data);
    }

    @Override
    public void error() {

    }
}
