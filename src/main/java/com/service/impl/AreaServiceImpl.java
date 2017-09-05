package com.service.impl;

import com.common.entity.area.Area;
import com.dao.AreaDao;
import com.service.api.Areaapi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AreaServiceImpl implements Areaapi{

	@Autowired
	private AreaDao areaDao;

	@Override
	public Area getArea(Area area) {
		List<Area> areaList = areaDao.getArea(area);
		if(areaList != null && areaList.size() != 0){
			return areaList.get(0);
		}
		return new Area();
	}

	@Override
	public List<Area> getAllArea(){
		List<Area> areaList = areaDao.getArea(new Area());
		if (areaList != null && areaList.size() != 0){
			return areaList;
		}
		return new ArrayList<>();
	}


}
