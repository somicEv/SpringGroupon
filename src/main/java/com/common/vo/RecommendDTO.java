package com.common.vo;

import com.common.entity.Recommend;
import com.common.entity.deal.Deal;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RecommendDTO {

    private Recommend recommend;
    private Deal deal;

}
