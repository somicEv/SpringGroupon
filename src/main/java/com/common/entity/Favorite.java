package com.common.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 收藏
 */
@Data
public class Favorite {

    private Long id;
    private Long userId;
    private Long dealId;
    private Long dealSkuId;
    private Date createTime;
    private Date updateTime;

}
