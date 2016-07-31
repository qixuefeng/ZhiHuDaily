package com.qxf.zhihudaily.splash;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.nineoldandroids.animation.Animator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.qxf.zhihudaily.home.HomeActivity;
import com.qxf.zhihudaily.R;
import com.qxf.zhihudaily.common.ActivityUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SplashActivity extends MvpActivity<SplashView, SplashPresenter> implements SplashView {

    @Bind(R.id.splash_img)
    ImageView splashImg;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_version)
    TextView tvVersion;

    private ActivityUtils activityUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityUtils = new ActivityUtils(this);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        getPresenter().showSplashImg();

    }

    @NonNull
    @Override
    public SplashPresenter createPresenter() {
        return new SplashPresenter();
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
    public void showSplash(String url, String version) {
        ImageLoader.getInstance().displayImage(url, splashImg);
        tvVersion.setText(version);
        YoYo.with(Techniques.FadeIn).withListener(listener).duration(3000).playOn(splashImg);
        YoYo.with(Techniques.FadeIn).duration(3000).playOn(tvTitle);
        YoYo.with(Techniques.FadeIn).duration(3000).playOn(tvVersion)
        ;
    }

    private Animator.AnimatorListener listener = new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {

        }

        @Override
        public void onAnimationEnd(Animator animation) {
            activityUtils.startActivity(HomeActivity.class);
            finish();
        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }
    };

    @Override
    public void showMessage(String msg) {
        activityUtils.showToast(msg);
    }
}
