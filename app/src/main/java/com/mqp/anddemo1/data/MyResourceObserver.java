package com.mqp.anddemo1.data;

import com.mqp.anddemo1.bean.ResultBean;

import io.reactivex.observers.ResourceObserver;

public class MyResourceObserver extends ResourceObserver<ResultBean> {

    private  OnResultListener onResultListener;
    public MyResourceObserver(OnResultListener onResultListener){
        this.onResultListener = onResultListener;
    }




    @Override
    public void onNext(ResultBean resultBean) {

        if (resultBean.getError() == 0){
            onResultListener.success(resultBean);
        }else{
            onResultListener.fail(resultBean.getMessage());
        }

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        onResultListener.fail("服务器异常 稍后再试");
    }

    @Override
    public void onComplete() {

    }
}
