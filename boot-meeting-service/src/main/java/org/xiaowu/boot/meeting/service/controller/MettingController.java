package org.xiaowu.boot.meeting.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.xiaowu.boot.meeting.service.service.MeetingService;
import org.xiaowu.service.model.MBaseInfo;

@RestController
public class MettingController {

    @Autowired
    MeetingService meetingService;

    @GetMapping("/meeting/{name}")
    public MBaseInfo test(@PathVariable String name){

        MBaseInfo mBaseInfo = meetingService.getByName(name);

        return mBaseInfo;
    }
}
