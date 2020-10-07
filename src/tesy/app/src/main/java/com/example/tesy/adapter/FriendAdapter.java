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
import com.example.tesy.ergbean.EgFriandBean;
import com.example.tesy.ergbean.EgGliBean;

import java.util.List;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder> {
    Context baseContext;
    List<EgFriandBean> egFriandBeans;

    public FriendAdapter(Context baseContext, List<EgFriandBean> egFriandBeans) {
        this.baseContext = baseContext;
        this.egFriandBeans = egFriandBeans;
    }

    @NonNull
    @Override
    public FriendAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(baseContext).inflate(R.layout.gli_item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendAdapter.ViewHolder holder, int position) {

        EgFriandBean egFriandBean = egFriandBeans.get(position);
        holder.gli_title.setText(egFriandBean.getTitle());
        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        Glide.with(baseContext).load(egFriandBean.getImage_url()).apply(requestOptions).into(holder.gli_img);
    }

    @Override
    public int getItemCount() {
        return egFriandBeans.size();
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
}
