package com.hcy.jetpack.MyApp.presenter;

import com.hcy.jetpack.MyApp.bean.SeekBean;
import com.hcy.jetpack.MyApp.contract.SeekContract;
import com.hcy.jetpack.MyApp.model.SeekModel;
import com.hcy.mvplibrary.model.ModleFractory;
import com.hcy.mvplibrary.presenter.BasePresenter;

public class SeekPresenter extends BasePresenter<SeekContract.View> implements SeekContract.Presenter, SeekContract.CallBack {
    @Override
    public void dataP() {
        ModleFractory.creatModle(SeekModel.class).getDataSeek(this);
    }

    @Override
    public void SuccessCallback(SeekBean seekBean) {
        mView.SuccessView(seekBean);
    }

    @Override
    public void Error(String s, int Code) {
        mView.Error(s, Code);
    }

    @Override
    public void Cancel() {
        mView.Cancel();
    }
}
