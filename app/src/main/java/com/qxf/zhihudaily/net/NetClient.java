package com.qxf.zhihudaily.net;

import com.google.gson.Gson;
import com.qxf.zhihudaily.home.HomeApi;
import com.qxf.zhihudaily.splash.SplashApi;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author: qixuefeng on 2016/7/31 0031.
 * E-mail: 377289596@qq.com
 */
public class NetClient {

    public static final String URL_BASE = "http://news-at.zhihu.com/";

    private Gson gson;

    private OkHttpClient okHttpClient;

    private Retrofit retrofit;

    private static NetClient netClient;

    private NetClient() {

        okHttpClient = new OkHttpClient();

        gson = new Gson();

        retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

    }

    public static NetClient getInstance() {
        if (netClient == null) {
            netClient = new NetClient();
        }
        return netClient;
    }

    public SplashApi getSplashApi() {
        return retrofit.create(SplashApi.class);
    }

    public HomeApi getHomeApi() {
        return retrofit.create(HomeApi.class);
    }

}
