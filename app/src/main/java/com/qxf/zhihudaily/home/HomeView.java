package com.qxf.zhihudaily.home;

import com.hannesdorfmann.mosby.mvp.MvpView;

import java.util.List;

/**
 * Author: qixuefeng on 2016/7/31 0031.
 * E-mail: 377289596@qq.com
 */
public interface HomeView extends MvpView{

    void showProgress();

    void hideProgress();

    void showMessage(String msg);

    void nevigationToNewsDetail(String url);

    void setDataToPagerAdapter(List<LatestNews.TopStoriesBean> top_stories);

    void setDataToRecyclerAdapter(List<LatestNews.StoriesBean> stories);

}
