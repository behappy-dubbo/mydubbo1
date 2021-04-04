package org.xiaowu.boot.user.service.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.xiaowu.boot.user.service.mapper.UBaseInfoMapper;
import org.xiaowu.service.PayService;
import org.xiaowu.service.model.UBaseInfo;
import org.xiaowu.service.UserRpcService;

@org.springframework.stereotype.Service
@Service(version = "1.0.0")
public class UserServiceImpl extends ServiceImpl<UBaseInfoMapper,UBaseInfo> implements UserRpcService {

    @Reference(check = false,loadbalance = "roundrobin")
    PayService payService;

    @Override
    public UBaseInfo getByName(String name) {
        UBaseInfo uBaseInfo = this.baseMapper.selectOne(Wrappers.<UBaseInfo>query().lambda().eq(UBaseInfo::getUserName, name));
        String info = payService.pay(uBaseInfo.getUserName());
        uBaseInfo.setInfo(info);
        return uBaseInfo;
    }
}
