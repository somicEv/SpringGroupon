<#import "macro/paging.ftl" as paging_macro>
<#import "macro/common.ftl" as common>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${title}</title>
    <link rel="icon" href="images/favicon.ico" type="image/x-icon"/>
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon"/>
    <link rel="bookmark" href="images/favicon.ico" type="image/x-icon"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.getContextPath}/style/reset.css">
    <link type="text/css" rel="stylesheet" href="${ctx}/style/main.css">
    <script type="text/javascript" src="${ctx}/js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/site.js"></script>
    <!--[if IE 6]>
    <script type="text/javascript" src="${ctx}/js/DD_belatedPNG_0.0.8a-min.js"></script>
    <script type="text/javascript" src="${ctx}/js/ie6Fixpng.js"></script>
    <![endif]-->
    <title>分类</title>
</head>
<body>
<#include "layout/header.ftl">

<div class="hr_15"></div>
<div class="comWidth clearfix products">
    <div class="leftArea">
        <div class="leftNav vertical">
        <#if dealCategory??>
            <h3 class="nav_title">${dealCategory.name}</h3>
            <#list dealCategory.children as child>
                <div class="nav_cont">
                    <h3>${child.name}</h3>
                    <ul class="navCont_list clearfix">
                        <#list child.children as c>
                            <li><a href="${ctx}/category/${c.urlName}">${c.name}</a></li>
                        </#list>
                    </ul>
                </div>
            </#list>
        </#if>
        </div>
    </div>
    <div class="rightArea">
        <div class="addInfo">
            <div class="fr screen_text">
                        <span class="shop_number">
                            共<em>${pagingDealList.total}</em>件
                        </span>
            </div>
        </div>
        <div class="products_list screening_list_more clearfix">
        <#list pagingDealList.rows as deal>
            <div class="item">
                <div class="item_cont">
                    <div class="img_item">
                        <a href="${ctx}/item/${deal.skuId}"><img src="${ctx}/${helper.getDealImageUrlForIndexDealList(deal)}" alt=""></a>
                    </div>
                    <p><a href="${ctx}/item/${deal.skuId}">${deal.dealTitle}</a></p>
                    <p class="money"><@common.formatPrice deal.dealPrice/></p>
                    <p><a href="${ctx}/cart/default/${deal.skuId}" class="addCar">加入购物车</a></p>
                </div>
            </div>
        </#list>
        </div>
        <div class="hr_25"></div>
    <#if pagingDealList??>
        <#if dealCategory??>
            <@paging_macro.paging pagingList=pagingDealList url="${ctx}/category/${dealCategory.url_name}"/>
        </#if>
    </#if>
    </div>
</div>
</body>
</html>
