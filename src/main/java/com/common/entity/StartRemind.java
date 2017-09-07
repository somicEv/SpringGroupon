package com.common.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 开团提醒
 */
public class StartRemind  {
    @Getter @Setter private Integer id;
    @Getter @Setter private Long userId;
    @Getter @Setter private Long dealId;
    @Getter @Setter private Long dealSkuId;
    @Getter @Setter private String dealTitle;
    @Getter @Setter private Date startTime;
    @Getter @Setter private Date createTime;
    @Getter @Setter private Date updateTime;

}
