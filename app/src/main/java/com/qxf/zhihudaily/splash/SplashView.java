package com.qxf.zhihudaily.splash;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Author: qixuefeng on 2016/7/31 0031.
 * E-mail: 377289596@qq.com
 */
public interface SplashView extends MvpView {

    void showProgress();

    void hideProgress();

    void showSplash(String url,String version);

    void showMessage(String msg);

}
