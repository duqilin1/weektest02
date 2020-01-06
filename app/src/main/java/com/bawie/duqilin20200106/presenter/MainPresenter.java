package com.bawie.duqilin20200106.presenter;

import com.bawie.duqilin20200106.base.BasePresenter;
import com.bawie.duqilin20200106.contract.IModelContract;
import com.bawie.duqilin20200106.model.MainModel;
import com.bawie.duqilin20200106.model.bean.Bean;
import com.bawie.duqilin20200106.model.bean.ListBean;

/*
 *@auther:杜其林
 *@Date: 2020/1/6
 *@Time:9:19
 *@Description:${DESCRIPTION}
 * */
public class MainPresenter extends BasePresenter<IModelContract.IView> implements IModelContract.IPresenter{

    private MainModel mainModel;

    @Override
    protected void initModel() {
        mainModel = new MainModel();
    }

    @Override
    public void getMainData() {
        mainModel.getMainData(new IModelContract.IModel.IModelCallBack() {
            @Override
            public void onMainSeccess(Bean bean) {
                view.onMainSeccess(bean);
            }

            @Override
            public void onMainFailure(Throwable throwable) {
                view.onMainFailure(throwable);
            }

            @Override
            public void onListSeccess(ListBean listBean) {
                view.onListSeccess(listBean);
            }

            @Override
            public void onListFailure(Throwable throwable) {
                view.onListFailure(throwable);
            }
        });
    }

    @Override
    public void getListData(String category) {
        mainModel.getListData(category, new IModelContract.IModel.IModelCallBack() {
            @Override
            public void onMainSeccess(Bean bean) {
                view.onMainSeccess(bean);
            }

            @Override
            public void onMainFailure(Throwable throwable) {
                view.onMainFailure(throwable);
            }

            @Override
            public void onListSeccess(ListBean listBean) {
                view.onListSeccess(listBean);
            }

            @Override
            public void onListFailure(Throwable throwable) {
                view.onListFailure(throwable);
            }
        });
    }
}
