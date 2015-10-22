EasyRecyclerView
==

---

## Gradle

```Gradle
dependencies {
    compile 'com.camnter.easyrecyclerview:easyrecyclerview:0.1'
}
```

---

## Blog

 [EasyRecyclerView](http://blog.csdn.net/qq_16430735/article/details/49341563)

---

## RecyclerViewAdapter



```Java
public class MyRecycleViewAdapter extends EasyRecyclerViewAdapter {

    private static final int MULTIPLE_ITEM_TYPE = 0;
    private static final int SINGLE_ITEM_TYPE = 1;


    /**
     * Please return RecyclerView loading layout Id array
     * 请返回RecyclerView加载的布局Id数组
     *
     * @return 布局Id数组
     */
    @Override
    public int[] getItemLayouts() {
        return new int[]{
                R.layout.item_recyclerview_multiple, R.layout.item_recyclerview_single};
    }

    /**
     * butt joint the onBindViewHolder and
     * If you want to write logic in onBindViewHolder, you can write here
     * 对接了onBindViewHolder
     * onBindViewHolder里的逻辑写在这
     *
     * @param viewHolder
     * @param position
     */
    @Override
    public void onBindRecycleViewHolder(EasyRecyclerViewHolder viewHolder, int position) {
        int itemType = this.getRecycleViewItemType(position);
        RecyclerViewData data = this.getItem(position);
        switch (itemType) {
            case MULTIPLE_ITEM_TYPE: {
                TextView multipleTV = viewHolder.findViewById(R.id.recycler_view_mul_tv);
                ImageView multipleIV = viewHolder.findViewById(R.id.recycler_view_mul_iv);
                multipleTV.setText(data.content);
                multipleIV.setImageResource(data.imageResId);
                break;
            }
            case SINGLE_ITEM_TYPE: {
                ImageView singleIV = viewHolder.findViewById(R.id.recycler_view_single_iv);
                singleIV.setImageResource(data.imageResId);
                break;
            }
        }
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
        if (position % 2 == 0) {
            return SINGLE_ITEM_TYPE;
        } else {
            return MULTIPLE_ITEM_TYPE;
        }
    }

}
```

---


## RecyclerViewActivity



```Java
public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyRecycleViewAdapter myRecycleViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_acitivty);

        this.recyclerView = (RecyclerView) this.findViewById(R.id.recycler_view);
        this.myRecycleViewAdapter = new MyRecycleViewAdapter();
        recyclerView.setAdapter(this.myRecycleViewAdapter);
        this.initRecyclerView();
        this.initData();
    }

    private void initRecyclerView() {
        this.recyclerView.setAdapter(this.myRecycleViewAdapter);

        // init LinearLayoutManager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        // set the VERTICAL layout
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        // set layout manager
        this.recyclerView.setLayoutManager(linearLayoutManager);


        // Keep recyclerview fixed size
        this.recyclerView.setHasFixedSize(true);
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
```

---

## Consequence

![recyclerview_1](https://github.com/CaMnter/EasyRecyclerView/raw/master/readme/recyclerview_1.png)







