package com.common.entity.area;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 地址
 */
@ToString
public class Address {

    @Getter @Setter private Long id;
    @Getter @Setter private Long userId;//地址归属用户ID
    @Getter @Setter private String receiver;//收货人
    @Getter @Setter private String area;//地区
    @Getter @Setter private String detail;//详细地址
    @Getter @Setter private AddressType addressType;//类型:家、公司
    @Getter @Setter private String phone;//联系电话
    @Getter @Setter private Date createTime;
    @Getter @Setter private Date updateTime;

}
