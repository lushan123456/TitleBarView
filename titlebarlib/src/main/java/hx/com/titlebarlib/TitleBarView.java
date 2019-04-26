package hx.com.titlebarlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created on lushan
 * Created date 2019/4/26 10:54
 */
public class TitleBarView extends RelativeLayout{
    private LinearLayout layout_left, layout_right;
    private TextView tv_left, tv_title, tv_right;
    private ImageView iv_left, iv_right;
    private onViewClick mClick;

    public TitleBarView(Context context) {
        this(context,null);
    }

    public TitleBarView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TitleBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.layout_titlebar, this);
        tv_left = findViewById(R.id.tv_left);
        tv_title = findViewById(R.id.tv_title);
        tv_right = findViewById(R.id.tv_right);
        iv_left = findViewById(R.id.iv_left);
        iv_right = findViewById(R.id.iv_right);
        layout_left = findViewById(R.id.layout_left);
        layout_right = findViewById(R.id.layout_right);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.TitlebarView, defStyleAttr, 0);
        tv_left.setTextColor(array.getColor(R.styleable.TitlebarView_leftTextColor,Color.parseColor("#ffffff")));
        tv_left.setText(array.getString(R.styleable.TitlebarView_leftText));

        iv_left.setImageResource(array.getResourceId(R.styleable.TitlebarView_leftDrawble,R.mipmap.icon_menu_back));
        tv_title.setTextColor(array.getColor(R.styleable.TitlebarView_centerTextColor,Color.parseColor("#ffffff")));
        tv_title.setText(array.getString(R.styleable.TitlebarView_centerTitle));

        iv_right.setImageResource(array.getResourceId(R.styleable.TitlebarView_rightDrawable,0));
        tv_right.setText(array.getString(R.styleable.TitlebarView_rightText));
        tv_right.setTextColor(array.getColor(R.styleable.TitlebarView_rightTextColor,Color.parseColor("#ffffff")));
        array.recycle();
        layout_left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mClick != null){
                    mClick.leftClick();
                }
            }
        });
        layout_right.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mClick != null){
                    mClick.rightClick();
                }
            }
        });
    }
    //左右点击事件
    public void setmClick(onViewClick mClick) {
        this.mClick = mClick;
    }

    public void setLeftImg(int drawable){
        iv_left.setImageResource(drawable);
    }

    public void setRightImg(int drawable){
        iv_right.setImageResource(drawable);
    }

    public void setLeftText(String text){
        tv_left.setText(text);
    }

    public void setLeftTextColor(int color){
        tv_left.setTextColor(color);
    }

    public void setLeftTextSize(float demines){
        tv_left.setTextSize(TypedValue.COMPLEX_UNIT_SP,demines);
    }


    public void setCenterText(String text){
        tv_title.setText(text);
    }

    public void setCenterTextColor(int color){
        tv_title.setTextColor(color);
    }

    public void setCenterTextSize(float demines){
        tv_title.setTextSize(TypedValue.COMPLEX_UNIT_SP,demines);
    }

    public void setRightText(String text){
        tv_right.setText(text);
    }

    public void setRightTextColor(int color){
        tv_right.setTextColor(color);
    }

    public void setRightTextSize(float demines){
        tv_right.setTextSize(TypedValue.COMPLEX_UNIT_SP,demines);
    }



    public interface onViewClick {
        void leftClick();
        void rightClick();
    }

}
