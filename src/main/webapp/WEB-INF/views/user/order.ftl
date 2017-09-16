<#import "macro/order.ftl" as order_macro>
<#import "macro/common.ftl" as common>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="icon" href="images/favicon.ico" type="image/x-icon" />
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
    <link rel="bookmark" href="images/favicon.ico" type="image/x-icon" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.getContextPath}/style/reset.css">
    <link type="text/css" rel="stylesheet" href="${ctx}/style/main.css">
    <script type="text/javascript" src="${ctx}/js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/site.js"></script>
    <!--[if IE 6]>
    <script type="text/javascript" src="${ctx}/js/DD_belatedPNG_0.0.8a-min.js"></script>
    <script type="text/javascript" src="${ctx}/js/ie6Fixpng.js"></script>
    <![endif]-->
    <title>我的订单</title>
</head>
<body>
<#include "layout/header.ftl">
<div class="hr_15"></div>
<div class="comWidth clearfix products">
    <div class="leftArea">
        <#include "user/left_menu.ftl">
    </div>
    <div class="rightArea">
        <h3 class="shopping_tit">我的订单</h3>
        <#if orders??>
            <#list orders as order>
                <h3 class="shopping_item">
                    <@common.formatDateTime order.createTime/>&nbsp;&nbsp;&nbsp;
                    订单号：${order.id}&nbsp;&nbsp;&nbsp;
                    收货人：${order.receiver}&nbsp;&nbsp;&nbsp;
                    订单金额：<@common.formatPrice order.totalPrice/>&nbsp;&nbsp;&nbsp;
                    支付方式：<@order_macro.getOrderPayTypeName order.payType/>&nbsp;&nbsp;&nbsp;
                    订单状态：<@order_macro.getOrderStatusName order.orderStatus/>&nbsp;&nbsp;&nbsp;
                </h3>

                <#list order.orderDetails as detail>
                    <div class="cart_cont clearfix">
                        <div class="cart_item t_name">
                            <div class="cart_shopInfo clearfix">
                                <div>
                                <#--<input type="checkbox" id="${order.id}" onclick="check(this, ${order.id})" style="float:left; margin-top:40px; margin-right: 10px">-->
                                    <img src="${helper.getDealImageUrlForGrid(detail.dealImgId)}" alt="">
                                    <div class="cart_shopInfo_cont">
                                        <p class="cart_link"><a href="${ctx}/item/${detail.id}">${detail.dealTitle}</a></p>
                                        <p class="cart_info">7天退换</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="cart_item t_num">
                            x${detail.dealCount}
                        </div>
                        <div class="cart_item t_return"></div>
                        <div class="cart_item t_status">
                        </div>
                        <div class="cart_item t_operate">
                            <a href="javascript:void(0)" class="btn_link" onclick="">再次购买&nbsp;&nbsp;</a>
                            <a href="${ctx}/item/${detail.dealSkuId}" class="btn_link" onclick="">查看&nbsp;&nbsp;</a>
                            <a href="${ctx}/item/${detail.dealSkuId}" class="btn_link" onclick="">取消&nbsp;&nbsp;</a>
                            <#--<a href="javascript:void(0)" class="btn_link">删除</a>-->
                        </div>
                    </div>
                </#list>
                <div class="hr_25"></div>
            </#list>
        </#if>
    </div>
</div>
<#include "layout/footer.ftl">
</body>
</html>

