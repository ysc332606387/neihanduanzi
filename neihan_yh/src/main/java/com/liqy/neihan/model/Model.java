package com.liqy.neihan.model;

import com.liqy.neihan.bean.Bean;

import com.liqy.neihan.bean.Mvpbean;
import com.liqy.neihan.net.ApiService;
import com.liqy.neihan.net.RetrofitUtils;
import com.liqy.neihan.presenter.Presenter;

import java.util.Map;

import io.reactivex.Flowable;

/**
 * Created by 杨洪 on 2018/1/9.
 */

public class Model implements IModel{

    private Presenter presenter;

    public Model(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void get(String baseurl, Map<String, String> map) {
        Flowable<Bean> flowable = RetrofitUtils.getInstance(baseurl).getretrofit().create(ApiService.class).get(map);
        presenter.getData(flowable);
    }

    @Override
    public void get2(String baseurl, Map<String, String> map) {
        Flowable<Mvpbean> flowable = RetrofitUtils.getInstance(baseurl).getretrofit().create(ApiService.class).getdatas(map);
        presenter.getDataUrl(flowable);

    }






}
