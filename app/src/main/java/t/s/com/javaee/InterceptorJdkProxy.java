package t.s.com.javaee;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2017/11/1.
 */

public class InterceptorJdkProxy implements InvocationHandler{
    private Object target;
    private String interceptorClass=null;

    public InterceptorJdkProxy(Object target,String interceptorClass){
        this.target=target;
        this.interceptorClass=interceptorClass;
    }

    public static Object bind(Object target,String interceptorClass){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),new InterceptorJdkProxy(target,interceptorClass));
    }


    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        if(interceptorClass==null){
            return method.invoke(target,objects);
        }
        Object object=null;
        Interceptor interceptor=(Interceptor)Class.forName(interceptorClass).newInstance();
        if(interceptor.before(o,target,method,objects)){
            return method.invoke(target,objects);
        }else {
            interceptor.around(o,target,method,objects);
        }
        interceptor.after(o,target,method,objects);
        return object;
    }
}
