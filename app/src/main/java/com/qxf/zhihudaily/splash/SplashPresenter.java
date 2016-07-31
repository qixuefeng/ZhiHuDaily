package com.qxf.zhihudaily.splash;

import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;
import com.qxf.zhihudaily.net.NetClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Author: qixuefeng on 2016/7/31 0031.
 * E-mail: 377289596@qq.com
 */
public class SplashPresenter extends MvpNullObjectBasePresenter<SplashView> {

    private Call<SplashResult> call;

    private static final String TAG = "SplashPresenter";

    public void showSplashImg() {

        getView().showProgress();

        SplashApi splashApi = NetClient.getInstance().getSplashApi();

        if (call != null) {
            call.cancel();
        }

        call = splashApi.getSplashImg();

        call.enqueue(callback);

    }

    private Callback<SplashResult> callback = new Callback<SplashResult>() {
        @Override
        public void onResponse(Call<SplashResult> call, Response<SplashResult> response) {

            if (response != null && response.isSuccessful()) {
                SplashResult body = response.body();

                if (body == null) {
                    getView().showMessage("获取图片失败");
                    getView().hideProgress();
                    return;
                }
                getView().showSplash(body.getImg(), body.getText());
            }
            getView().hideProgress();
        }

        @Override
        public void onFailure(Call<SplashResult> call, Throwable t) {
            getView().showMessage("网络连接错误");
            getView().hideProgress();
        }
    };

}
