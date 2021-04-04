package org.xiaowu.service;

import org.xiaowu.service.model.UBaseInfo;

public interface UserRpcService {
    UBaseInfo getByName(String name);
}
