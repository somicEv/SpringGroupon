package com.helper;

import com.common.entity.deal.Deal;
import com.common.entity.Image;
import com.database.ImageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ImageHelper extends BaseHelper{

	@Autowired
	private ImageDao imageDao;

	public String getDealImageUrlForIndexDealList(Deal deal){
		Image image = new Image();
		image.setId(deal.getImageId().intValue());
		List<Image> imageList = imageDao.getImage(image);
		System.out.println(imageList.size());
		if (imageList != null && imageList.size() > 0){
			return imageList.get(0).getSourcePath();
		}
		return "images/blank.gif";
	}

}
