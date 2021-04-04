package org.xiaowu.boot.meeting.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.xiaowu.service.model.MBaseInfo;

@Mapper
public interface MeetingMapper extends BaseMapper<MBaseInfo> {
}
