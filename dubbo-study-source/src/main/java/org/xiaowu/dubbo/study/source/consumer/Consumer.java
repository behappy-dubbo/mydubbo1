package org.xiaowu.dubbo.study.source.consumer;

import org.xiaowu.dubbo.study.source.framework.proxy.ProxyFactory;
import org.xiaowu.dubbo.study.source.provider.api.HelloService;

public class Consumer {

    public static void main(String[] args) {
        // 获取helloservice的代理对象
        HelloService service = ProxyFactory.getProxy(HelloService.class);
        // 调用sayhello方法
        System.out.println(service.sayHello());
    }
}
