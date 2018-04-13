package com.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Newspaper {

    private Integer id;
    private String newsTitle;
    private Integer imageId;
    private String contentUrl;
    private String desc;
    private String createTime;
    private String updateTime;

}
