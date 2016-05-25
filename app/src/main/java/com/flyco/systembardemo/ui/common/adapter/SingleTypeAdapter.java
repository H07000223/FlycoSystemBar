package com.flyco.systembardemo.ui.common.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public abstract class SingleTypeAdapter<E> extends BaseAdapter {
    private int mItemLayoutId;
    private List<E> mList;

    public SingleTypeAdapter(List<E> list, int itemLayoutId) {
        mList = list;
        mItemLayoutId = itemLayoutId;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(mItemLayoutId, parent, false);
        return new ViewHolder(this, inflate);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public List<E> getDataList() {
        return mList;
    }
}
