package com.bawie.duqilin20200106.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawie.duqilin20200106.R;
import com.bawie.duqilin20200106.model.bean.ListBean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *@auther:杜其林
 *@Date: 2020/1/6
 *@Time:9:27
 *@Description:${DESCRIPTION}
 * */
public class ListBeanAdapter extends RecyclerView.Adapter<ListBeanAdapter.MyViewHodler> {


    private List<ListBean.DataBean> data;

    public ListBeanAdapter(List<ListBean.DataBean> data) {

        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.listbeanitem, null);
        return new MyViewHodler(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHodler holder, int position) {
        ListBean.DataBean dataBean = data.get(position);
        holder.tvText.setText(dataBean.getGoods_english_name());
        holder.tvText1.setText(dataBean.getGoods_name());
        holder.tvText2.setText(dataBean.getCurrency_price());
        Glide.with(holder.img).load(dataBean.getGoods_thumb())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHodler extends RecyclerView.ViewHolder {

        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.tv_text)
        TextView tvText;
        @BindView(R.id.tv_text1)
        TextView tvText1;
        @BindView(R.id.tv_text2)
        TextView tvText2;

        public MyViewHodler(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
