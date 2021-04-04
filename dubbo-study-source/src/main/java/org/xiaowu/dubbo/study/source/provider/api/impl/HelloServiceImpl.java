package org.xiaowu.dubbo.study.source.provider.api.impl;

import org.xiaowu.dubbo.study.source.provider.api.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello() {
        return "Hello";
    }
}
