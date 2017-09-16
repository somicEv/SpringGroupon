package com.common.vo;

import com.common.entity.Favorite;
import com.common.entity.deal.Deal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class FavoriteDTO {

    @Setter @Getter private Favorite favorite;

    @Setter @Getter private Deal deal;

}
