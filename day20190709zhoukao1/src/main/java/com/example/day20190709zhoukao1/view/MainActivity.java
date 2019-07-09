package com.example.day20190709zhoukao1.view;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.example.day20190709zhoukao1.R;
import com.example.day20190709zhoukao1.model.bean.Bean;
import com.example.day20190709zhoukao1.model.http;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PullToRefreshListView list_pull;
    String path = "http://172.17.8.100/small/commodity/v1/findCommodityListByLabel?labelId=1003&page=1&count=1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        initView();
        initData();
        list_pull.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                AsyncTask<Void, Void, List<Bean.ResultBean>> asyncTask = new AsyncTask<Void, Void, List<Bean.ResultBean>>() {
                    private List<Bean.ResultBean> goods;

                    @Override
                    protected List<Bean.ResultBean> doInBackground(Void... voids) {
                        String s = http.getData(path);
                        Gson gson = new Gson();
                        Bean bean = gson.fromJson(s, Bean.class);
                        goods = bean.getResult();
                        return goods;
                    }


                    @Override
                    protected void onPostExecute(List<Bean.ResultBean> resultBeans) {
                        super.onPostExecute(resultBeans);

                    }
                }.execute();

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {

            }
        });
    }

    private void initData() {
    }

    private void initView() {
        list_pull = (PullToRefreshListView) findViewById(R.id.list_pull);

    }


}
