package org.xiaowu.dubbo.study.source.util;

import lombok.experimental.UtilityClass;

import java.util.Collection;

@UtilityClass
public class CollectionUtils {

    public boolean isEmpty(Collection collection){
        if (collection == null || collection.isEmpty()){
            return true;
        }
        return false;
    }
}
