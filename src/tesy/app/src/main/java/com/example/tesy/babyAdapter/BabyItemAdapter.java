package com.example.tesy.babyAdapter;

import android.content.Context;
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
import com.example.tesy.egBabyBean.BabyItemBean;
import com.example.tesy.ergbean.EgGliBean;

import java.util.List;

public class BabyItemAdapter extends RecyclerView.Adapter<BabyItemAdapter.ViewHolder> {
    Context baseContext;
    List<BabyItemBean> babyItemBeans;

    public BabyItemAdapter(Context baseContext, List<BabyItemBean> babyItemBeans) {
        this.baseContext = baseContext;
        this.babyItemBeans = babyItemBeans;
    }

    @NonNull
    @Override
    public BabyItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(baseContext).inflate(R.layout.baby_gli_item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull BabyItemAdapter.ViewHolder holder, int position) {

        BabyItemBean babyItemBean = babyItemBeans.get(position);
        holder.gli_title.setText(babyItemBean.getName());
        holder.count.setText(babyItemBean.getCount() + "");
        RoundedCorners roundedCorners = new RoundedCorners(10);

        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners);

        Glide.with(baseContext).load(babyItemBean.getImage()).apply(options).into(holder.gli_img);
    }

    @Override
    public int getItemCount() {
        return babyItemBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView gli_img;
        TextView gli_title;
        TextView count;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gli_img = itemView.findViewById(R.id.gli_img);
            gli_title = itemView.findViewById(R.id.gli_title);
            count = itemView.findViewById(R.id.count);
        }
    }
}
