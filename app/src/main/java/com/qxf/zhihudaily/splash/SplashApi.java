package com.qxf.zhihudaily.splash;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Author: qixuefeng on 2016/7/31 0031.
 * E-mail: 377289596@qq.com
 */
public interface SplashApi {

    @GET("api/4/start-image/1080*1776")
    Call<SplashResult> getSplashImg();


}
