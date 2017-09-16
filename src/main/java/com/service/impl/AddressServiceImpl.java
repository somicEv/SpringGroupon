package com.service.impl;

import com.common.constant.CartConstant;
import com.common.constant.GlobalConstant;
import com.common.entity.area.Address;
import com.common.vo.QueryMessage;
import com.dao.AddressDao;
import com.service.api.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressDao addressDao;

    @Override
    public QueryMessage<List<Address>> selectUserAddress(Long userId) {
        try {
            List<Address> addressList = addressDao.selectAddressDetail(userId);
            return new QueryMessage<>(GlobalConstant.QUERY_RESULT_OK, CartConstant.SUCCESS, addressList);
        } catch (Exception e) {
            return new QueryMessage<>(GlobalConstant.QUERY_RESULT_ERROR, CartConstant.ERROR);
        }
    }

    @Override
    public Address selectUserAddressById(Long addressId) {
        return addressDao.selectUserById(addressId);
    }

    @Override
    public Integer saveUserAddress(Address address) {
        return addressDao.saveUserAddress(address);
    }
}
