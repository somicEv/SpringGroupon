package com.dao;

import com.common.entity.Favorite;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteDao {

    Integer save(Favorite favorite);

    Favorite checkExist(Favorite favorite);

}
