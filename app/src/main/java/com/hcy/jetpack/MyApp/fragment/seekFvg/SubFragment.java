package com.hcy.jetpack.MyApp.fragment.seekFvg;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.JsonElement;
import com.hcy.httplibrary.client.HttpClient;
import com.hcy.httplibrary.utils.JsonUtils;
import com.hcy.httplibrary.utils.LogUtils;
import com.hcy.jetpack.MyApp.adapter.SeekSubAdapter;
import com.hcy.jetpack.MyApp.bean.SeekBean;
import com.hcy.jetpack.MyApp.contract.SeekContract;
import com.hcy.jetpack.MyApp.presenter.SeekPresenter;
import com.hcy.jetpack.MyApp.ui.SubActivity;
import com.hcy.jetpack.R;
import com.hcy.jetpack.app.HttpCallBack;
import com.hcy.mvplibrary.base.BaseMvpFragment;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SubFragment extends Fragment {
    RecyclerView SeekRlv;
    Unbinder unbinder;
    private ArrayList<SeekBean.DataBean> arrayList;
    private SeekSubAdapter seekSubAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.sub_item, null);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("pageCount", "10");
        map.put("tagId", "0");
        map.put("userId", "0");
        map.put("offset", "0");
        map.put("tagType", "excludeFollow");
        new HttpClient.Builder()
                .setApiUrl("serverdemo/tag/queryTagList")
                .get()
                .setParamser(map)
                .build().request(new HttpCallBack<SeekBean>() {
            @Override
            public void onError(String message, int code) {
                LogUtils.e(message + code);
            }

            @Override
            public void cancle() {

            }

            @Override
            public void onSuccess(SeekBean dataBean) {
                Log.d("seek", "onSuccess: " + dataBean.toString());
                arrayList.addAll(dataBean.getData());
                seekSubAdapter.notifyDataSetChanged();
            }

            @Override
            public SeekBean convert(JsonElement result) {
                return JsonUtils.jsonToClass(result, SeekBean.class);
            }
        });
    }

    private void initView(final View inflate) {
        SeekRlv = inflate.findViewById(R.id.Seek_rlv);
        SeekRlv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        SeekRlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        arrayList = new ArrayList<>();
        seekSubAdapter = new SeekSubAdapter(getActivity(), arrayList);
        SeekRlv.setAdapter(seekSubAdapter);

        seekSubAdapter.setItemClick(new SeekSubAdapter.ItemClick() {
            @Override
            public void Click(SeekBean.DataBean dataBean) {
                Intent intent = new Intent(getActivity(), SubActivity.class);
                intent.putExtra("id", dataBean.getId());
                startActivity(intent);
            }
        });
    }
/*
    @Override
    public void SuccessView(SeekBean seekBean) {
       arrayList.addAll(seekBean.getData());
       seekSubAdapter.notifyDataSetChanged();
    }

   @Override
   protected void initView() {
      SeekRlv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
      SeekRlv.setLayoutManager(new LinearLayoutManager(mActivity));
      arrayList = new ArrayList<>();
      seekSubAdapter = new SeekSubAdapter(getActivity(), arrayList);
      SeekRlv.setAdapter(seekSubAdapter);
   }

   @Override
    protected SeekPresenter initPresenter() {
        return mPresenter=new SeekPresenter();
    }

    @Override
    protected int initLayoutId() {
        return R.layout.sub_item;
    }

    @Override
    public void Error(String s, int Code) {
        LogUtils.e(s+Code);
    }

    @Override
    public void Cancel() {

    }
*/

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        // TODO: inflate a fragment view
//        View rootView = super.onCreateView(inflater, container, savedInstanceState);
//        unbinder = ButterKnife.bind(this, rootView);
//        return rootView;
//    }
/*
    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        unbinder.unbind();
    }*/
}
