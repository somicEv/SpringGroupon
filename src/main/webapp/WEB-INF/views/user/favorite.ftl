<#import "${pageContext.request.getContextPath}/macro/paging.ftl" as paging_macro>
<#import "${pageContext.request.getContextPath}/macro/common.ftl" as common>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="icon" href="images/favicon.ico" type="image/x-icon" />
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
    <link rel="bookmark" href="images/favicon.ico" type="image/x-icon" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.getContextPath}/style/reset.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.getContextPath}/style/main.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.getContextPath}/stylesheets/style.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.getContextPath}/stylesheets/waves.min.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.getContextPath}/stylesheets/shortcodes.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.getContextPath}/stylesheets/responsive.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.getContextPath}/stylesheets/bootstrap.min.css">
    <!--[if IE 6]>
    <script type="text/javascript" src="${ctx}/js/DD_belatedPNG_0.0.8a-min.js"></script>
    <script type="text/javascript" src="${ctx}/js/ie6Fixpng.js"></script>
    <![endif]-->
    <title>收藏商品</title>
</head>
<body>
<#include "${pageContext.request.getContextPath}/layout/header.ftl">
<div class="hr_15"></div>
<div class="comWidth clearfix products">
    <div class="leftArea">
        <#include "${pageContext.request.getContextPath}/user/left_menu.ftl">
    </div>
    <div class="rightArea">
        <div class="shopping_item">
            <h3 class="shopping_tit">我的收藏</h3>
            <div class="shopping_cont pb_10">
                <div class="cart_inner">
                    <div class="cart_head clearfix">
                        <div class="cart_item t_name">商品名称</div>
                        <div class="cart_item t_price">单价</div>
                        <div class="cart_item t_return">折扣</div>
                        <div class="cart_item t_status">状态</div>
                        <div class="cart_item t_operate">操作</div>
                    </div>
                    <#if favorites??>
                        <#list favorites as favorite>
                            <div class="cart_cont clearfix">
                                <div class="cart_item t_name">
                                    <div class="cart_shopInfo clearfix">
                                        <div>
                                            <#--<input type="checkbox" id="${favorite.favorite.id}" onclick="check(this, ${favorite.favorite.id})" style="float:left; margin-top:40px; margin-right: 10px">-->
                                            <img src="${ctx}/${helper.getDealImageUrlForIndexDealList(favorite.deal)}" alt="">
                                            <div class="cart_shopInfo_cont">
                                                <p class="cart_link"><a href="${ctx}/item/${favorite.deal.skuId}">${favorite.deal.dealTitle}</a></p>
                                                <p class="cart_info">7天退换</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="cart_item t_price">
                                    <@common.formatPrice favorite.deal.dealPrice/>
                                </div>
                                <div class="cart_item t_return"><@common.formatDiscount favorite.deal.discount/></div>
                                <div class="cart_item t_status">
                                    <#if favorite.deal.start>
                                        进行中
                                    <#elseif favorite.deal.end>
                                        已结束
                                    <#else>
                                        未开始
                                    </#if>
                                </div>
                                <div class="cart_item t_operate">
                                    <#if favorite.deal.start>
                                        <a href="${ctx}/settlement/${favorite.deal.skuId}" class="btn_link" onclick="">购买&nbsp;&nbsp;</a>
                                    <#else>
                                        <a href="${ctx}/item/${favorite.deal.skuId}" class="btn_link" onclick="">查看&nbsp;&nbsp;</a>
                                    </#if>
                                    <a href="javascript:void(0)" class="btn_link">删除</a>
                                </div>
                            </div>
                        </#list>
                    <#else >
                        <p>您还没有添加！！请先添加商品在回来查询吧</p>
                    </#if>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "${pageContext.request.getContextPath}/layout/footer.ftl">

<script type="text/javascript" src="${pageContext.request.getContextPath}/javascript/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath}/javascript/tether.min.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath}/javascript/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath}/javascript/waypoints.min.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath}/javascript/easing.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath}/javascript/jquery.flexslider-min.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath}/javascript/owl.carousel.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath}/javascript/smoothscroll.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath}/javascript/jquery.mCustomScrollbar.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath}/javascript/gmap3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath}/javascript/waves.min.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath}/javascript/jquery.countdown.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath}/javascript/main.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath}/js/site.js"></script>
</body>
</html>

