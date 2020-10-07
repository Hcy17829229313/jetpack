package com.hcy.jetpack.MyApp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.greendaodemo.db.CollectionBeanDao;
import com.hcy.jetpack.MyApp.bean.CollectionBean;
import com.hcy.jetpack.MyApp.bean.SeekBean;
import com.hcy.jetpack.MyApp.db.Utils;
import com.hcy.jetpack.R;
import com.hcy.jetpack.app.MyApp;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class SeekSubAdapter extends RecyclerView.Adapter<SeekSubAdapter.ViewHolder> {
    Context baseContext;
    List<CollectionBean> dataBeans;
    private CollectionBeanDao dao;
    private CollectionBeanDao beanDao;

    public SeekSubAdapter(Context baseContext, List<CollectionBean> dataBeans) {
        this.baseContext = baseContext;
        this.dataBeans = dataBeans;
    }

    @NonNull
    @Override
    public SeekSubAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(baseContext).inflate(R.layout.seek, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final SeekSubAdapter.ViewHolder holder, final int position) {
        //dao = MyApp.getDaoSession().getCollectionBeanDao();

        final CollectionBean dataBean = dataBeans.get(position);
        holder.attion_title.setText(dataBean.getTitle());
        Glide.with(baseContext).load(dataBean.getIcon()).into(holder.attion_img);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClick != null) {
                    itemClick.Click(dataBean);
                }
            }
        });
        CollectionBeanDao dao = MyApp.getInstance().getDaoSession().getCollectionBeanDao();
        List<CollectionBean> loadAll = dao.loadAll();
        for (CollectionBean collectionBean : loadAll) {
            if(dataBean.getTitle().equals(collectionBean.getTitle())){
                  dataBean.setClick(true);
            }
        }

        holder.btn_attion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                beanDao = MyApp.getInstance().getDaoSession().getCollectionBeanDao();
                dataBean.setClick(!dataBean.isClick());
                if (dataBean.isClick()) {

                     beanDao.insertInTx(dataBean);
                    holder.btn_attion.setText("已关注");

                    EventBus.getDefault().post("1234");

                } else {
                    holder.btn_attion.setText("关注");
                    beanDao.delete(dataBean);
                    EventBus.getDefault().post("1234");

                    EventBus.getDefault().post(dataBean);
                }
            }
        });
        if (dataBean.isClick()) {
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
