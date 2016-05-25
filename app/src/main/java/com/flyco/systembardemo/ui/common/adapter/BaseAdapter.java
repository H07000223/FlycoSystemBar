package com.flyco.systembardemo.ui.common.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseAdapter extends RecyclerView.Adapter<BaseAdapter.ViewHolder> {
    public abstract void bindView(ViewHolder holder, int position, View itemView);

    @Override
    public final void onBindViewHolder(final ViewHolder holder, int position) {
        final View inflate = holder.mItemView;
        bindView(holder, position, inflate);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * override this method to handle view click listener in item view
     * <pre>
     * TextView item = holder.getItemView().findViewById(R.id.item);
     * item.setHandleClickListener(new View.OnClickListener() {
     *      public void onClick(View v) {
     *      }
     * });
     * </pre>
     */
    public void handleClick(ViewHolder holder) {
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private View mItemView;
        private BaseAdapter mAdapter;

        public ViewHolder(BaseAdapter adapter, View itemView) {
            super(itemView);
            mItemView = itemView;
            mAdapter = adapter;
            mAdapter.handleClick(this);
            if (mAdapter.mHandleClickListener != null) {
                mAdapter.mHandleClickListener.handleClick(this);
            }
        }

        public View getItemView() {
            return mItemView;
        }

        public BaseAdapter getAdapter() {
            return mAdapter;
        }
    }


    private HandleClickListener mHandleClickListener;

    public interface HandleClickListener {
        void handleClick(ViewHolder holder);
    }

    public void setHandleClickListener(HandleClickListener handleClickListener) {
        mHandleClickListener = handleClickListener;
    }
}
