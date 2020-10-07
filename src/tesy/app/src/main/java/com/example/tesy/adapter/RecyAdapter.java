package com.example.tesy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tesy.R;
import com.example.tesy.ergbean.EgBean;

import java.util.List;

public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.ViewHolder> {

    Context baseContext;
    List<EgBean.DataBean> videoBeans;

    public RecyAdapter(Context baseContext, List<EgBean.DataBean> videoBeans) {
        this.baseContext = baseContext;
        this.videoBeans = videoBeans;
    }

    @NonNull
    @Override
    public RecyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(baseContext).inflate(R.layout.recy_item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyAdapter.ViewHolder holder, int position) {
        EgBean.DataBean dataBean = videoBeans.get(position);
        holder.recy_title.setText(dataBean.getName());
        Glide.with(baseContext).load(dataBean.getImage()).into(holder.recy_img);
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
        return videoBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView recy_img;
        TextView recy_title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recy_img = itemView.findViewById(R.id.re_img);
            recy_title = itemView.findViewById(R.id.recy_title);
        }
    }

    ItemClick itemClick;

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }

    public interface ItemClick {
        void Click(EgBean.DataBean dataBean);
    }
}
