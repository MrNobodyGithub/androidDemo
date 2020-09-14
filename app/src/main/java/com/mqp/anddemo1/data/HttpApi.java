package com.mqp.anddemo1.data;

import com.mqp.anddemo1.bean.BaseBean;
import com.mqp.anddemo1.bean.ResultBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface HttpApi {



    @POST("/api/LXApi/GetBookCaseOfSchool")
    @FormUrlEncoded
    Observable<ResultBean> initDevice(@Field("stallId") String stallId);

//
    @POST("api/Applogin/sendCode")
    @FormUrlEncoded
    Observable<ResultBean> getVcode(@Field("mobile") String mobile);


    @POST("api/Applogin/userLoginAndRegister")
    @FormUrlEncoded
    Observable<ResultBean> urlLogin(@Field("mobile") String mobile,@Field("code") String code);





//
//    @GET("/api/LXApi/GetBookCaseOfSchool")
//    Observable initDevice(@Query("SchoolId") String schoolId);


//    @POST("/api/LXApi/GetBookCaseOfSchool")
//    @FormUrlEncoded
//    io.reactivex.Observable<ResultBean> initDevice(@Query("stallId") String stallId);


}
