package com.liqy.neihan.presenter;

import android.util.Log;

import com.liqy.neihan.View.IView;
import com.liqy.neihan.model.Model;

import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by 杨洪 on 2018/1/9.
 */

public class Presenter implements BasePresenter{

    private IView iv;
    private DisposableSubscriber subscriber;
    private  DisposableSubscriber subscriber2;

    public Presenter(IView iv) {
        this.iv = iv;
    }

    @Override
    public void get(String baseurl,Map<String, String> map) {
        Model model = new Model(this);
        model.get(baseurl,map);
    }

    @Override
    public void getBaseurl(String baseurl, Map<String, String> map) {
        Model model = new Model(this);
        model.get2(baseurl,map);

    }

   /* @Override
    public void geturl(String baseurl, Map<String, String> map) {
        Model model = new Model(this);
        model.geturl2(baseurl,map);
    }*/


    public void getData(Flowable flowable){
        subscriber = (DisposableSubscriber) flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber() {
                    @Override
                    public void onNext(Object o) {
                        iv.onSuccess(o);
                    }

                    @Override
                    public void onError(Throwable t) {
                        iv.onFailed((Exception) t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }



    public void getDataUrl(Flowable flowable){
        subscriber = (DisposableSubscriber) flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber() {
                    @Override
                    public void onNext(Object o) {
                        iv.onSuccessTab(o);
                    }

                    @Override
                    public void onError(Throwable t) {
                        iv.onFailedTab((Exception) t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }




   /* public void getDataurl(Flowable flowable1){
                subscriber2 = (DisposableSubscriber) flowable1.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber() {
                    @Override
                    public void onNext(Object o) {
                        Log.i("aaasd",""+o);
                        iv.onSuccesstab(o);
                    }

                    @Override
                    public void onError(Throwable t) {
                        iv.onFailedtab((Exception) t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }*/











    //防止内存泄漏
    public void detatch(){
        if (iv != null) {
            iv = null;
        }
        if(subscriber!=null){
            if(!subscriber.isDisposed()){
                subscriber.dispose();
            }
        }
    }

}
