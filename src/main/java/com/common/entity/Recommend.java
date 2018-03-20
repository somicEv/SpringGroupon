package com.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Recommend {

    private Integer id;
    private String recommendName;
    private Integer seq;
    private Integer skuId;
    private String upTime;
    private String downTime;
    private String recommendDesc;

}
