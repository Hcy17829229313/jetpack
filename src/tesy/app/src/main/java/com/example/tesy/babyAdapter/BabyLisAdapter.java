package com.example.tesy.babyAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tesy.R;
import com.example.tesy.egBabyBean.BabyTabListBean;

import java.util.List;

public class BabyLisAdapter extends RecyclerView.Adapter<BabyLisAdapter.ViewHolder> {

    Context baseContext;
    List<BabyTabListBean> babyTabListBeans;

    public BabyLisAdapter(Context baseContext, List<BabyTabListBean> babyTabListBeans) {
        this.baseContext = baseContext;
        this.babyTabListBeans = babyTabListBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(baseContext).inflate(R.layout.ba_li_item, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        BabyTabListBean recordBean = babyTabListBeans.get(position);
        holder.Ba_li_name.setText(recordBean.getAudios().get(position).getName());
        double duration = recordBean.getAudios().get(position).getDuration();
        holder.time.setText(duration + "");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClick != null) {
                    itemClick.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return babyTabListBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Ba_li_name, time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Ba_li_name = itemView.findViewById(R.id.ba_li_name);
            time = itemView.findViewById(R.id.time);
        }
    }

    ItemClick itemClick;

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }

    public interface ItemClick{
        void onClick(int posi);
    }
}
