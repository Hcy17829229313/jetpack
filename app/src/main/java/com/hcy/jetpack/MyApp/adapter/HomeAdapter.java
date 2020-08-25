package com.hcy.jetpack.MyApp.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.hcy.jetpack.MyApp.bean.HomeBean;
import com.hcy.jetpack.R;

import java.util.List;

import cn.jzvd.JZVideoPlayerStandard;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    Context baseContext;

    List<HomeBean.DataBean> homeBeans;

    public HomeAdapter(Context baseContext, List<HomeBean.DataBean> homeBeans) {
        this.baseContext = baseContext;
        this.homeBeans = homeBeans;
    }

    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(baseContext).inflate(R.layout.home, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final HomeAdapter.ViewHolder holder, final int position) {

        final HomeBean.DataBean dataBean = homeBeans.get(position);
        holder.mHeader_Title.setText(dataBean.getFeeds_text() + "");
        holder.mTitle.setText(dataBean.getAuthor().getName());
        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        Glide.with(baseContext).load(dataBean.getAuthor().getAvatar()).apply(requestOptions).into(holder.mHead);


        holder.zan_cout.setText(dataBean.getUgc().getLikeCount() + "");
        holder.share_cout.setText(dataBean.getUgc().getShareCount() + "");
        holder.msg_cout.setText(dataBean.getUgc().getCommentCount() + "");


        holder.zan_img.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (holder.zan_img.isChecked()) {
                    holder.zan_img.setBackgroundResource(R.mipmap.icon_cell_liked);
                    holder.zan_cout.setText(dataBean.getUgc().getLikeCount() + (1) + "");
                    holder.cai_img.setBackgroundResource(R.mipmap.icon_cell_diss);
                } else {
                    holder.zan_img.setBackgroundResource(R.mipmap.icon_cell_like);
                    holder.zan_cout.setText(dataBean.getUgc().getLikeCount() + "");
                }
            }
        });

        holder.cai_img.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (holder.cai_img.isChecked()) {
                    holder.cai_img.setBackgroundResource(R.mipmap.icon_cell_dissed);
                    holder.zan_img.setBackgroundResource(R.mipmap.icon_cell_like);
                    holder.zan_cout.setText(dataBean.getUgc().getLikeCount() + "");
                } else {
                    holder.cai_img.setBackgroundResource(R.mipmap.icon_cell_diss);

                }
            }
        });


        holder.videoplayer.setUp(String.valueOf(Uri.parse((String) dataBean.getUrl()))
                , JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "");

        Glide.with(baseContext).load(dataBean.getCover()).into(holder.videoplayer.thumbImageView);


        //      holder. videoplayer .startButton.performClick();
    }

    @Override
    public int getItemCount() {
        return homeBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mHead;
        CheckBox zan_img, cai_img;
        TextView mHeader_Title, mTitle;
        JZVideoPlayerStandard videoplayer;

        TextView zan_cout, cai_cout, msg_cout, share_cout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mHead = itemView.findViewById(R.id.mHead);
            mHeader_Title = itemView.findViewById(R.id.mHeader_Title);
            mTitle = itemView.findViewById(R.id.mTitle);
            videoplayer = itemView.findViewById(R.id.videoplayer);
            zan_img = itemView.findViewById(R.id.zan_img);
            cai_img = itemView.findViewById(R.id.cai_img);


            zan_cout = itemView.findViewById(R.id.zan_cout);
            cai_cout = itemView.findViewById(R.id.cai_cout);
            msg_cout = itemView.findViewById(R.id.msg_cout);
            share_cout = itemView.findViewById(R.id.share_cout);
        }
    }

    ItemClick itemClick;

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }

    public interface ItemClick {
        void Click(int posi);
    }
}
