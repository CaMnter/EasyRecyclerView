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

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.camnter.easyrecyclerview.holder.EasyRecyclerViewHolder;
import com.camnter.easyrecyclerview.widget.EasyRecyclerView;
import com.camnter.easyrecyclerview.widget.decorator.EasyDividerItemDecoration;
import com.camnter.easyrecyclerviewtest.R;
import com.camnter.easyrecyclerviewtest.adapter.MainAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Description：MainActivity
 * Created by：CaMnter
 * Time：2016-01-17 00:17
 */
public class MainActivity extends AppCompatActivity
        implements EasyRecyclerViewHolder.OnItemClickListener {

    private EasyRecyclerView mainRv;
    private MainAdapter mainAdapter;


    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        this.mainRv = (EasyRecyclerView) this.findViewById(R.id.main_rv);
        this.mainRv.addItemDecoration(
                new EasyDividerItemDecoration(this, EasyDividerItemDecoration.VERTICAL_LIST));

        this.initData();
        this.initListeners();
    }


    private void initData() {
        this.mainAdapter = new MainAdapter();
        List<Class> classes = new ArrayList<>();
        classes.add(EasyDividerItemDecorationActivity.class);
        classes.add(EasyBorderDividerItemDecorationActivity.class);
        mainAdapter.setList(classes);
        this.mainRv.setAdapter(mainAdapter);
    }


    private void initListeners() {
        this.mainAdapter.setOnItemClickListener(this);
    }


    /**
     * on item click call back
     *
     * @param convertView convertView
     * @param position position
     */
    @Override public void onItemClick(View convertView, int position) {
        Class c = this.mainAdapter.getItem(position);
        this.startActivity(new Intent(this, c));
    }
}
