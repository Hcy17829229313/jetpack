package com.hcy.jetpack.MyApp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hcy.jetpack.MyApp.bean.SeekBean;
import com.hcy.jetpack.R;

import java.util.ArrayList;
import java.util.List;

public class SeekSubAdapter extends RecyclerView.Adapter<SeekSubAdapter.ViewHolder> {
    Context baseContext;
    List<SeekBean.DataBean> dataBeans;

    public SeekSubAdapter(Context baseContext, List<SeekBean.DataBean> dataBeans) {
        this.baseContext = baseContext;
        this.dataBeans = dataBeans;
    }

    @NonNull
    @Override
    public SeekSubAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(baseContext).inflate(R.layout.seek, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull SeekSubAdapter.ViewHolder holder, int position) {

        final SeekBean.DataBean dataBean = dataBeans.get(position);
        holder.attion_title.setText(dataBean.getTitle());
        Glide.with(baseContext).load(dataBean.getIcon()).into(holder.attion_img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClick != null) {
                    itemClick.Click(dataBean);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView attion_img;
        TextView attion_title, attion_desc;
        Button btn_attion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            attion_img = itemView.findViewById(R.id.attion_img);
            attion_title = itemView.findViewById(R.id.attion_title);
            attion_desc = itemView.findViewById(R.id.attion_desc);
            btn_attion = itemView.findViewById(R.id.btn_attion);
        }
    }

    ItemClick itemClick;

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }

    public interface ItemClick {
        void Click(SeekBean.DataBean dataBean);
    }
}
