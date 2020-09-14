package com.mqp.anddemo1.data;

import com.mqp.anddemo1.bean.BaseBean;

import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.ResourceObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpUtils  {


    public  static  final  String BASE_URL =  "https://redreadapi.citymedia.cn/";
    private  static  HttpUtils httpUtils;
    private Retrofit retrofit;
    private  HttpApi httpApi;

    private  HttpUtils(){
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.connectTimeout(30, TimeUnit.SECONDS);
        client.addInterceptor(new RequestInterceptor());
        /**
         *  requestInterceptor
         *  由于retrofit底层的实现是通过okhttp实现的 所以可以通过okhttp来设置一下链接参数
         *  eg 超时
         * */
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        httpApi = retrofit.create(HttpApi.class);

    }
    /**
     * init
     * */
    public  synchronized  static  HttpUtils getInstance(){
        if (httpUtils == null){
            httpUtils = new HttpUtils();
        }
        return  httpUtils;
    }

    /**
     * 2 登录 使用验证码
     * */

    public ResourceObserver reqLogin(OnResultListener listener,String value,String code){

        return httpApi.urlLogin(value,code).unsubscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new MyResourceObserver(listener));
    }
    /**
     * 1 获取验证码
     * */

    public ResourceObserver getVcode(OnResultListener listener,String value){

        return httpApi.getVcode(value).unsubscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new MyResourceObserver(listener));
    }


    /**
     * 1 api 1
     * */

    public ResourceObserver firstApi(OnResultListener listener,String staid){
        return httpApi.initDevice(staid).unsubscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new MyResourceObserver(listener));
    }






}
