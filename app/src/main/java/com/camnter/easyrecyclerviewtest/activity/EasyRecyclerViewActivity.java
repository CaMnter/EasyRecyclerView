package com.camnter.easyrecyclerviewtest.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.camnter.easyrecyclerview.widget.EasyRecyclerView;
import com.camnter.easyrecyclerview.widget.decorator.EasyDividerItemDecoration;
import com.camnter.easyrecyclerviewtest.R;
import com.camnter.easyrecyclerviewtest.adapter.MyRecycleViewAdapter;
import com.camnter.easyrecyclerviewtest.bean.RecyclerViewData;

import java.util.ArrayList;

/**
 * Description：EasyRecyclerViewActivity
 * Created by：CaMnter
 * Time：2015-10-21 16:51
 */
public class EasyRecyclerViewActivity extends AppCompatActivity {

    private MyRecycleViewAdapter myRecycleViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_acitivty);

        EasyRecyclerView recyclerView = (EasyRecyclerView) this.findViewById(R.id.recycler_view);
        this.myRecycleViewAdapter = new MyRecycleViewAdapter();
        recyclerView.setAdapter(this.myRecycleViewAdapter);

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
        ArrayList<RecyclerViewData> allData = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            RecyclerViewData dataSingle = new RecyclerViewData();
            RecyclerViewData dataMultiple = new RecyclerViewData();
            String mipmapName = "mm_" + i;
            int mipmapId = this.getMipmapId(this, mipmapName);
            dataSingle.imageResId = mipmapId;
            dataMultiple.content = "Save you from anything " + "26" + "-" + i;
            dataMultiple.imageResId = mipmapId;
            allData.add(dataSingle);
            allData.add(dataMultiple);
        }
        this.myRecycleViewAdapter.setList(allData);
        this.myRecycleViewAdapter.notifyDataSetChanged();
    }

    public int getMipmapId(Context context, String mipmapName) {
        return context.getResources().getIdentifier(mipmapName,
                "mipmap", context.getPackageName());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recycler_view_acitivty, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
