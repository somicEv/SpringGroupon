package com.dao;

import com.common.entity.area.Area;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaDao {

	List<Area> getArea(Area area);

}
