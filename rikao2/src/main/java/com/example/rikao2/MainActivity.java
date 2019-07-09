package com.example.rikao2;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.rikao2.fragment.fragment1;
import com.example.rikao2.fragment.fragment2;
import com.example.rikao2.fragment.fragment3;
import com.example.rikao2.fragment.fragment4;
import com.example.rikao2.fragment.fragment5;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private RadioGroup rg;
    private List<Fragment> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        initView();
        //加载试图
        initData();

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                      case R.id.rb1:
                          vp.setCurrentItem(0);
                       break;
                      case R.id.rb2:
                          vp.setCurrentItem(0);
                      case R.id.rb3:
                          vp.setCurrentItem(0);
                      case R.id.rb4:
                          vp.setCurrentItem(0);
                      case R.id.rb5:
                          vp.setCurrentItem(0);
                      default:

                }
            }
        });

    }

    private void initData() {
        list.add(new fragment1());
        list.add(new fragment2());
        list.add(new fragment3());
        list.add(new fragment4());
        list.add(new fragment5());

    }

    private void initView() {
        vp = findViewById(R.id.vp);
        rg = findViewById(R.id.rg);
    }
}
