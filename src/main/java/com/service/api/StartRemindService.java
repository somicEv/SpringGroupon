package com.service.api;

import com.common.entity.StartRemind;

public interface StartRemindService {

    Integer save(StartRemind startRemind);

    StartRemind checkExist(StartRemind startRemind);
}
