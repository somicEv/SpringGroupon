package com.service.business;

import com.common.entity.StartRemind;
import com.service.api.StartRemindService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StartRemindBusiness {

    @Autowired
    StartRemindService startRemindService;

    public Integer save(StartRemind startRemind){
        Integer saveResult = 0;
        try{
            saveResult = startRemindService.save(startRemind);
        }catch (Exception e){
            log.error("添加开团提醒失败",e);
            return saveResult;
        }
        System.out.println("添加结果为：-------"+saveResult);
        return saveResult;
    }

    public boolean checkExist(StartRemind startRemind){
        StartRemind result = startRemindService.checkExist(startRemind);
        if(result != null){
            return false;
        }
        return true;
    }
}
