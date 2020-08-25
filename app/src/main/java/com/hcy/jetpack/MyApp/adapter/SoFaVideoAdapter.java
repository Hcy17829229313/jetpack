package com.hcy.jetpack.MyApp.adapter;

import android.content.Context;
import android.net.Uri;
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

public class SoFaVideoAdapter extends RecyclerView.Adapter<SoFaVideoAdapter.ViewHolder> {

    Context baseContext;
    List<SoFaBean.DataBean> dataBeanXList;

    public SoFaVideoAdapter(Context baseContext, List<SoFaBean.DataBean> dataBeanXList) {
        this.baseContext = baseContext;
        this.dataBeanXList = dataBeanXList;
    }
    @NonNull
    @Override
    public SoFaVideoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(baseContext).inflate(R.layout.sofa_video, parent, false);

        return new SoFaVideoAdapter.ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull SoFaVideoAdapter.ViewHolder holder, int position) {

        SoFaBean.DataBean dataBean = dataBeanXList.get(position);
        holder.mHeader_Title_video.setText(dataBean.getFeeds_text()+"");
        holder.mTitle_video.setText(dataBean.getAuthor().getName());
        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        Glide.with(baseContext).load(dataBean.getAuthor().getAvatar()).apply(requestOptions).into(holder.mHead_video);



        holder.zan_cout_video.setText(dataBean.getUgc().getLikeCount()+"");
        holder.share_cout_video.setText(dataBean.getUgc().getShareCount()+"");
        holder.msg_cout_video.setText(dataBean.getUgc().getCommentCount()+"");

        holder.videoplayer_video.setUp(String.valueOf(Uri.parse((String) dataBean.getUrl()))
                , JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "");

        Glide.with(baseContext).load(dataBean.getCover()).into(holder.videoplayer_video.thumbImageView);

    }

    @Override
    public int getItemCount() {
        return dataBeanXList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mHead_video;
        TextView mHeader_Title_video, mTitle_video;
        JZVideoPlayerStandard videoplayer_video;

        TextView zan_cout_video,cai_cout_video,msg_cout_video,share_cout_video;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mHead_video=itemView.findViewById(R.id.mHead_video);
            mHeader_Title_video=itemView.findViewById(R.id.mHeader_Title_video);
            mTitle_video=itemView.findViewById(R.id.mTitle_video);
            videoplayer_video=itemView.findViewById(R.id.videoplayer_video);


            zan_cout_video=itemView.findViewById(R.id.zan_cout_video);
            cai_cout_video=itemView.findViewById(R.id.cai_cout_video);
            msg_cout_video=itemView.findViewById(R.id.msg_cout_video);
            share_cout_video=itemView.findViewById(R.id.share_cout_video);
        }
    }
}
