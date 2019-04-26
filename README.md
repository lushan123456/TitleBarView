
# TitleBarView
构建：
```
allprojects {
    repositories {
        maven { url 'https://www.jitpack.io' }
    }
}

dependencies {
    ...
    implementation 'com.github.lushan123456:MyTitleBar:0.0.1'
}
```
实例：
![Alt text](https://github.com/lushan123456/TitleBarView/blob/master/ScreenShots/www.png)

用法：
```
     <hx.com.titlebarlib.TitleBarView
        android:id="@+id/titleView"
        android:layout_width="match_parent"
        android:layout_height="44dp"
        app:centerTextColor="#ffffff"
        app:centerTitle="中间"
        app:leftDrawble="@mipmap/icon_menu_back"
        app:leftText="左边"
        app:leftTextColor="#ffffff"
        app:rightDrawable="@mipmap/icon_search"
        app:rightText="右边"
        app:rightTextColor="#ffffff"
        ></hx.com.titlebarlib.TitleBarView>
```

```
        titleView = findViewById(R.id.titleView);
        titleView.setCenterTextSize(16);
        titleView.setmClick(new TitleBarView.onViewClick() {
            @Override
            public void leftClick() {
                Toast.makeText(TitleBarActivity.this,"左边点击",Toast.LENGTH_LONG).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(TitleBarActivity.this,"右边点击",Toast.LENGTH_LONG).show();
            }
        });
 ```
