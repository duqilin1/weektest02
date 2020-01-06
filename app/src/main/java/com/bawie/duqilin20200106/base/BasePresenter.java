package com.bawie.duqilin20200106.base;

/*
 *@auther:杜其林
 *@Date: 2020/1/6
 *@Time:9:00
 *@Description:${DESCRIPTION}
 * */
public abstract class BasePresenter<V> {
     protected V view;

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    public void attach(V view) {
        this.view = view;
    }

    public void detach(){
        view = null;
    }
}
