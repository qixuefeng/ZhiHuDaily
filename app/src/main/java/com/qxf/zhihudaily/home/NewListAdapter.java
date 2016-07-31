package com.qxf.zhihudaily.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.qxf.zhihudaily.R;

import java.util.List;

/**
 * Author: qixuefeng on 2016/7/31 0031.
 * E-mail: 377289596@qq.com
 */
public class NewListAdapter extends RecyclerView.Adapter<NewListAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<LatestNews.StoriesBean> datas;

    public NewListAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(List<LatestNews.StoriesBean> datas) {
        this.datas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.news_list_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_title.setText(datas.get(position).getTitle());
        ImageLoader.getInstance().displayImage(datas.get(position).getImages().get(0), holder.img);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            img = (ImageView) itemView.findViewById(R.id.img);
        }
    }

}
