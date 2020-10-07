package com.example.tesy.egfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tesy.R;

public class Video_Zhuan_Fragment extends Fragment {
    private RecyclerView video_zhuan_rlv;
    private ImageView onErro_mok;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.video_zhuan, null);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        video_zhuan_rlv = inflate.findViewById(R.id.video_zhuan_rlv);
        onErro_mok = inflate.findViewById(R.id.onErro_mok);
        if (video_zhuan_rlv == null) {
            onErro_mok.setVisibility(View.VISIBLE);

        }
    }

}
