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
import com.example.tesy.ergbean.EgCountBean;

import java.util.List;

public class LookCountAdapter extends RecyclerView.Adapter<LookCountAdapter.ViewHolder> {

    Context baseContext;
    List<EgCountBean> egCountBeans;

    public LookCountAdapter(Context baseContext, List<EgCountBean> egCountBeans) {
        this.baseContext = baseContext;
        this.egCountBeans = egCountBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(baseContext).inflate(R.layout.count_item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        EgCountBean egCountBean = egCountBeans.get(position);
        holder.count_title.setText(egCountBean.getName());
        Glide.with(baseContext).load(egCountBean.getImage()).into(holder.count_img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClick!=null){
                    itemClick.Click(egCountBean);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return egCountBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView count_img;
        TextView count_title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            count_img = itemView.findViewById(R.id.count_img);
            count_title = itemView.findViewById(R.id.count_title);
        }
    }

    ItemClick itemClick;

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }

    public interface ItemClick{
        void Click(EgCountBean egCountBean);
    }
}
