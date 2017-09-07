package com.service.api;

import com.common.entity.Favorite;

public interface FavoriteService {

    Integer save(Favorite favorite);

    Favorite checkExist(Favorite favorite);

}
