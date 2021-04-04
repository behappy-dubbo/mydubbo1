package org.xiaowu.dubbo.study.source.framework.protocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.xiaowu.dubbo.study.source.framework.register.LocalRegister;

import java.lang.reflect.Method;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 接收到请求，处理请求
        Invocation invocation = (Invocation) msg;
        Class aClass = LocalRegister.get(invocation.getInterfaceName());
        // 利用反射执行方法得到res
        Method method = aClass.getMethod(invocation.getMethodName(), invocation.getParamTypes());
        Object res = method.invoke(aClass.newInstance(), invocation.getParams());
        // 写回netty，让client端监听到
        ctx.writeAndFlush("Netty: "+res);
    }
}
