EasyRecyclerView
==

![Language](https://img.shields.io/badge/language-Java-EE0000.svg) [![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](https://github.com/CaMnter/EasyRecyclerView/blob/master/LICENSE) 
![Version](https://img.shields.io/badge/version-1.3-8470FF.svg) 
![SDK](https://img.shields.io/badge/SDK-9%2B-orange.svg) 
 [ ![Download](https://api.bintray.com/packages/camnter/maven/easyrecyclerview/images/download.svg) ](https://bintray.com/camnter/maven/easyrecyclerview/_latestVersion) 


## Gradle

```Gradle
dependencies {
    compile 'com.camnter.easyrecyclerview:easyrecyclerview:1.3'
}
```



## Blog

 [EasyRecyclerView](http://blog.csdn.net/qq_16430735/article/details/49341563)



## Adapter


```Java
public class EasyDividerItemDecorationAdapter extends EasyRecyclerViewAdapter {

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
     * @param viewHolder viewHolder
     * @param position position
     */
    @Override
    public void onBindRecycleViewHolder(EasyRecyclerViewHolder viewHolder, int position) {
        int itemType = this.getRecycleViewItemType(position);
        EasyRecyclerViewData data = this.getItem(position);
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




## EasyRecyclerView

The the default configuration :  

1. *LayoutMannager* was **LinearLayoutManager**  
1. *ItemAnimator* was **DefaultItemAnimator** 


but you can modify it for your **LayoutManager** or **ItemAnimator**.

Just do this !

```Java
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
```

---

## Decoration

This library provides two decoration:

- **EasyDividerItemDecoration**

- **EasyBorderDividerItemDecoration**


---

## ScreenShots

**EasyDividerItemDecoration**  
<img src="http://ww3.sinaimg.cn/large/006lPEc9gw1f30w1rpvkbj31ay2987mo.jpg" width="420x">
   

  
**EasyBorderDividerItemDecoration**   
<img src="http://ww1.sinaimg.cn/large/006lPEc9gw1f30w33fe7gj31ay298gwy.jpg" width="420x">  

---

  

## License
  
  
      Copyright (C) 2015 CaMnter yuanyu.camnter@gmail.com
  
      Licensed under the Apache License, Version 2.0 (the "License");  
      you may not use this file except in compliance with the License.  
      You may obtain a copy of the License at  
  
         http://www.apache.org/licenses/LICENSE-2.0  
  
      Unless required by applicable law or agreed to in writing, software  
      distributed under the License is distributed on an "AS IS" BASIS,  
      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  
      See the License for the specific language governing permissions and  
      limitations under the License.  
 









