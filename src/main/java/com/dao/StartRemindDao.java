package com.dao;

import com.common.entity.StartRemind;
import org.springframework.stereotype.Repository;

@Repository
public interface StartRemindDao {

    Integer save(StartRemind startRemind);

}
