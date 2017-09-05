package com.controller.site;

import com.common.entity.area.Area;
import com.service.business.AreaBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/area")
public class AreaController {

	@Autowired
	private AreaBusiness areaBusiness;

	@RequestMapping(value = "/index")
	public String index(Model model){
		Map<String, List<Area>> areaGroup = areaBusiness.getAreaGroup();
		model.addAttribute("areas",areaGroup);
		return "/area/area";
	}

}
