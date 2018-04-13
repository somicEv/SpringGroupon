package com.service.business;

import com.common.constant.CartConstant;
import com.common.constant.GlobalConstant;
import com.common.entity.Favorite;
import com.common.entity.deal.Deal;
import com.common.entity.user.WebUser;
import com.common.vo.FavoriteDTO;
import com.common.vo.QueryMessage;
import com.service.api.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FavoriteBusiness {

    @Autowired
    private FavoriteService favoriteService;

    /**
     * 检查是否已经存在形同的商品
     *
     * @param favorite 用户Favorite
     * @return
     */
    public boolean checkExist(Favorite favorite) {
        Favorite result = favoriteService.checkExist(favorite);
        if (result != null) {
            // 说明存在
            return false;
        }
        return true;
    }

    /**
     * 添加喜欢
     *
     * @param favorite
     * @return
     */
    public Integer saveResult(Favorite favorite) {
        return favoriteService.save(favorite);
    }

    /**
     * 查询用户的喜欢列表
     *
     * @param webUser
     * @return
     */
    public List<Favorite> selectFavoriteList(WebUser webUser) {
        Favorite favorite = new Favorite();
        favorite.setUserId(webUser.getUserId());
        return favoriteService.selectFavoriteList(favorite);
    }

    /**
     * 删除用户收藏
     * @param userId
     * @param skuId
     * @return
     */
    public QueryMessage deleteFavorite(Long userId,Long skuId) {
        Favorite favorite = new Favorite();
        favorite.setUserId(userId);
        favorite.setDealSkuId(skuId);
        Integer result = favoriteService.deleteFavorite(favorite);
        if (result != 1) {
            // 删除出错
            return new QueryMessage(GlobalConstant.QUERY_RESULT_ERROR, CartConstant.ERROR);
        }
        return new QueryMessage(GlobalConstant.QUERY_RESULT_OK, CartConstant.SUCCESS);
    }

    public List<Long> selectDealIdsFromFavoriteList(List<Favorite> list){
        List<Long> resultList = new ArrayList<>();
        for (Favorite favorite : list){
            resultList.add(favorite.getDealId());
        }
        return resultList;
    }

    public List<FavoriteDTO> createFavoriteDtoList(List<Favorite> favoriteList, List<Deal> dealList){
        Map<Long, Deal> params = new HashMap<>();
        for (Deal deal : dealList){
            params.put(deal.getId(), deal);
        }
        List<FavoriteDTO> resultList = new ArrayList<>();
        for (Favorite favorite : favoriteList){
            resultList.add(new FavoriteDTO(favorite, params.get(favorite.getDealId())));
        }
        return resultList;
    }

}
