/*
 * Copyright (C) 2015 CaMnter 421482590@qq.com
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
import android.support.v7.app.AppCompatActivity;

import com.camnter.easyrecyclerview.widget.EasyRecyclerView;
import com.camnter.easyrecyclerview.widget.decorator.EasyDividerItemDecoration;
import com.camnter.easyrecyclerviewtest.R;
import com.camnter.easyrecyclerviewtest.adapter.EasyDividerItemDecorationAdapter;
import com.camnter.easyrecyclerviewtest.bean.EasyRecyclerViewData;

import java.util.ArrayList;

/**
 * Description：EasyDividerItemDecorationActivity
 * Created by：CaMnter
 * Time：2015-10-21 16:51
 */
public class EasyDividerItemDecorationActivity extends AppCompatActivity {

    private EasyDividerItemDecorationAdapter easyDividerItemDecorationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_divider);

        EasyRecyclerView recyclerView = (EasyRecyclerView) this.findViewById(R.id.recycler_view);
        this.easyDividerItemDecorationAdapter = new EasyDividerItemDecorationAdapter();
        recyclerView.setAdapter(this.easyDividerItemDecorationAdapter);

        // set divider
        recyclerView.addItemDecoration(
                new EasyDividerItemDecoration(
                        this,
                        EasyDividerItemDecoration.VERTICAL_LIST,
                        R.drawable.bg_recycler_view_divider
                )
        );

        this.initData();
    }

    private void initData() {
        ArrayList<EasyRecyclerViewData> allData = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            EasyRecyclerViewData dataSingle = new EasyRecyclerViewData();
            EasyRecyclerViewData dataMultiple = new EasyRecyclerViewData();
            String mipmapName = "mm_" + i;
            int mipmapId = this.getMipmapId(this, mipmapName);
            dataSingle.imageResId = mipmapId;
            dataMultiple.content = "Save you from anything " + "26" + "-" + i;
            dataMultiple.imageResId = mipmapId;
            allData.add(dataSingle);
            allData.add(dataMultiple);
        }
        this.easyDividerItemDecorationAdapter.setList(allData);
        this.easyDividerItemDecorationAdapter.notifyDataSetChanged();
    }

    public int getMipmapId(Context context, String mipmapName) {
        return context.getResources().getIdentifier(mipmapName,
                "mipmap", context.getPackageName());
    }

}
