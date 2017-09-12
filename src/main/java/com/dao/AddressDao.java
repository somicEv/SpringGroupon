package com.dao;

import com.common.entity.area.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressDao {

    List<Address> selectAddressDetail(Long userId);

}
