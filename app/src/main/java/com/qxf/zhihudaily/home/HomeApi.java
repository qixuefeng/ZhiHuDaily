package com.qxf.zhihudaily.home;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Author: qixuefeng on 2016/7/31 0031.
 * E-mail: 377289596@qq.com
 */
public interface HomeApi {

    @GET("http://news-at.zhihu.com/api/4/news/latest")
    Call<LatestNews> getLatestNews();

}
