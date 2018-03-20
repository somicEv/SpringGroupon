<#import "${pageContext.request.contentPath}/macro/common.ftl" as common>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="icon" href="images/favicon.ico" type="image/x-icon"/>
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon"/>
    <link rel="bookmark" href="images/favicon.ico" type="image/x-icon"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.getContextPath}/style/reset.css">
    <link type="text/css" rel="stylesheet" href="${ctx}/style/main.css">
    <link type="text/css" rel="stylesheet" href="${ctx}/stylesheets/style.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/stylesheets/responsive.css">
    <style>
        input[type="checkbox"] {
            opacity: unset;
        }

        input[type="text"] {
            padding: 0;
            border: hidden;
            border-radius: inherit;
            height: 31px;
        }

        input[name="search"] {
            padding-left: 20px;
            border: 2px solid #e5e5e5;
            height: 48px;
            border-radius: 30px;

        }

        .des_number {
            width: 57px;
        }

        .review_t {
            padding-top: 0px;
        }

        .clearfix {
            clear: none;
        }

        .des_tit li {
            width: 31%;
        }
    </style>
    <script type="text/javascript" src="${pageContext.request.getContextPath}/js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.getContextPath}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.getContextPath}/js/site.js"></script>
    <![endif]-->
    <title>商品介绍</title>
    <script type="text/javascript">
        function dealCount(type) {
            var maxPurchaseCount = '${deal.maxPurchaseCount}';
            if (type == 1) {
                var count = Number(document.getElementById('count').value);
                if (count >= maxPurchaseCount) {
                    document.getElementById('count').value = maxPurchaseCount;
                } else {
                    document.getElementById('count').value = count + 1;
                }
            } else {
                var count = Number(document.getElementById('count').value);
                if (count <= 1) {
                    document.getElementById('count').value = 1;
                } else {
                    document.getElementById('count').value = count - 1;
                }
            }
        }

        function addToCart(skuId) {
            var count = document.getElementById('count').value;
        <#if username??>
            Submit.AjaxSubmit('${ctx}/cart/default/' + skuId, count);
        <#else >
            window.location = '${ctx}/login';
        </#if>
        }

        function addToFavorite(skuId) {
        <#if username??>
            Submit.AjaxSubmit('${ctx}/home/favorite/' + skuId);
        <#else >
            window.location = '${ctx}/login';
        </#if>
        }

        function addToStartRemind(skuId) {
        <#if username??>
            Submit.AjaxSubmit('${ctx}/home/remind/' + skuId);
        <#else >
            window.location = '${ctx}/login';
        </#if>
        }
    </script>
</head>
<body>
<#include "${pageContext.request.contentPath}/layout/header.ftl">

<div class="userPosition comWidth">
    <strong><a href="${ctx}/index">首页</a></strong>
    <span>&nbsp;&gt;&nbsp;</span>
    <a href="${ctx}/category/${dealCategory.url_name}">${dealCategory.name}</a>
    <span>&nbsp;&gt;&nbsp;</span>
    <em>${deal.dealTitle}</em>
</div>
<div class="description_info comWidth">
    <div class="description clearfix">
        <div class="leftArea">
            <div class="description_imgs">
                <div class="big">
                    <img src="${pageContext.request.contextPath}/${helper.getDealImageUrlForIndexDealList(deal)}" alt=""
                         style="width: 300px;height: 350px">
                </div>

            </div>
        </div>
        <div class="rightArea">
            <div class="des_content">
                <h3 class="des_content_tit">${deal.dealTitle}</h3>
                <div class="dl clearfix">
                    <div class="dt">
                        慕课价
                        <span class="des_money">
                        <@common.formatPrice deal.dealPrice/>
                        </span>
                    </div>
                </div>
                <div class="dl clearfix">
                    <div class="dt" style="width: 350px;">
                        优惠
                        <span class="hg">
                            <i class="hg_icon">满换购</i>
                            <em>购ipad加价优惠够配件或USB充电插座</em>
                        </span>
                    </div>
                    <div class="dd clearfix"></div>
                </div>
                <div class="des_position">
                    <div class="dl">
                        <div class="dt des_num" style="width: 72px;">数量</div>
                        <div class="dd clearfix">
                            <div class="des_number">
                                <div class="reduction" onclick="dealCount(0)">-</div>
                                <div class="des_input">
                                    <input type="text" id="count" name="count" value="1">
                                </div>
                                <div class="plus" onclick="dealCount(1)">+</div>
                            </div>
                            <span class="xg">限购<em>${deal.maxPurchaseCount}</em>件</span>
                        </div>
                    </div>
                </div>
                <div class="remind_time">
                <@common.formatDateTime deal.startTime/>开抢
                </div>
                <div class="shop_buy">
                <#if deal.start>
                    <a href="${ctx}/settlement/${deal.skuId}" class="buy_btn"></a>
                <#else>
                <#--<a href="${ctx}/settlement/${deal.skuId}" class="remind_btn"></a>-->
                    <a href="#" onclick="addToStartRemind(${deal.skuId})" class="remind_btn"></a>
                </#if>
                    <span class="line"></span>
                    <a href="#" onclick="addToCart(${deal.skuId})" class="cart_btn"></a>
                    <span class="line"></span>
                    <a href="#" onclick="addToFavorite(${deal.skuId})" class="collection_btn"></a>
                </div>
                <div class="notes">
                    注意：此商品可提供普通发票，不提供增值税发票。
                </div>
            </div>
        </div>
    </div>
</div>
<div class="hr_15"></div>
<!-- 商品描述 -->

<div class="des_info comWidth clearfix">
    <div class="leftArea">
        <div class="recommend">
            <h3 class="tit">推荐商品</h3>
        <#if indexRecommendInfo??>
            <#list indexRecommendInfo as recommendList>
            <div class="item">
                <div class="item_cont">
                    <div class="img_item">
                        <a href="#"><img src="${ctx}/images/shopImg.jpg" alt=""></a>
                    </div>
                    <p><a href="#">${recommendList.recommend.recommendName}</a></p>
                    <p class="money">￥${recommendList.deal.dealPrice}</p>
                </div>
            </div>
            </#list>
        </#if>
        </div>
    </div>
    <div class="rightArea">
        <div class="des_infoContent">
            <ul class="des_tit">
                <li><span>产品介绍</span></li>
            </ul>
            <div class="info_text">
                <div class="info_tit">
                    <h3>${deal.dealTitle!}</h3>
                </div>
                <p>商品名称：${deal.dealTitle!}</p>
                <p>商品编号：${deal.skuId}</p>
                <p>商品产地：${deal.areaName}</p>
                <p>商品简介：${deal.dealDetail.dealDetail!}</p>
            </div>
        </div>
        <div class="hr_15"></div>
        <div class="des_infoContent">
            <h3 class="shopDes_tit">商品评价</h3>
            <div class="review_tab">
                <ul class="review fl">
                    <li><a href="#" class="active">全部</a></li>
                </ul>
            </div>
            <div class="review_listBox">
            <#if commendList??>
                <#list commendList.commends as commendList>
                    <div class="review_list clearfix">
                        <div class="review_userHead fl">
                            <div class="review_user">
                                <img src="${ctx}/images/userhead.jpg" alt="">
                                <p>${commendList.userId}</p>
                                <p>${commendList.userName}</p>
                            </div>
                        </div>
                        <div class="review_cont" style="position: relative">
                            <p>时间：${commendList.createTime}</p>
                            <p>${commendList.commend}</p>
                        </div>
                    </div>
                </#list>
            <#else>
                <div class="review_list clearfix">
                    该商品目前还没有评论~~
                </div>
            </#if>
                <div class="hr_25"></div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${ctx}/javascript/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/javascript/tether.min.js"></script>
<script type="text/javascript" src="${ctx}/javascript/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/javascript/waypoints.min.js"></script>
<script type="text/javascript" src="${ctx}/javascript/easing.js"></script>
<script type="text/javascript" src="${ctx}/javascript/jquery.flexslider-min.js"></script>
<script type="text/javascript" src="${ctx}/javascript/owl.carousel.js"></script>
<script type="text/javascript" src="${ctx}/javascript/smoothscroll.js"></script>
<script type="text/javascript" src="${ctx}/javascript/jquery.mCustomScrollbar.js"></script>
<script type="text/javascript" src="${ctx}/javascript/gmap3.min.js"></script>
<script type="text/javascript" src="${ctx}/javascript/waves.min.js"></script>
<script type="text/javascript" src="${ctx}/javascript/jquery.countdown.js"></script>
<script type="text/javascript" src="${ctx}/javascript/main.js"></script>
</body>
</html>
