package com.camnter.easyrecyclerviewtest.adapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.camnter.easyrecyclerview.adapter.EasyRecyclerViewAdapter;
import com.camnter.easyrecyclerview.holder.EasyRecyclerViewHolder;
import com.camnter.easyrecyclerviewtest.R;
import com.camnter.easyrecyclerviewtest.bean.EasyRecyclerViewData;

/**
 * Description：EasyBorderDividerItemDecorationAdapter
 * Created by：CaMnter
 * Time：2016-01-17 13:59
 */
public class EasyBorderDividerItemDecorationAdapter extends EasyRecyclerViewAdapter {
    /**
     * Please return RecyclerView loading layout Id array
     * 请返回RecyclerView加载的布局Id数组
     *
     * @return 布局Id数组
     */
    @Override
    public int[] getItemLayouts() {
        return new int[]{R.layout.item_border};
    }

    /**
     * butt joint the onBindViewHolder and
     * If you want to write logic in onBindViewHolder, you can write here
     * 对接了onBindViewHolder
     * onBindViewHolder里的逻辑写在这
     *
     * @param viewHolder viewHolder
     * @param position   position
     */
    @Override
    public void onBindRecycleViewHolder(EasyRecyclerViewHolder viewHolder, int position) {
        EasyRecyclerViewData data = this.getItem(position);
        if (data == null) return;

        ImageView borderIv = viewHolder.findViewById(R.id.border_item_iv);
        TextView borderTv = viewHolder.findViewById(R.id.border_item_tv);

        borderIv.setImageResource(data.imageResId);
        borderTv.setText(data.content);
    }

    /**
     * Please write judgment logic when more layout
     * and not write when single layout
     * 如果是多布局的话，请写判断逻辑
     * 单布局可以不写
     *
     * @param position Item position
     * @return 布局Id数组中的index
     */
    @Override
    public int getRecycleViewItemType(int position) {
        return 0;
    }
}
