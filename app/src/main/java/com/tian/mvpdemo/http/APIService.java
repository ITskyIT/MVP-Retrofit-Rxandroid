package com.tian.mvpdemo.http;

import com.tian.mvpdemo.bean.FuLiGirl;

import retrofit2.http.GET;
import rx.Observable;

/**
 * 接口
 */
public interface APIService {
    String BaseUrl = "http://gank.io/api/data/";
    @GET("福利/10/1")
    Observable<FuLiGirl> getFuliGirl();

}
