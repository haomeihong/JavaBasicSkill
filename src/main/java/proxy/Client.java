package proxy;

import java.lang.reflect.Proxy;

/**
 * Created by wangxiaomin03 on 17/7/28.
 */
public class Client {
    public static void main(String[] arg) {
        Delegate delegate = new Delegate();

        LogInvocationHandler logInvocationHandler = new LogInvocationHandler(delegate);
        LogInvocationHandler logInvocationHandler1 = new LogInvocationHandler(delegate) {
            @Override
            public void log() {
                System.out.println("you can't do it");
            }
        };
        Object proxy = Proxy.newProxyInstance(delegate.getClass().getClassLoader(), new Class<?>[]{HasName.class, HasValue.class, Log.class}, logInvocationHandler);
        Object proxy1 = Proxy.newProxyInstance(delegate.getClass().getClassLoader(), new Class<?>[]{HasName.class, HasValue.class, Log.class}, logInvocationHandler1);
        System.out.println(((HasName) proxy).callName());
        System.out.println(((HasValue) proxy).callValue());
        ((Log) proxy).log();
        ((Log) proxy1).log();


    }

}
