package com.xm22xiu.zhou2.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.xm22xiu.zhou2.R;
import com.xm22xiu.zhou2.bean.House;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author:Created by YangYong on 2018/8/13 0013.
 */
public class RvAdapter extends RecyclerView.Adapter {
    private List<House.DataBean> list;
    private Context context;

    public RvAdapter(List<House.DataBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        House.DataBean bean = list.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.itemImg.setImageURI(Uri.parse(bean.getLogo()));
        viewHolder.itemTitle.setText(bean.getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_img)
        SimpleDraweeView itemImg;
        @BindView(R.id.item_title)
        TextView itemTitle;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
