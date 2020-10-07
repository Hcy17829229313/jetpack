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
import com.example.tesy.ergbean.EgSubBean;

import java.util.List;

public class SubAdapter extends RecyclerView.Adapter<SubAdapter.ViewHolder> {

    Context baseContext;
    List<EgSubBean> egSubBeans;

    public SubAdapter(Context baseContext, List<EgSubBean> egSubBeans) {
        this.baseContext = baseContext;
        this.egSubBeans = egSubBeans;
    }

    @NonNull
    @Override
    public SubAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(baseContext).inflate(R.layout.subpager_item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull SubAdapter.ViewHolder holder, int position) {
        EgSubBean egSubBean = egSubBeans.get(position);
        holder.sub_title.setText(egSubBean.getName());
        holder.sub_desc.setText(egSubBean.getDescription());
        holder.sub_select.setText("共" + egSubBean.getVideo_count() + "集");
        Glide.with(baseContext).load(egSubBean.getImage_url()).into(holder.sub_img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClick != null) {
                    itemClick.Click(egSubBean);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return egSubBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView sub_img;
        TextView sub_title, sub_desc, sub_select;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sub_img = itemView.findViewById(R.id.sub_img);
            sub_title = itemView.findViewById(R.id.sub_title);
            sub_desc = itemView.findViewById(R.id.sub_desc);
            sub_select = itemView.findViewById(R.id.sub_select);
        }
    }

    ItemClick itemClick;

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }

    public interface ItemClick {
        void Click(EgSubBean egSubBean);
    }
}
