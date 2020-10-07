package com.example.tesy.babyAdapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.tesy.R;
import com.example.tesy.egBabyBean.BabyItem2Bean;
import com.example.tesy.egBabyBean.BabyItemBean;

import java.util.ArrayList;
import java.util.List;

public class BabyItem2Adapter extends RecyclerView.Adapter<BabyItem2Adapter.ViewHolder> {
    Context baseContext;
    List<BabyItem2Bean> babyItem2Beans;

    public BabyItem2Adapter(Context baseContext, List<BabyItem2Bean> babyItem2Beans) {
        this.baseContext = baseContext;
        this.babyItem2Beans = babyItem2Beans;
    }

    @NonNull
    @Override
    public BabyItem2Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(baseContext).inflate(R.layout.baby_gli2_item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull BabyItem2Adapter.ViewHolder holder, int position) {
        BabyItem2Bean babyItem2Bean = babyItem2Beans.get(position);

        holder.ba_item2_title.setText(babyItem2Bean.getName());
        RoundedCorners roundedCorners = new RoundedCorners(10);

        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners);

        holder.gli_title.setText(babyItem2Bean.getPlaylists().get(0).getName());
        holder.count.setText(babyItem2Bean.getPlaylists().get(0).getCount() + "");
        Glide.with(baseContext).load(babyItem2Bean.getPlaylists().get(0).getImage()).apply(options).into(holder.gli_img);

        holder.gli_title2.setText(babyItem2Bean.getPlaylists().get(1).getName());
        holder.count2.setText(babyItem2Bean.getPlaylists().get(1).getCount() + "");
        Glide.with(baseContext).load(babyItem2Bean.getPlaylists().get(1).getImage()).apply(options).into(holder.gli_img2);

        holder.gli_title3.setText(babyItem2Bean.getPlaylists().get(2).getName());
        holder.count3.setText(babyItem2Bean.getPlaylists().get(2).getCount() + "");
        Glide.with(baseContext).load(babyItem2Bean.getPlaylists().get(2).getImage()).apply(options).into(holder.gli_img3);

        Glide.with(baseContext).load(babyItem2Bean.getImage()).apply(options).into(holder.ba_item2_img);
    }

    @Override
    public int getItemCount() {
        return babyItem2Beans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView gli_img, gli_img2, gli_img3, ba_item2_img;
        TextView gli_title, gli_title2, gli_title3, ba_item2_title;
        TextView count, count2, count3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gli_img = itemView.findViewById(R.id.gli_img);
            gli_title = itemView.findViewById(R.id.gli_title);
            count = itemView.findViewById(R.id.count);

            gli_img2 = itemView.findViewById(R.id.gli_img2);
            gli_title2 = itemView.findViewById(R.id.gli_title2);
            count2 = itemView.findViewById(R.id.count2);

            gli_img3 = itemView.findViewById(R.id.gli_img3);
            gli_title3 = itemView.findViewById(R.id.gli_title3);
            count3 = itemView.findViewById(R.id.count3);


            ba_item2_img = itemView.findViewById(R.id.ba_item2_img);
            ba_item2_title = itemView.findViewById(R.id.ba_item2_title);
        }
    }
}
