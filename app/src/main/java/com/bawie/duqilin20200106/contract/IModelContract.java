package com.bawie.duqilin20200106.contract;

import com.bawie.duqilin20200106.model.bean.Bean;
import com.bawie.duqilin20200106.model.bean.ListBean;

/*
 *@auther:杜其林
 *@Date: 2020/1/6
 *@Time:9:06
 *@Description:${DESCRIPTION}
 * */
public interface IModelContract {

    interface IView{
        void onMainSeccess(Bean bean);
        void onMainFailure(Throwable throwable);

        void onListSeccess(ListBean listBean);
        void onListFailure(Throwable throwable);
    }

    interface IPresenter{
        void getMainData();
        void getListData(String category );
    }

    interface IModel{
        void getMainData(IModelCallBack iModelCallBack);
        void getListData(String category,IModelCallBack iModelCallBack);

        interface IModelCallBack{
            void onMainSeccess(Bean bean);
            void onMainFailure(Throwable throwable);

            void onListSeccess(ListBean listBean);
            void onListFailure(Throwable throwable);
        }
    }
}
