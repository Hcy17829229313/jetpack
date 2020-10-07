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
import com.hcy.jetpack.MyApp.bean.CollectionBean;
import com.hcy.jetpack.MyApp.bean.SeekBean;
import com.hcy.jetpack.MyApp.db.Utils;
import com.hcy.jetpack.R;

import java.util.List;

public class Seek2SubAdapter extends RecyclerView.Adapter<Seek2SubAdapter.ViewHolder> {
    Context baseContext;
    List<CollectionBean> dataBeans;

    public Seek2SubAdapter(Context baseContext, List<CollectionBean> dataBeans) {
        this.baseContext = baseContext;
        this.dataBeans = dataBeans;
    }

    @NonNull
    @Override
    public Seek2SubAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(baseContext).inflate(R.layout.seek, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final Seek2SubAdapter.ViewHolder holder, int position) {

        final CollectionBean collectionBean = dataBeans.get(position);
        holder.attion_title.setText(collectionBean.getTitle());
        Glide.with(baseContext).load(collectionBean.getIcon()).into(holder.attion_img);


        holder.btn_attion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                collectionBean.setClick(!collectionBean.isClick());
                if (collectionBean.isClick()) {
                    holder.btn_attion.setText("已关注");
                } else {
                    holder.btn_attion.setText("关注");
                }
            }
        });
        if (collectionBean.isClick()) {
            holder.btn_attion.setText("已关注");
        } else {
            holder.btn_attion.setText("关注");
        }
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
        void Click(CollectionBean dataBean);
    }
}
