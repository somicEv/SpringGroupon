package com.service.business;

import com.common.constant.OrderConstant;
import com.common.entity.Order;
import com.common.entity.OrderDetail;
import com.common.entity.area.Address;
import com.common.exception.BusinessException;
import com.common.vo.SettlementDTO;
import com.dao.OrderDao;
import com.dao.OrderDetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderBusiness {

    @Autowired
    OrderDao orderDao;

    @Autowired
    OrderDetailDao orderDetailDao;
    /**
     * 下单
     *
     * @param userId
     * @param cartDTOs
     * @param address
     * @param totalPrice
     * @param payType
     */
    public Long order(Long userId, List<SettlementDTO> cartDTOs, Address address, Integer totalPrice, Integer payType){
        if (null == userId) {
            throw new BusinessException("用户ID不能为空");
        }
        //构造Order对象
        Order order = initOrder(userId, totalPrice, address, payType, cartDTOs);
        if (null == order) {
            throw new BusinessException("订单不能为空");
        }

        if (CollectionUtils.isEmpty(order.getOrderDetails())) {
            throw new BusinessException("订单详细信息不能为空");
        }

        orderDao.saveOrder(order);
        for (OrderDetail detail : order.getOrderDetails()) {
            if (null == detail) {
                throw new BusinessException("订单详细信息不能为空");
            }
            detail.setOrderId(order.getId());
        }
        orderDetailDao.saveOrderDetails(order.getOrderDetails());
        return order.getId();
    }

    private Order initOrder(Long userId, Integer totalPrice, Address address, Integer payType,
                            List<SettlementDTO> cartDTOs) {
        Date now = new Date();
        Order order = new Order();
        order.setUserId(userId);
        order.setTotalPrice(totalPrice);
        order.setOrderStatus(OrderConstant.STATUS_WAITING_PAY);
        order.setCreateTime(now);
        order.setUpdateTime(now);
        order.setReceiver(address.getReceiver());
        order.setAddress(address.getArea() + " " + address.getDetail());
        order.setPhone(address.getPhone());
        order.setPayType(payType);

        List<OrderDetail> details = new ArrayList<>();
        Integer totalSettlementPrice = 0;
        for (SettlementDTO settlementDTO : cartDTOs) {
            OrderDetail detail = new OrderDetail();
            detail.setDealCount(settlementDTO.getCart().getDealCount());
            detail.setDealPrice(settlementDTO.getDeal().getDealPrice());
            detail.setDealTitle(settlementDTO.getDeal().getDealTitle());
            detail.setDealId(settlementDTO.getDeal().getId());
            detail.setDealSkuId(settlementDTO.getDeal().getSkuId());
            detail.setDealImgId(settlementDTO.getDeal().getImageId());
            detail.setDetailStatus(settlementDTO.getDeal().getPublishStatus());
            detail.setMerchantCode(settlementDTO.getDeal().getMerchantCode());
            detail.setCreateTime(now);
            detail.setUpdateTime(now);
            detail.setUserId(userId);
            detail.setSettlementPrice(settlementDTO.getDeal().getSettlementPrice());
            detail.setTotalSettlementPrice(settlementDTO.getDeal().getSettlementPrice() * detail.getDealCount());
            detail.setTotalPrice(detail.getDealPrice() * detail.getDealCount());
            totalSettlementPrice += detail.getTotalSettlementPrice();
            detail.setMerchantId(settlementDTO.getDeal().getMerchantId());
            details.add(detail);
        }
        order.setOrderDetails(details);
        order.setTotalSettlementPrice(totalSettlementPrice);
        return order;
    }

}
