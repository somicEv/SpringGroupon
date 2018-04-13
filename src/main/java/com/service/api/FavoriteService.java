package com.service.api;

import com.common.entity.Favorite;

import java.util.List;

public interface FavoriteService {

    Integer save(Favorite favorite);

    Favorite checkExist(Favorite favorite);

    List<Favorite> selectFavoriteList(Favorite favorite);

    Integer deleteFavorite(Favorite favorite);
}
