package com.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Search {

    private Integer id;
    private String keyName;
    private String resultUrl;
    private String resultDesc;
    private Integer imageId;
    private String createTime;
    private String updateTime;

}
