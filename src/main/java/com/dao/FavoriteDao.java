package com.dao;

import com.common.entity.Favorite;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteDao {

    Integer save(Favorite favorite);

    Favorite checkExist(Favorite favorite);

    List<Favorite> selectFavoriteList(Favorite favorite);

    Favorite selectFavorite(Favorite favorite);

}
