package t.s.com.desgin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import t.s.com.R;

public class DesignActivity extends AppCompatActivity {
    @Bind(R.id.banner)
    Banner banner;
    private List<String> titles = new ArrayList<>();
    private List<String> images = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);
        ButterKnife.bind(this);
        initview();
    }


    private void initview( ){
        images.add("http://img.taodiantong.cn/v55183/infoimg/2013-07/130720115322ky.jpg");
        images.add("http://pic30.nipic.com/20130626/8174275_085522448172_2.jpg");
        images.add("http://pic18.nipic.com/20111215/577405_080531548148_2.jpg");
        images.add("http://pic15.nipic.com/20110722/2912365_092519919000_2.jpg");
        images.add("http://pic.58pic.com/58pic/12/64/27/55U58PICrdX.jpg");
        setBanner();

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
//    private void changeFrament(Fragment fragment, Bundle bundle, String tag){
//        FragmentTransaction fg = getSupportFragmentManager().beginTransaction();
//        fg.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//        fragment.setArguments(bundle);
//        fg.replace(R.id.f_content, fragment, tag);
////      fg.addToBackStack(tag);
//        fg.commit();
//    }


}
