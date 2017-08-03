package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by wangxiaomin03 on 17/7/28.
 */
public class LogInvocationHandler implements InvocationHandler, Log {
    private Delegate delegate;

    public LogInvocationHandler(Delegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String mth = method.getName();
        if (mth.equals("log")) {
            this.log();
            System.out.println("after log::"+proxy.getClass().getName());
            return null;
        } else if (mth.equals("callName")) {
            System.out.println("call value first");
            if (proxy instanceof HasValue) {
                System.out.println(((HasValue) proxy).callValue());
            }
        }
        return method.invoke(delegate, args);
    }

    @Override
    public void log() {
        System.out.print("handler log......");
    }
}
