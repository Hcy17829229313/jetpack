package com.hcy.jetpack.MyApp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.hcy.jetpack.MyApp.bean.SoFaBean;
import com.hcy.jetpack.R;

import java.util.List;

public class SoFaTxtAdapter extends RecyclerView.Adapter<SoFaTxtAdapter.ViewHolder> {

    Context baseContext;
    List<SoFaBean.DataBean> dataBeanXList;

    public SoFaTxtAdapter(Context baseContext, List<SoFaBean.DataBean> dataBeanXList) {
        this.baseContext = baseContext;
        this.dataBeanXList = dataBeanXList;
    }

    @NonNull
    @Override
    public SoFaTxtAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(baseContext).inflate(R.layout.sofa_txt, parent, false);
        return new SoFaTxtAdapter.ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull SoFaTxtAdapter.ViewHolder holder, int position) {

        SoFaBean.DataBean dataBean = dataBeanXList.get(position);


        holder.zan_cout_txt.setText(dataBean.getUgc().getLikeCount()+"");
        holder.share_cout_txt.setText(dataBean.getUgc().getShareCount()+"");
        holder.msg_cout_txt.setText(dataBean.getUgc().getCommentCount()+"");

        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        Glide.with(baseContext).load(dataBean.getAuthor().getAvatar()).apply(requestOptions).into(holder.mHead_txt);

        holder.mHeader_Title_txt.setText(dataBean.getAuthor().getName());

        if (dataBean.getFeeds_text() == null) {
            holder.mTitle_txt.setVisibility(View.GONE);
        } else {
            holder.mTitle_txt.setText(dataBean.getFeeds_text() + "");
        }


        if(dataBean.getActivityText()==null){
            holder.card.setVisibility(View.GONE);
        }else{
            holder.card_title.setText(dataBean.getActivityText()+"");
        }


    }

    @Override
    public int getItemCount() {
        return dataBeanXList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mHead_txt, card_img;
        ImageView zan_img_txt, cai_img_txt, msg_img_txt, share_img_txt;
        TextView zan_cout_txt, cai_cout_txt, msg_cout_txt, share_cout_txt,mHeader_Title_txt,mTitle_txt,card_title;

        CardView card;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mHead_txt = itemView.findViewById(R.id.mHead_txt);
            card_img = itemView.findViewById(R.id.card_img);
            card_title = itemView.findViewById(R.id.card_title);
            card = itemView.findViewById(R.id.card);


            zan_img_txt = itemView.findViewById(R.id.zan_img_txt);
            cai_img_txt = itemView.findViewById(R.id.cai_img_txt);
            msg_img_txt = itemView.findViewById(R.id.msg_img_txt);
            share_img_txt = itemView.findViewById(R.id.share_img_txt);

            mHeader_Title_txt = itemView.findViewById(R.id.mHeader_Title_txt);
            mTitle_txt = itemView.findViewById(R.id.mTitle_txt);


            zan_cout_txt = itemView.findViewById(R.id.zan_cout_txt);
            cai_cout_txt = itemView.findViewById(R.id.cai_cout_txt);
            msg_cout_txt = itemView.findViewById(R.id.msg_cout_txt);
            share_cout_txt = itemView.findViewById(R.id.share_cout_txt);
        }
    }
}
