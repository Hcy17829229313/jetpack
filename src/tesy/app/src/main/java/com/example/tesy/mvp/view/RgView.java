package com.example.tesy.mvp.view;

import com.example.tesy.ergbean.EgHomeTabBean;
import com.hcy.mvplibrary.view.BaseView;

import java.util.List;

public interface RgView extends BaseView {
    void SuccessView(List<EgHomeTabBean> egHomeTabBeans);
}
