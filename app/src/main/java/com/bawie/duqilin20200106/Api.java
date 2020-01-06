package com.bawie.duqilin20200106;

import com.bawie.duqilin20200106.model.bean.Bean;
import com.bawie.duqilin20200106.model.bean.ListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/*
 *@auther:杜其林
 *@Date: 2020/1/6
 *@Time:9:09
 *@Description:${DESCRIPTION}
 * */
public interface Api {

    @GET("category")
    Observable<Bean> beanObservable();

    @GET("shopByCategory")
    Observable<ListBean> listBeanObservable(@Query("category")String category);
}
