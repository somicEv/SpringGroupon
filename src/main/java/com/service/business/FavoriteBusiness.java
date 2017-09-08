package com.service.business;

import com.common.entity.Favorite;
import com.service.api.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteBusiness {

    @Autowired
    private FavoriteService favoriteService;

    public boolean checkExist(Favorite favorite){
        Favorite result = favoriteService.checkExist(favorite);
        if(result != null){
            // 说明存在
            return false;
        }
        return true;
    }

    public Integer saveResult(Favorite favorite){
        return favoriteService.save(favorite);
    }

}
