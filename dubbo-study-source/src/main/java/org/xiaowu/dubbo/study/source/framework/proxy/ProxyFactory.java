package org.xiaowu.dubbo.study.source.framework.proxy;

import org.xiaowu.dubbo.study.source.framework.protocol.Invocation;
import org.xiaowu.dubbo.study.source.framework.register.RedisRegister;
import org.xiaowu.dubbo.study.source.framework.register.Url;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;
import static org.xiaowu.dubbo.study.source.framework.protocol.NettyClient.clientHandler;
import static org.xiaowu.dubbo.study.source.framework.protocol.NettyClient.initClient;

public class ProxyFactory {

    final static ExecutorService executorService = newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    /**
     * 编写方法，使用代理模式，获取一个代理对象
     */
    public static <T> T getProxy(final Class<T> interfaceClass) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(), method.getParameterTypes(), args);
                if(clientHandler == null){
                    Url url = RedisRegister.get(interfaceClass.getName());
                    initClient(url.getHostName(),url.getPort());
                }
                clientHandler.setInvocation(invocation);
                return executorService.submit(clientHandler).get();
            }
        });
    }
}
