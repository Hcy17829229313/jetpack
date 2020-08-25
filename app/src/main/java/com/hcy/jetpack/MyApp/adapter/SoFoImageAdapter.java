package com.hcy.jetpack.MyApp.adapter;

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
import com.hcy.jetpack.MyApp.bean.SoFaBean;
import com.hcy.jetpack.R;

import java.util.List;

import cn.jzvd.JZVideoPlayerStandard;

public
class SoFoImageAdapter extends RecyclerView.Adapter<SoFoImageAdapter.ViewHolder> {
    Context baseContext;
    List<SoFaBean.DataBean> dataBeanXList;

    public SoFoImageAdapter(Context baseContext, List<SoFaBean.DataBean> dataBeanXList) {
        this.baseContext = baseContext;
        this.dataBeanXList = dataBeanXList;
    }

    @NonNull
    @Override
    public SoFoImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(baseContext).inflate(R.layout.sofa_img, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull SoFoImageAdapter.ViewHolder holder, int position) {

        SoFaBean.DataBean dataBean = dataBeanXList.get(position);

        holder.mHeader_Title_img.setText(dataBean.getAuthor().getName());
        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        Glide.with(baseContext).load(dataBean.getAuthor().getAvatar()).apply(requestOptions).into(holder.mHead_img);
        Glide.with(baseContext).load(dataBean.getCover()).into(holder.img);

        if(dataBean.getActivityText()==null){

            holder.img_small_title.setVisibility(View.GONE);
        }else{
            holder.img_small_title.setText(dataBean.getActivityText()+"");
        }


        holder.zan_cout_img.setText(dataBean.getUgc().getLikeCount()+"");
        holder.share_cout_img.setText(dataBean.getUgc().getShareCount()+"");
        holder.msg_cout_img.setText(dataBean.getUgc().getCommentCount()+"");

    }

    @Override
    public int getItemCount() {
        return dataBeanXList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mHead_img,img;
        TextView mHeader_Title_img;


        TextView zan_cout_img,cai_cout_img,msg_cout_img,share_cout_img,img_small_title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mHead_img=itemView.findViewById(R.id.mHead_img);
            mHeader_Title_img=itemView.findViewById(R.id.mHeader_Title_img);
            img=itemView.findViewById(R.id.img);


            zan_cout_img=itemView.findViewById(R.id.zan_cout_img);
            cai_cout_img=itemView.findViewById(R.id.cai_cout_img);
            msg_cout_img=itemView.findViewById(R.id.msg_cout_img);
            share_cout_img=itemView.findViewById(R.id.share_cout_img);
            img_small_title=itemView.findViewById(R.id.img_small_title);

        }
    }
}
