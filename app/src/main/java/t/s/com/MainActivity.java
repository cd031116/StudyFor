package t.s.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import t.s.com.desgin.DesignActivity;
import t.s.com.desgin.DrawerLayoutActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.one,R.id.two})
    void onclick(View v){
        switch (v.getId()){
            case R.id.one:
            startActivity(new Intent(MainActivity.this,DrawerLayoutActivity.class));
                break;
            case R.id.two:
                startActivity(new Intent(MainActivity.this,DesignActivity.class));
                break;
        }
    }



}
