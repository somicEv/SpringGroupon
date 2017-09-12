package com.service.business;

import com.common.entity.area.Address;
import com.common.entity.area.Area;
import com.common.entity.area.AreaType;
import com.common.entity.user.WebUser;
import com.service.api.AddressService;
import com.service.api.AreaService;
import com.util.Pinyin4jUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AreaBusiness {

    @Autowired
    AreaService areaService;

    @Autowired
    AddressService addressService;

    /**
     * 获得按地名首字母分组的地名信息(不包括省一级)
     *
     * @return
     */
    public Map<String, List<Area>> getAreaGroup() {
        List<Area> areaList = areaService.getAllArea();
        Map<String, List<Area>> group = new TreeMap<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
        for (Area area : areaList) {
            if (AreaType.CITY.name().equals(area.getType().name())) {
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

    /**
     * 根据名称获取Area对象
     * @param name
     * @return
     */
    public Area getByName(String name) {
        Area area = new Area();
        area.setName(name);
        return areaService.getArea(area);
    }

    /**
     * 根据登录用户信息查询收货地址
     * @param webUser
     * @return
     */
    public Address selectUserAddress(WebUser webUser){

        addressService.selectUserAddress(webUser.getUserId());
        return null;
    }

}
