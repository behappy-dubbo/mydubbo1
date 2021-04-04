package org.xiaowu.dubbo.study.source.util;

import lombok.experimental.UtilityClass;
import org.xiaowu.dubbo.study.source.framework.register.Url;

import java.util.List;
import java.util.Random;

/**
 * 多个Url采用负载均衡（dubbo默认的random）
 */
@UtilityClass
public class LoadBalance {

    public Url random(List<Url> urls){
        Random random = new Random();
        return urls.get(random.nextInt(urls.size()));
    }
}
