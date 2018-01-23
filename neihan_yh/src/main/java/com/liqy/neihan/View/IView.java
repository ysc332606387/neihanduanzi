package com.liqy.neihan.View;

/**
 * Created by 杨洪 on 2018/1/9.
 */

public interface IView {
    void onSuccess(Object o);
    void onFailed(Exception e);




    void onSuccessTab(Object o);
    void onFailedTab(Exception e);


}
