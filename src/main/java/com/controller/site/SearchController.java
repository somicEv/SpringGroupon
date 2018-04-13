package com.controller.site;

import com.common.vo.SearchDTO;
import com.service.business.SearchBusiness;
import com.util.PagingResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/search")
public class SearchController {

    private Logger log = LoggerFactory.getLogger(SearchController.class);

    @Autowired
    SearchBusiness searchBusiness;

    @RequestMapping(value = "/index")
    public String index() {
        return "/layout/service";
    }

    @RequestMapping(value = "/info")
    public String searchInfoIndex(String keyName, Model model) {
        log.info("[SearchController]index-->搜索关键字为：{}", keyName);
        return searchInfo(keyName, model, 1);
    }

    @RequestMapping(value = "/info/{keyName}/{page}")
    public String searchInfo(@PathVariable String keyName, Model model, @PathVariable Integer page) {
        log.info("[SearchController]index-->搜索关键字为：{}  当前页码：{}", keyName, page);
        SearchDTO resultByKeyName = searchBusiness.getResultByKeyName(keyName);
        model.addAttribute("searchResult", resultByKeyName);
        PagingResult<SearchDTO> searchListResult = searchBusiness.getSearchListResult(keyName, page);
        model.addAttribute("searchResultList", searchListResult);
        log.info("[SearchController]searchListResult-->{}",searchListResult);
        return "/layout/service";
    }
}
