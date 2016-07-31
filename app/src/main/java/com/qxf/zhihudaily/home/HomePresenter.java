package com.qxf.zhihudaily.home;

import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;
import com.qxf.zhihudaily.net.NetClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Author: qixuefeng on 2016/7/31 0031.
 * E-mail: 377289596@qq.com
 */
public class HomePresenter extends MvpNullObjectBasePresenter<HomeView> {

    private Call<LatestNews> call;

    public void showUI() {

        getView().showProgress();

        HomeApi homeApi = NetClient.getInstance().getHomeApi();

        if (call!=null) call.cancel();

        call = homeApi.getLatestNews();

        call.enqueue(callback);

    }

    private Callback<LatestNews> callback = new Callback<LatestNews>() {
        @Override
        public void onResponse(Call<LatestNews> call, Response<LatestNews> response) {

            if (response != null && response.isSuccessful()) {

                LatestNews body = response.body();

                if (body == null) {
                    getView().showMessage("未知错误");
                    getView().hideProgress();
                    return;
                }

                getView().setDataToPagerAdapter(body.getTop_stories());
                getView().setDataToRecyclerAdapter(body.getStories());

                getView().hideProgress();

            }

        }

        @Override
        public void onFailure(Call<LatestNews> call, Throwable t) {
            getView().hideProgress();
            getView().showMessage(t.getMessage());
        }
    };

}
