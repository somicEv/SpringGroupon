package com.common.vo;

import com.common.entity.Deal;
import com.common.entity.DealCategory;
import java.util.List;

/**
 * 首页显示商品
 */
public class IndexCategoryDealVo {

    private DealCategory category;
    private List<Deal> first;
    private List<Deal> second;

    public DealCategory getCategory() {
        return category;
    }

    public void setCategory(DealCategory category) {
        this.category = category;
    }

    public List<Deal> getFirst() {
        return first;
    }

    public void setFirst(List<Deal> first) {
        this.first = first;
    }

    public List<Deal> getSecond() {
        return second;
    }

    public void setSecond(List<Deal> second) {
        this.second = second;
    }

    public IndexCategoryDealVo(DealCategory category, List<Deal> first, List<Deal> second) {
        this.category = category;
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "IndexCategoryDealVo{" +
                "category=" + category +
                ", first=" + first +
                ", second=" + second +
                '}';
    }

    public void showFirst() {
       for (Deal deal : first){
           System.out.println(deal.toString());
       }
    }

    public void showSecond() {
        for (Deal deal : second){
            System.out.println(deal.toString());
        }
    }
}