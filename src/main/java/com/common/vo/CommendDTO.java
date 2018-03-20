package com.common.vo;

import com.common.entity.Commend;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class CommendDTO {

    private List<Commend> commends;

}
