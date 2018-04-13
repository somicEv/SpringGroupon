package com.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class Commend {

    private Integer id;
    private Integer userId;
    private String userName;
    private Integer skuId;
    private String commend;
    private Integer rate;
    private Date createTime;
    private Date updateTime;

}
