package org.xiaowu.dubbo.study.source.provider;

import org.xiaowu.dubbo.study.source.framework.protocol.NettyServer;
import org.xiaowu.dubbo.study.source.framework.register.LocalRegister;
import org.xiaowu.dubbo.study.source.framework.register.RedisRegister;
import org.xiaowu.dubbo.study.source.framework.register.Url;
import org.xiaowu.dubbo.study.source.provider.api.HelloService;
import org.xiaowu.dubbo.study.source.provider.api.impl.HelloServiceImpl;

import java.io.IOException;
import java.net.InetAddress;

public class Provider {

    public static void main(String[] args) throws IOException {
        // 注册服务接口
        LocalRegister.register(HelloService.class.getName(), HelloServiceImpl.class);
        Url url = new Url(InetAddress.getLocalHost().getHostAddress(), 8080);
        // 注册服务器信息，端口，ip
        RedisRegister.regist(HelloService.class.getName(),url);
        // 启动
        NettyServer.start(url.getHostName(),url.getPort());
    }
}
