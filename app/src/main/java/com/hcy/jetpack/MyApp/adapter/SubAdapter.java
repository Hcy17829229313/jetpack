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
import com.hcy.jetpack.MyApp.bean.SeekBean;
import com.hcy.jetpack.R;

import java.util.List;

public class SubAdapter extends RecyclerView.Adapter {

    Context baseContext;
    List<SeekBean.DataBean> dataBeans;

    public SubAdapter(Context baseContext, List<SeekBean.DataBean> dataBeans) {
        this.baseContext = baseContext;
        this.dataBeans = dataBeans;
    }

    public static final int ONE_TYPE = 0;
    public static final int TWO_TYPE = 1;

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ONE_TYPE;
        } else {
            return TWO_TYPE;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case ONE_TYPE:
                View inflate = LayoutInflater.from(baseContext).inflate(R.layout.subseek_item, parent, false);
                return new OneViewHolder(inflate);

            case TWO_TYPE:
                View inflate1 = LayoutInflater.from(baseContext).inflate(R.layout.sofa_txt, parent, false);
                return new TwoViewHolder(inflate1);

        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        SeekBean.DataBean dataBean = dataBeans.get(position);

        int itemViewType = getItemViewType(position);
        switch (itemViewType) {
            case ONE_TYPE:
                OneViewHolder oneViewHolder = (OneViewHolder) holder;
                oneViewHolder.sub_title.setText(dataBean.getTitle());
                oneViewHolder.sub_intro.setText(dataBean.getIntro());
                oneViewHolder.sub_enterNum.setText(dataBean.getEnterNum()+"人观看");
                Glide.with(baseContext).load(dataBean.getBackground()).into(((OneViewHolder) holder).sub_image);
                break;

            case TWO_TYPE:
              /*  TwoViewHolder twoViewHolder = (TwoViewHolder) holder;
                RequestOptions requestOptions = RequestOptions.circleCropTransform();
                Glide.with(baseContext).load(dataBean.getBackground()).apply(requestOptions).into();
*/
                break;
        }
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    private class OneViewHolder extends RecyclerView.ViewHolder {
        ImageView sub_image;
        TextView sub_title, sub_intro, sub_enterNum;

        public OneViewHolder(@NonNull View itemView) {
            super(itemView);
            sub_enterNum = itemView.findViewById(R.id.sub_enterNum);
            sub_intro = itemView.findViewById(R.id.sub_intro);
            sub_title = itemView.findViewById(R.id.sub_title);
            sub_image = itemView.findViewById(R.id.sub_image);
        }
    }

    private class TwoViewHolder extends RecyclerView.ViewHolder {
        ImageView mHead_txt, card_img;
        ImageView zan_img_txt, cai_img_txt, msg_img_txt, share_img_txt;
        TextView zan_cout_txt, cai_cout_txt, msg_cout_txt, share_cout_txt, mHeader_Title_txt, mTitle_txt, card_title;
        CardView card;

        public TwoViewHolder(@NonNull View itemView) {
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
