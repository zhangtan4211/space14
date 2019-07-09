package com.example.day20190708mvp.presenter;

import com.example.day20190708mvp.view.ImainView;

public class HomePresenter extends BasePresenter {



    private ImainView imainView;
    public void attach(ImainView view){
        this.imainView = view;
    }

    public void getData(){

        imainView.success("success");
    }
}
