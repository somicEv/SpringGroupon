package com.service.api;

import com.common.entity.area.Address;
import com.common.vo.QueryMessage;

import java.util.List;

public interface AddressService {

    QueryMessage<List<Address>> selectUserAddress(Long userId);

    Address selectUserAddressById(Long addressId);

    Integer saveUserAddress(Address address);
}
