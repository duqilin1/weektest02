package com.bawie.duqilin20200106.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawie.duqilin20200106.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *@auther:杜其林
 *@Date: 2020/1/6
 *@Time:9:27
 *@Description:${DESCRIPTION}
 * */
public class BeanAdapter extends RecyclerView.Adapter<BeanAdapter.MyViewHodler> {
    private List<String> category;

    public BeanAdapter(List<String> category) {

        this.category = category;
    }

    @NonNull
    @Override
    public MyViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.beanitem, null);
        return new MyViewHodler(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHodler holder, int position) {
        String s = category.get(position);
        holder.tvName.setText(s.toString());
        holder.tvName.setText(s.toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickLstener != null) {
                    onItemClickLstener.OnItemClick(s);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    class MyViewHodler extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_name)
        TextView tvName;

        public MyViewHodler(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    OnItemClickLstener onItemClickLstener;

    public void setOnItemClickLstener(OnItemClickLstener onItemClickLstener) {
        this.onItemClickLstener = onItemClickLstener;
    }

    public interface OnItemClickLstener{
        void OnItemClick(String str);
    }
}
