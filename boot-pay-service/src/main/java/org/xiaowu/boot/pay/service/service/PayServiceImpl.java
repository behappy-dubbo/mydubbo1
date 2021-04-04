package org.xiaowu.boot.pay.service.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.xiaowu.service.PayService;

@org.springframework.stereotype.Service
@Service(interfaceClass = PayService.class,loadbalance = "roundrobin")
public class PayServiceImpl implements PayService {

    @Autowired
    Environment environment;

    public String pay(String name) {
        // 测试负载均衡
        System.out.println(environment.getProperty("server.port")+" 端口被调用");
        return name+"：剩余金额100元";
    }
}
