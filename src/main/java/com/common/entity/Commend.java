package com.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Commend {

    private Integer id;
    private Integer userId;
    private String userName;
    private Integer skuId;
    private String commend;
    private String createTime;
    private String updateTime;

}
