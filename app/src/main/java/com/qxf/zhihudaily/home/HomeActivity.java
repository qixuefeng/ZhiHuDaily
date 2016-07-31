package com.qxf.zhihudaily.home;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.qxf.zhihudaily.R;
import com.qxf.zhihudaily.common.ActivityUtils;
import com.qxf.zhihudaily.view.NewsTopView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

public class HomeActivity extends MvpActivity<HomeView, HomePresenter> implements HomeView {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.viewpager)
    ViewPager viewpager;
    @Bind(R.id.indicator)
    CircleIndicator indicator;

    private ActivityUtils activityUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityUtils = new ActivityUtils(this);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        getPresenter().showUI();

    }

    @NonNull
    @Override
    public HomePresenter createPresenter() {
        return new HomePresenter();
    }

    private ProgressDialog progressDialog;

    @Override
    public void showProgress() {
        progressDialog = ProgressDialog.show(this, "", "加载中...");
    }

    @Override
    public void hideProgress() {
        if (progressDialog != null) {
            progressDialog.cancel();
        }
    }

    @Override
    public void showMessage(String msg) {
        activityUtils.showToast(msg);
    }

    @Override
    public void nevigationToNewsDetail(String url) {

    }

    @Override
    public void setDataToPagerAdapter(List<LatestNews.TopStoriesBean> top_stories) {

        ArrayList<NewsTopView> datas = new ArrayList<>();

        for (int i = 0; i < top_stories.size(); i++) {
            NewsTopView newsTopView = new NewsTopView(this);
            newsTopView.bind(top_stories.get(i));
            datas.add(newsTopView);
        }

        TopNewsPagerAdapter adapter = new TopNewsPagerAdapter(datas);

        viewpager.setAdapter(adapter);

        indicator.setViewPager(viewpager);

    }

    @Override
    public void setDataToRecyclerAdapter(List<LatestNews.StoriesBean> stories) {

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        NewListAdapter adapter = new NewListAdapter(this);
        adapter.setDatas(stories);
        recyclerView.setAdapter(adapter);
    }
}
