package t.s.com;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import t.s.com.appservice.IMyAidlInterface;
import t.s.com.desgin.DesignActivity;
import t.s.com.desgin.DrawerLayoutActivity;
import t.s.com.javaee.ProductList;
import t.s.com.javaee.ProductTwo;
import t.s.com.javaee.Productone;


public class MainActivity extends AppCompatActivity {
    private IMyAidlInterface maidl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ProductList productList=ProductList.getInstance();
        Productone pone=new Productone();
        ProductTwo ptwo=new ProductTwo();
        productList.addObserver(pone);
        productList.addObserver(ptwo);
        productList.addProuduct("新进产品");

    }


    @OnClick({R.id.one, R.id.two, R.id.three,R.id.aidls,R.id.detail})
    void onclick(View v) {
        switch (v.getId()) {
            case R.id.one:
                startActivity(new Intent(MainActivity.this, DrawerLayoutActivity.class));
                break;
            case R.id.two:
                startActivity(new Intent(MainActivity.this, DesignActivity.class));
                break;
            case R.id.three:
                startActivity(new Intent(MainActivity.this, DesignActivity.class));
                break;
            case R.id.aidls:
                buttonClick();
                break;
            case R.id.detail:
                if(maidl==null){
                    buttonClick();
                }else {
                    String sd="";
                    try {
                        sd=maidl.getMsg();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(MainActivity.this,"lll="+sd ,Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


    /**
     * 监听按钮点击
     * @param
     */
    public void buttonClick() {
        Log.i("tttt","buttonClick=");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("t.s.com.appservice", "t.s.com.appservice.MyService"));
        bindService(intent, conn, Context.BIND_AUTO_CREATE);

    }

    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceDisconnected(ComponentName name) {
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            maidl = IMyAidlInterface.Stub.asInterface(service);
            try {
                String pid = maidl.getMsg();
                Toast.makeText(MainActivity.this,"绑定成功" ,Toast.LENGTH_SHORT).show();
                maidl.basicTypes(12, 1332, true, 12.2f, 12.3, "测试测试");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            Log.i("tttt",maidl.toString());
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);
    }
}
