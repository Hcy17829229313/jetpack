package com.example.tesy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tesy.R;
import com.example.tesy.ergbean.EgBannerBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

public class EgBannerAdapter extends RecyclerView.Adapter<EgBannerAdapter.ViewHolder> {
    Context baseContezt;
    List<EgBannerBean> egBannerBeans;

    public EgBannerAdapter(Context baseContezt, List<EgBannerBean> egBannerBeans) {
        this.baseContezt = baseContezt;
        this.egBannerBeans = egBannerBeans;
    }

    @NonNull
    @Override
    public EgBannerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(baseContezt).inflate(R.layout.banner_itm, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull EgBannerAdapter.ViewHolder holder, int position) {

        EgBannerBean egBannerBean = egBannerBeans.get(position);
        holder.banner.setImages(egBannerBeans).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                EgBannerBean egBannerBean1 = (EgBannerBean) path;
                Glide.with(baseContezt).load(egBannerBean1).into(imageView);
            }
        }).start();
    }

    @Override
    public int getItemCount() {
        return egBannerBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Banner banner;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.mBanner);
        }
    }
}
