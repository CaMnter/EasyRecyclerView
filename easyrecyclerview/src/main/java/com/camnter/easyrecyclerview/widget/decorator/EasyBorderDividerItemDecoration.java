/*
 * Copyright (C) 2015 CaMnter yuanyu.camnter@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.camnter.easyrecyclerview.widget.decorator;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Description：EasyBorderDividerItemDecoration
 * Created by：CaMnter
 * Time：2016-01-08 14:44
 */
public class EasyBorderDividerItemDecoration extends RecyclerView.ItemDecoration {

    private final int verticalItemSpacingInPx;
    private final int horizontalItemSpacingInPx;

    public EasyBorderDividerItemDecoration(int verticalItemSpacingInPx, int horizontalItemSpacingInPx) {
        this.verticalItemSpacingInPx = verticalItemSpacingInPx;
        this.horizontalItemSpacingInPx = horizontalItemSpacingInPx;
    }

    /**
     * set border
     *
     * @param outRect outRect
     * @param view    view
     * @param parent  parent
     * @param state   state
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        int itemPosition = layoutParams.getViewLayoutPosition();
        int childCount = parent.getAdapter().getItemCount();

        int left = this.horizontalItemSpacingInPx;
        int right = this.horizontalItemSpacingInPx;

        int top = getItemTopSpacing(itemPosition);
        int bottom = getItemBottomSpacing(itemPosition, childCount);
        outRect.set(left, top, right, bottom);
    }

    /**
     * get the item bottom spacing
     *
     * @param itemPosition itemPosition
     * @param childCount   childCount
     * @return int
     */
    private int getItemBottomSpacing(int itemPosition, int childCount) {
        if (isLastItem(itemPosition, childCount)) {
            return this.verticalItemSpacingInPx;
        }
        return this.verticalItemSpacingInPx / 2;
    }

    /**
     * get the item top spacing
     *
     * @param itemPosition itemPosition
     * @return int
     */
    private int getItemTopSpacing(int itemPosition) {
        if (isFirstItem(itemPosition)) {
            return this.verticalItemSpacingInPx;
        }
        return this.verticalItemSpacingInPx / 2;
    }

    /**
     * is the first item
     *
     * @param itemPosition itemPosition
     * @return boolean
     */
    private boolean isFirstItem(int itemPosition) {
        return itemPosition == 0;
    }


    /**
     * is the last item
     *
     * @param itemPosition itemPosition
     * @param childCount   childCount
     * @return boolean
     */
    private boolean isLastItem(int itemPosition, int childCount) {
        return itemPosition == childCount - 1;
    }
}
