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

package com.camnter.easyrecyclerviewtest.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.camnter.easyrecyclerview.widget.EasyRecyclerView;
import com.camnter.easyrecyclerview.widget.decorator.EasyBorderDividerItemDecoration;
import com.camnter.easyrecyclerviewtest.R;
import com.camnter.easyrecyclerviewtest.adapter.EasyBorderDividerItemDecorationAdapter;
import com.camnter.easyrecyclerviewtest.bean.EasyRecyclerViewData;
import java.util.ArrayList;

/**
 * Description：EasyBorderDividerItemDecorationActivity
 * Created by：CaMnter
 * Time：2016-01-17 13:53
 */
public class EasyBorderDividerItemDecorationActivity extends AppCompatActivity {

    private EasyBorderDividerItemDecorationAdapter adapter;


    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_border_divider);
        EasyRecyclerView borderRv = (EasyRecyclerView) this.findViewById(R.id.border_rv);
        this.adapter = new EasyBorderDividerItemDecorationAdapter();
        borderRv.setAdapter(this.adapter);
        borderRv.addItemDecoration(new EasyBorderDividerItemDecoration(
                this.getResources().getDimensionPixelOffset(R.dimen.border_vertical_padding),
                this.getResources().getDimensionPixelOffset(R.dimen.border_horizontal_padding)));

        this.initData();
    }


    private void initData() {

        ArrayList<EasyRecyclerViewData> allData = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            EasyRecyclerViewData data = new EasyRecyclerViewData();
            String mipmapName = "mm_" + i;
            data.imageResId = this.getMipmapId(this, mipmapName);
            data.content = "Save you from anything " + "26" + "-" + i;
            allData.add(data);
        }
        this.adapter.setList(allData);
        this.adapter.notifyDataSetChanged();
    }


    public int getMipmapId(Context context, String mipmapName) {
        return context.getResources().getIdentifier(mipmapName, "mipmap", context.getPackageName());
    }
}
