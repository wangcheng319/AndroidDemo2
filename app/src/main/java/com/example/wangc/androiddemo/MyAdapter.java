package com.example.wangc.androiddemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wangc on 2018/7/3
 * E-MAIL:274281610@QQ.COM
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context mContext;
    private List<String> mDatas;

    public MyAdapter(Context mContext,List<String> mDatas){
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(android.R.layout.simple_list_item_1,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText("第"+mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class  MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView ;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
        }

    }
}
