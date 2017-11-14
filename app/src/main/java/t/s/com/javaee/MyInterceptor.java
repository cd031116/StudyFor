package t.s.com.javaee;

import android.util.Log;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/11/1.
 */

public class MyInterceptor implements Interceptor{
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        Log.i("before","反射方法前逻辑");
        return false;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {
        Log.i("before","取代了被代理对象的方法");
    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        Log.i("before","反射方法后逻辑");
    }
}
