package hx.com.mytitlebar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import hx.com.titlebarlib.TitleBarView;

/**
 * Created on lushan
 * Created date 2019/4/26 10:53
 */
public class TitleBarActivity extends AppCompatActivity{

    private TitleBarView titleView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_titlebar);

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
    }
}
