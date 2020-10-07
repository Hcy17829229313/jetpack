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
import com.example.tesy.egBabyBean.BabySubBean;
import com.example.tesy.ergbean.EgSubBean;

import java.util.List;

public class BaBySubAdapter extends RecyclerView.Adapter<BaBySubAdapter.ViewHolder> {

    Context baseContext;
    List<BabySubBean> babySubBeans;

    public BaBySubAdapter(Context baseContext, List<BabySubBean> babySubBeans) {
        this.baseContext = baseContext;
        this.babySubBeans = babySubBeans;
    }

    @NonNull
    @Override
    public BaBySubAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(baseContext).inflate(R.layout.ba_sub_item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull BaBySubAdapter.ViewHolder holder, int position) {
        BabySubBean babySubBean = babySubBeans.get(position);

        holder.ba_sub_title.setText(babySubBean.getName());
        holder.ba_sub_desc.setText(babySubBean.getDescription());
        holder.ba_sub_select.setText(babySubBean.getCount() + "首");
        Glide.with(baseContext).load(babySubBean.getImage()).into(holder.ba_sub_img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClicki != null) {
                    itemClicki.Click(babySubBean);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return babySubBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ba_sub_img;
        TextView ba_sub_title, ba_sub_desc, ba_sub_select;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ba_sub_img = itemView.findViewById(R.id.ba_sub_imgg);
            ba_sub_title = itemView.findViewById(R.id.ba_sub_title);
            ba_sub_desc = itemView.findViewById(R.id.ba_sub_desc);
            ba_sub_select = itemView.findViewById(R.id.ba_sub_select);
        }
    }

    ItemClick itemClicki;

    public void setItemClicki(ItemClick itemClicki) {
        this.itemClicki = itemClicki;
    }

    public interface ItemClick {
        void Click(BabySubBean subBean);
    }
}
