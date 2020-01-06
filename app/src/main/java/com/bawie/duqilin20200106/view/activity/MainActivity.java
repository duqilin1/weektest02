package com.bawie.duqilin20200106.view.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bawie.duqilin20200106.R;
import com.bawie.duqilin20200106.base.BaseActivity;
import com.bawie.duqilin20200106.contract.IModelContract;
import com.bawie.duqilin20200106.model.bean.Bean;
import com.bawie.duqilin20200106.model.bean.ListBean;
import com.bawie.duqilin20200106.presenter.MainPresenter;
import com.bawie.duqilin20200106.util.NetUtil;
import com.bawie.duqilin20200106.view.adapter.BeanAdapter;
import com.bawie.duqilin20200106.view.adapter.ListBeanAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainPresenter> implements IModelContract.IView {

    @BindView(R.id.rv_01)
    RecyclerView rv01;
    @BindView(R.id.rv_02)
    RecyclerView rv02;

    @Override
    protected void initData() {
        //判断是否有网
        if (NetUtil.getInstance().haxNet(this)){
            //有网请求数据
            mPresenter.getMainData();
            mPresenter.getListData("生活");
        }else {

        }
    }

    @Override
    protected void initView() {

    }

    @Override
    protected MainPresenter providePresenter() {
        return new MainPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onMainSeccess(Bean bean) {
        //左边的列表显示
        List<String> category = bean.getCategory();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv01.setLayoutManager(linearLayoutManager);
        //设置适配器
        BeanAdapter beanAdapter = new BeanAdapter(category);
        rv01.setAdapter(beanAdapter);
        //设置适配器的点击事件
        beanAdapter.setOnItemClickLstener(new BeanAdapter.OnItemClickLstener() {
            @Override
            public void OnItemClick(String str) {
                //通过eventBus传值
                EventBus.getDefault().post(str);
            }
        });
    }

    @Override
    public void onMainFailure(Throwable throwable) {

    }

    @Override
    public void onListSeccess(ListBean listBean) {
        //右边的列表展示
        List<ListBean.DataBean> data = listBean.getData();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        rv02.setLayoutManager(gridLayoutManager);
        //设置适配器
        ListBeanAdapter listBeanAdapter = new ListBeanAdapter(data);
        rv02.setAdapter(listBeanAdapter);
    }

    @Override
    public void onListFailure(Throwable throwable) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void aa(String a){
        //判断网络
        if (NetUtil.getInstance().haxNet(this)){
            mPresenter.getListData(a);
        }
    }
}
