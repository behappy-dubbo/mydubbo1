package org.xiaowu.dubbo.study.source.framework.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 注册服务接口
 */
public class LocalRegister {

    private static Map<String, Class> map = new ConcurrentHashMap<>();

    public static void register(String interfaceName,Class implClass){
        map.put(interfaceName,implClass);
    }

    public static Class get(String interfaceName){
        return map.get(interfaceName);
    }
}
