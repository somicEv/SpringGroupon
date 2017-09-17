package com.helper;

import com.common.entity.Cart;
import com.common.entity.Image;
import com.common.entity.deal.Deal;
import com.dao.ImageDao;
import com.service.api.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class ImageHelper extends BaseHelper {

    @Autowired
    ImageDao imageDao;

    @Autowired
    DealService dealService;

    /**
     * 获取商品列表图片Url
     *
     * TODO 修改为私有方法 修改前端页面上使用的方法 DATE: 2017-9-10
     *
     * @param deal 商品信息
     * @return 图片url地址
     */
    public String getDealImageUrlForIndexDealList(Deal deal) {
        Image image = new Image();
        image.setId(deal.getImageId().intValue());
        List<Image> imageList = imageDao.getImage(image);
        System.out.println(imageList.size());
        if (imageList != null && imageList.size() > 0) {
            System.out.println(imageList.get(0).getSourcePath());
            return imageList.get(0).getSourcePath();
        }
        return "images/blank.gif";
    }

    /**
     * 获取购物车列表图片Url
     *
     * @param cart 购物车信息
     * @return 图片url地址
     */
    public String getDealImageUrlForDealCart(Cart cart) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("skuId", cart.getDealSkuId());
            params.put("nowTime", new Date());
            Deal dealBySkuId = dealService.getDealBySkuId(params);
            if (dealBySkuId == null) {
                return "images/blank.gif";
            }
            return getDealImageUrlForIndexDealList(dealBySkuId);
        } catch (Exception e) {
            return "images/blank.gif";
        }
    }

    public String getUserOrderImageUrl(Integer imageId){
        Image image = new Image();
        image.setId(imageId);
        List<Image> imageList = imageDao.getImage(image);
        System.out.println(imageList.size());
        if (imageList != null && imageList.size() > 0) {
            System.out.println(imageList.get(0).getSourcePath());
            return imageList.get(0).getSourcePath();
        }
        return "images/blank.gif";
    }


}
