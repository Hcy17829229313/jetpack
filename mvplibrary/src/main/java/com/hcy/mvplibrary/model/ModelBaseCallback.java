package com.hcy.mvplibrary.model;


public interface ModelBaseCallback<T> {

    void onSucess(T t);

    void Onerror(String msg, int code);

    void onCancle();


}
