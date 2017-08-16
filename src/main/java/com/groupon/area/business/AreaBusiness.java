package com.groupon.area.business;

import com.common.entity.area.Area;
import com.common.entity.area.AreaType;
import com.groupon.area.service.AreaService;
import com.util.Pinyin4jUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AreaBusiness {

	@Autowired
	private AreaService areaService;

	// 获得按地名首字母分组的地名信息(不包括省一级)
	public Map<String, List<Area>> getAreaGroup() {
		List<Area> areaList = areaService.getAllArea();
		Map<String, List<Area>> group = new TreeMap<>(new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				return o1.toString().compareTo(o2.toString());
			}
		});
		for (Area area : areaList){
			if (AreaType.CITY.name().equals(area.getType().name())){
				String spell = Pinyin4jUtil.converterToFirstSpell(area.getName());
				String key = String.valueOf(spell.toUpperCase().charAt(0));
				if (!group.containsKey(key)) {
					group.put(key, new ArrayList<Area>());
				}
				group.get(key).add(area);
			}
		}
		return group;
	}

	public Area getByName(String name){
		Area area = new Area();
		area.setName(name);
		Area resutlArea = areaService.getArea(area);
		return resutlArea;
	}

}
