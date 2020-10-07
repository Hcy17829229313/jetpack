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
import com.bumptech.glide.request.RequestOptions;
import com.example.tesy.R;
import com.example.tesy.ergbean.EgGliBean;

import java.util.List;

public class GliAdapter extends RecyclerView.Adapter<GliAdapter.ViewHolder> {
    Context baseContext;
    List<EgGliBean> egGliBeans;

    public GliAdapter(Context baseContext, List<EgGliBean> egGliBeans) {
        this.baseContext = baseContext;
        this.egGliBeans = egGliBeans;
    }

    @NonNull
    @Override
    public GliAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(baseContext).inflate(R.layout.gli_item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull GliAdapter.ViewHolder holder, int position) {

        EgGliBean egGliBean = egGliBeans.get(position);
        holder.gli_title.setText(egGliBean.getName());
        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        Glide.with(baseContext).load(egGliBean.getIcon_url()).apply(requestOptions).into(holder.gli_img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClick != null) {
                    itemClick.Click(egGliBean);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return egGliBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView gli_img;
        TextView gli_title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gli_img = itemView.findViewById(R.id.gli_img);
            gli_title = itemView.findViewById(R.id.gli_title);
        }
    }
    ItemClick itemClick;

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }

    public interface ItemClick {
        void Click(EgGliBean egGliBean);

    }
}
