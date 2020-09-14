package com.mqp.anddemo1.data;

import android.util.Log;

import com.mqp.anddemo1.utils.CommonTool;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import static java.sql.DriverManager.println;

public class RequestInterceptor implements Interceptor {

    /**
     * 1 调用拦截器方法 intercept
     */
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();

        //添加公共请求头
        Request compressedRequest;
        compressedRequest = originalRequest.newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .build();
        Response response = chain.proceed(compressedRequest);

//        println("---------------------url-----------------------");
//        Log.v("tag d","--------------------url----------------------");
//        Log.v("tag d", "url: " + compressedRequest.url().url().toString() );
//        Log.v("tag d", "header: " + compressedRequest.headers().toString() );

        CommonTool.Companion.print("url: " + compressedRequest.url().url());
        CommonTool.Companion.print("header: " + compressedRequest.headers());


        // 获取参数
        try {
            okio.Buffer buffer = new okio.Buffer();
            compressedRequest.body().writeTo(buffer);
            String bodyStr = buffer.readString(Charset.forName("UTF-8"));
            println("body: " + bodyStr);
//            Log.v("tag d", "body: " + bodyStr);
            CommonTool.Companion.print("body: " + bodyStr);


        } catch (Exception e) {

//            Log.v("tag d", "----------------error from interceptor---------------");
//            Log.v("tag d", e.getMessage());
            CommonTool.Companion.print("error request interceptor :" + e.getMessage());
//            println("----------------------error from interceptor----------------------");
//            println(e.getMessage());
        }


        String result = new String(response.body().bytes());
        if (result.startsWith("{")) {
            try {
                JSONObject object = new JSONObject(result);
                if (object.getInt("code") != 200) {
                    object.put("data", null);
                }
            } catch (Exception e) {
            }

            Log.v("tag d", "----------------------res json ----------------------");
//            Log.v("tag d", result);
//            println("----------------------res json ----------------------");
//            println(result);
            CommonTool.Companion.print("------------------------------------------------------返回数据json------------------------------------------------------");
            CommonTool.Companion.printJson(result);
        } else {
            Log.v("tag d", "----------------------res obj ----------------------");
//            Log.v("tag d", result);
//            println("----------------------res obj----------------------");
//            println(result);
            CommonTool.Companion.print("------------------------------------------------------返回数据else------------------------------------------------------");
            CommonTool.Companion.print(result);
        }
        return response.newBuilder().body(ResponseBody.create(response.body().contentType(), result.getBytes())).build();
    }
}
