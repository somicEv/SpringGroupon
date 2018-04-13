package com.common.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SearchDTO {

    private Integer id;
    private String keyName;
    private String resultUrl;
    private String resultDesc;
    private Integer imageId;

}
