<#import "${pageContext.request.contentPath}/macro/order.ftl" as order_macro>
<#import "${pageContext.request.contentPath}/macro/common.ftl" as common>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="icon" href="images/favicon.ico" type="image/x-icon"/>
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon"/>
    <link rel="bookmark" href="images/favicon.ico" type="image/x-icon"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.getContextPath}/style/reset.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.getContextPath}/style/main.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.getContextPath}/stylesheets/style.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.getContextPath}/stylesheets/waves.min.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.getContextPath}/stylesheets/shortcodes.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.getContextPath}/stylesheets/responsive.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.getContextPath}/stylesheets/bootstrap.min.css">
    <script>
        function addToCart(skuId) {
        <#if username??>
            Submit.AjaxSubmit('${ctx}/cart/default/' + skuId + '/' + 1);
        <#else >
            window.location = '${ctx}/login';
        </#if>
        }
    </script>
    <style>
        h3 {
            font-size: 15px;
        }
    </style>
    <!--[if IE 6]>
    <script type="text/javascript" src="${ctx}/js/DD_belatedPNG_0.0.8a-min.js"></script>
    <script type="text/javascript" src="${ctx}/js/ie6Fixpng.js"></script>
    <![endif]-->
    <title>我的订单</title>
</head>
<body>
<#include "${pageContext.request.contentPath}/layout/header.ftl">
<div class="hr_15"></div>
<div class="comWidth clearfix products">
    <div class="leftArea">
    <#include "${pageContext.request.contentPath}/user/left_menu.ftl">
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
                                <img src="${ctx}/${helper.getUserOrderImageUrl(detail.dealImgId)}" alt="">
                                <div class="cart_shopInfo_cont" style="margin-left:  ">
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
                        <a href="#" class="btn_link" onclick="addToCart(${detail.dealSkuId})">再次购买&nbsp;&nbsp;</a>
                        <a href="${ctx}/item/${detail.dealSkuId}" class="btn_link" onclick="">查看&nbsp;&nbsp;</a>
                        <a href="${ctx}/commend/index/${detail.dealSkuId}" class="btn_link" onclick="">评论&nbsp;&nbsp;</a>
                    </div>
                </div>
            </#list>
            <div class="hr_25" style="margin: 5px 0 5px 0;">
                <#if order.orderStatus = 1 >
                    <a href="${ctx}/order/update/${order.id}" class="btn_link" onclick=""
                       style="float: right;margin-right: 50px;">
                        <img src="${pageContext.request.contentPath}/images/icon/wait_pay.png" style="height: 23px;"/>
                        去付款&nbsp;&nbsp;
                    </a>
                <#else>
                    <a href="${ctx}/item/${detail.dealSkuId}" class="btn_link" onclick=""
                       style="float: right;margin-right: 50px;">
                        <img src="${pageContext.request.contentPath}/images/icons/delete.png" style="height: 23px;"/>
                        删除订单&nbsp;&nbsp;
                    </a>
                </#if>
            </div>
        </#list>
    </#if>
    </div>
</div>
<#include "${pageContext.request.contentPath}/layout/footer.ftl">

<script type="text/javascript" src="${pageContext.request.getContextPath}/javascript/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath}/javascript/tether.min.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath}/javascript/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath}/javascript/waypoints.min.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath}/javascript/easing.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath}/javascript/jquery.flexslider-min.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath}/javascript/owl.carousel.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath}/javascript/smoothscroll.js"></script>
<script type="text/javascript"
        src="${pageContext.request.getContextPath}/javascript/jquery.mCustomScrollbar.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath}/javascript/gmap3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath}/javascript/waves.min.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath}/javascript/jquery.countdown.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath}/javascript/main.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath}/js/site.js"></script>
</body>
</html>

