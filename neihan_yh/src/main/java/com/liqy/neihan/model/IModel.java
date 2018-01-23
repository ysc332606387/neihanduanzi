package com.liqy.neihan.model;

import java.util.Map;

/**
 * Created by 杨洪 on 2018/1/9.
 */

public interface IModel {
    void get(String baseurl,Map<String,String> map);

    void get2(String baseurl,Map<String,String> map);
}
