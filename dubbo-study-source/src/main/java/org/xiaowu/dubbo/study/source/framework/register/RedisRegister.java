package org.xiaowu.dubbo.study.source.framework.register;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import lombok.experimental.UtilityClass;
import org.xiaowu.dubbo.study.source.util.LoadBalance;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class RedisRegister {

    static Jedis jedis;

    static {
        jedis = new Jedis("127.0.0.1", 6379);
    }
    // 注册服务
    public void regist(String interfaceName, Url url){
        try {
            String s = jedis.get(interfaceName);
            List<Url> urls = null;
            if (s == null){
                urls = new ArrayList<>();
            }else {
                JSONArray objects = JSONUtil.parseArray(s);
                urls = objects.toList(Url.class);
            }
            urls.add(url);
            jedis.set(interfaceName,JSONUtil.toJsonStr(urls));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Url get(String interfaceName) throws Exception{
        String s = jedis.get(interfaceName);
        JSONArray objects = JSONUtil.parseArray(s);
        List<Url> urls = objects.toList(Url.class);
        return LoadBalance.random(urls);
    }
}
