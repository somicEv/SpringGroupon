package com.service.api;

import com.common.vo.QueryMessage;

public interface AddressService {

    QueryMessage selectUserAddress(Long userId);

}
