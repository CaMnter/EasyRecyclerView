package com.camnter.easyrecyclerview.holder;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * Description：EasyRecyclerViewHolder
 * Created by：CaMnter
 * Time：2015-10-21 15:44
 */
public class EasyRecyclerViewHolder extends RecyclerView.ViewHolder {

    /**
     * Used to hold the findViewById loading the view
     * 用于保存findViewById加载过的view
     */
    private final SparseArray<View> views;
    private View convertView;

    public EasyRecyclerViewHolder(View convertView) {
        super(convertView);
        this.views = new SparseArray<>();
        this.convertView = convertView;
    }

    /**
     * set the on item click listener
     * 设置Item的点击事件
     *
     * @param listener listener
     * @param position position
     */
    public void setOnItemClickListener(final EasyRecyclerViewHolder.OnItemClickListener listener, final int position) {
        if (listener == null) {
            this.itemView.setOnClickListener(null);
        } else {
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(v, position);
                }
            });
        }
    }

    /**
     * set the on item long click listener
     * 设置Item的长点击事件
     *
     * @param listener listener
     * @param position position
     */
    public void setOnItemLongClickListener(final EasyRecyclerViewHolder.OnItemLongClickListener listener, final int position) {
        if (listener == null) {
            this.itemView.setOnLongClickListener(null);
        } else {
            this.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return listener.onItemLongClick(v, position);
                }
            });
        }
    }

    /**
     * Due to the findViewById performance too low
     * The findViewById view will be cached, provide the findViewById next time the same view
     * ViewHolder model for the View
     * 由于findViewById性能过低
     * findViewById过的view会被缓存下来，以供下次find相同view的时候
     * ViewHolder模式 查找子View
     *
     * @param viewId viewId
     * @param <T>    T
     * @return T
     */
    public <T extends View> T findViewById(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = convertView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * the click listeners callback
     * 点击事件回调
     */
    public interface OnItemClickListener {
        /**
         * on item click call back
         *
         * @param convertView convertView
         * @param position    position
         */
        void onItemClick(View convertView, int position);
    }

    /**
     * the long click listeners callback
     * 长点击事件回调
     */
    public interface OnItemLongClickListener {
        /**
         * on item long click call back
         *
         * @param convertView convertView
         * @param position    position
         * @return true false
         */
        boolean onItemLongClick(View convertView, int position);
    }

}
