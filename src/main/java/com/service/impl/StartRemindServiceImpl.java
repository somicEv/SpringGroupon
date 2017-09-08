package com.service.impl;

import com.common.entity.StartRemind;
import com.dao.StartRemindDao;
import com.service.api.StartRemindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StartRemindServiceImpl implements StartRemindService{

    @Autowired
    StartRemindDao startRemindDao;

    @Override
    public Integer save(StartRemind startRemind) {
        return startRemindDao.save(startRemind);
    }

    @Override
    public StartRemind checkExist(StartRemind startRemind) {
        return startRemindDao.checkExist(startRemind);
    }
}
