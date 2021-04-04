package org.xiaowu.boot.meeting.service.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.xiaowu.boot.meeting.service.mapper.MeetingMapper;
import org.xiaowu.service.UserRpcService;
import org.xiaowu.service.model.MBaseInfo;
import org.xiaowu.service.model.UBaseInfo;

@Service
public class MeetingService extends ServiceImpl<MeetingMapper,MBaseInfo> {

    // 服务检查
    @Reference(version = "1.0.0",check = false)
    UserRpcService userRpcService;

    public MBaseInfo getByName(String name) {
        UBaseInfo info = userRpcService.getByName(name);
        MBaseInfo mBaseInfo = new MBaseInfo();
        mBaseInfo.setUser(info);
        return mBaseInfo;
    }
}
