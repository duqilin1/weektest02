package com.bawie.duqilin20200106.model;

import com.bawie.duqilin20200106.contract.IModelContract;
import com.bawie.duqilin20200106.model.bean.Bean;
import com.bawie.duqilin20200106.model.bean.ListBean;
import com.bawie.duqilin20200106.util.NetUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/*
 *@auther:杜其林
 *@Date: 2020/1/6
 *@Time:9:17
 *@Description:${DESCRIPTION}
 * */
public class MainModel implements IModelContract.IModel{

    @Override
    public void getMainData(IModelCallBack iModelCallBack) {
        NetUtil.getInstance().getApi().beanObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        iModelCallBack.onMainSeccess(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onMainFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getListData(String category, IModelCallBack iModelCallBack) {

        NetUtil.getInstance().getApi().listBeanObservable(category)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<ListBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(ListBean listBean) {
                            iModelCallBack.onListSeccess(listBean);
                        }

                        @Override
                        public void onError(Throwable e) {
                            iModelCallBack.onListFailure(e);
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
    }
}
