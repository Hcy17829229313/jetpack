package com.example.tesy.mvp.presenter;

import com.example.tesy.ergbean.EgHomeTabBean;
import com.example.tesy.mvp.model.EgModel;
import com.example.tesy.mvp.view.RgView;
import com.hcy.mvplibrary.model.ModleFractory;
import com.hcy.mvplibrary.presenter.BasePresenter;

import java.util.List;

public class EgPresenter extends BasePresenter<RgView> implements EgModel.TabCallBack {

    @Override
    public void CallSuccess(List<EgHomeTabBean> tabBeans) {
        mView.SuccessView(tabBeans);
    }

    public void getData() {
        ModleFractory.creatModle(EgModel.class).getData(this);
    }
}
