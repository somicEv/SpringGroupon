package com.common.entity;

import com.common.entity.deal.Deal;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class NewArrival {

    private Deal[] deals;


}
