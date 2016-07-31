package com.qxf.zhihudaily.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.qxf.zhihudaily.R;
import com.qxf.zhihudaily.home.LatestNews;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Author: qixuefeng on 2016/7/31 0031.
 * E-mail: 377289596@qq.com
 */
public class NewsTopView extends RelativeLayout {

    @Bind(R.id.topImg)
    ImageView topImg;
    @Bind(R.id.tv_title)
    TextView tvTitle;

    public NewsTopView(Context context) {
        super(context);
        init();
    }

    public NewsTopView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NewsTopView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public NewsTopView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.news_top, this, true);
        ButterKnife.bind(this);
    }

    public void bind(LatestNews.TopStoriesBean bean) {
        ImageLoader.getInstance().displayImage(bean.getImage(), topImg);
        tvTitle.setText(bean.getTitle());
    }


}
