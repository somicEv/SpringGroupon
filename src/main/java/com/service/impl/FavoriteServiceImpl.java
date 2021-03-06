package com.service.impl;

import com.common.entity.Favorite;
import com.dao.FavoriteDao;
import com.service.api.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService{

    @Autowired
    private FavoriteDao favoriteDao;

    @Override
    public Integer save(Favorite favorite) {
        return favoriteDao.save(favorite);
    }

    @Override
    public Favorite checkExist(Favorite favorite) {
       return favoriteDao.checkExist(favorite);
    }

    @Override
    public List<Favorite> selectFavoriteList(Favorite favorite) {
        return favoriteDao.selectFavoriteList(favorite);
    }

    @Override
    public Integer deleteFavorite(Favorite favorite) {
        return favoriteDao.deleteFavorite(favorite);
    }
}
