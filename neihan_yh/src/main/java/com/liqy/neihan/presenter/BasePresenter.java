package com.liqy.neihan.presenter;

import java.util.Map;

/**
 * Created by 杨洪 on 2018/1/9.
 */

public interface BasePresenter {
    void get(String baseurl,Map<String,String> map);
    void getBaseurl(String baseurl,Map<String,String> map);
}
