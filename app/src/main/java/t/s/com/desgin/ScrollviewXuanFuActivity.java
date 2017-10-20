package t.s.com.desgin;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import t.s.com.R;
import t.s.com.wogdet.MyScroview;

public class ScrollviewXuanFuActivity extends AppCompatActivity implements MyScroview.OnScrollListener {
    @Bind(R.id.myscroview)
    MyScroview myscroview;
    @Bind(R.id.main_tab2)
    LinearLayout main_tab2;// 在MyScrollView里面的购买布局
    @Bind(R.id.main_tab1)
    LinearLayout main_tab1;

    @Bind(R.id.banner)
    Banner banner;
    @Bind(R.id.tab_mian)
    LinearLayout tab_mian;

    @Bind(R.id.tab1_t)
    TextView tab1_t;
    @Bind(R.id.tab1_v)
    TextView tab1_v;
    @Bind(R.id.tab2_t)
    TextView tab2_t;
    @Bind(R.id.tab2_v)
    TextView tab2_v;
    @Bind(R.id.tab3_t)
    TextView tab3_t;
    @Bind(R.id.tab3_v)
    TextView tab3_v;
    private int select = 1;
    private int topHeight;
    private List<String> titles = new ArrayList<>();
    private List<String> images = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollview_xuan_fu);
    }

    @Override
    public void onResume() {
        super.onResume();
        changeview(select);
        initview( );
    }

    private void initview( ){
        images.add("http://img.taodiantong.cn/v55183/infoimg/2013-07/130720115322ky.jpg");
        images.add("http://pic30.nipic.com/20130626/8174275_085522448172_2.jpg");
        images.add("http://pic18.nipic.com/20111215/577405_080531548148_2.jpg");
        images.add("http://pic15.nipic.com/20110722/2912365_092519919000_2.jpg");
        images.add("http://pic.58pic.com/58pic/12/64/27/55U58PICrdX.jpg");
        setBanner();

    }
    private void changeview(int index) {
        tab1_t.setTextColor(Color.parseColor("#333333"));
        tab2_t.setTextColor(Color.parseColor("#333333"));
        tab3_t.setTextColor(Color.parseColor("#333333"));
        tab1_v.setSelected(false);
        tab2_v.setSelected(false);
        tab3_v.setSelected(false);
        if (index == 1) {
            tab1_t.setTextColor(Color.parseColor("#59c2de"));
            tab1_v.setSelected(true);
        } else if (index == 2) {
            tab2_t.setTextColor(Color.parseColor("#59c2de"));
            tab2_v.setSelected(true);
        } else {
            tab3_t.setTextColor(Color.parseColor("#59c2de"));
            tab3_v.setSelected(true);
        }
    }

    @OnClick({R.id.top_left, R.id.image, R.id.tab1_mian, R.id.tab2_mian, R.id.tab3_mian})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.top_left:
                break;
            case R.id.image:

                break;
            case R.id.tab1_mian:
                select = 1;
                changeview(select);
                break;
            case R.id.tab2_mian:
                select = 2;
                changeview(select);
                break;
            case R.id.tab3_mian:
                select = 3;
                changeview(select);
                break;

        }
    }
    //一定是在此方法中获取布局的实际高度
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            topHeight = main_tab2.getBottom() - main_tab1.getHeight();
        }
    }
    //滑动距离判断
    @Override
    public void onScroll(int scrollY) {
        if (scrollY >= topHeight) {
            if (tab_mian.getParent() != main_tab1) {
                main_tab2.removeView(tab_mian);
                main_tab1.addView(tab_mian);
            }
        } else {
            if (tab_mian.getParent() != main_tab2) {
                main_tab1.removeView(tab_mian);
                main_tab2.addView(tab_mian);
            }
        }
    }
    private void setBanner() {
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Default);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(2500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {

            }
        });
    }
}
