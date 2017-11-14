package t.s.com.javaee;

import android.util.Log;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Administrator on 2017/11/1.
 */

public class ProductTwo implements Observer{
    @Override
    public void update(Observable observable, Object o) {
        String newProduct=(String) o;
        Log.i("Observable","发送新产品2="+newProduct);
    }
}
