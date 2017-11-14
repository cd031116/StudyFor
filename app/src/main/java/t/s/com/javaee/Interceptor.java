package t.s.com.javaee;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/11/1.
 */

public interface Interceptor{
    boolean before(Object proxy, Object target, Method method,Object[] args);
    void around(Object proxy, Object target, Method method,Object[] args);
    void after(Object proxy, Object target, Method method,Object[] args);


}
