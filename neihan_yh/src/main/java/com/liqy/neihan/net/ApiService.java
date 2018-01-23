package com.liqy.neihan.net;

import com.liqy.neihan.bean.Bean;
import com.liqy.neihan.bean.Mvpbean;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by 杨洪 on 2018/1/9.
 */

public interface ApiService {

    @GET("neihan/service/tabs")
    Flowable<Bean> get(@QueryMap Map<String,String> map);
//http://lf.snssdk.com/neihan/stream/mix/v1/?content_type=-101


    @GET("neihan/stream/mix/v1/")
    Flowable<Mvpbean> getdatas(@QueryMap Map<String,String> map);



}