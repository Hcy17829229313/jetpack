package com.hcy.jetpack.MyApp.contract;

import com.hcy.jetpack.MyApp.bean.SeekBean;
import com.hcy.mvplibrary.model.BaseModel;
import com.hcy.mvplibrary.presenter.BasePresenter;
import com.hcy.mvplibrary.view.BaseView;

public interface SeekContract {
    interface Model extends BaseModel {
        void getDataSeek(CallBack callBack);

    }

    interface View extends BaseView {
        void SuccessView(SeekBean seekBean);
    }

    interface Presenter {
        void dataP();
    }

    interface CallBack {
        void SuccessCallback(SeekBean seekBean);

        void Error(String s, int Code);

        void Cancel();
    }
}
