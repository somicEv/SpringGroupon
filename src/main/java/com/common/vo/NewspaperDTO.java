package com.common.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class NewspaperDTO {

    private Integer id;
    private String newsTitle;
    private Integer imageId;
    private String contentUrl;
    private String newsDesc;

}
