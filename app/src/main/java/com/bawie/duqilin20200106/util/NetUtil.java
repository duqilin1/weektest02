package com.bawie.duqilin20200106.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.bawie.duqilin20200106.Api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 *@auther:杜其林
 *@Date: 2020/1/6
 *@Time:9:12
 *@Description:${DESCRIPTION}
 * */
public class NetUtil {

    private final Api api;

    private NetUtil() {
        //设置okhttp日志拦截器
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //设置okhttp延迟时间
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();
        //
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://blog.zhaoliang5156.cn/baweiapi/")
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);
    }

    public static NetUtil getInstance() {
        return SinginHodler.netUtil;
    }

    private static final class SinginHodler{
        private static final NetUtil netUtil = new NetUtil();
    }

    public Api getApi() {
        return api;
    }
    //判断是否有网
    public boolean haxNet(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            return true;
        }else {
            return false;
        }
    }
}
