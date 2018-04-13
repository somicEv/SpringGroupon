<#import "${pageContext.request.contentPath}/macro/common.ftl" as common>
<#import "${pageContext.request.getContextPath}/macro/paging.ftl" as paging_macro>
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
    <!--[if IE 6]>
    <script type="text/javascript" src="${ctx}/js/DD_belatedPNG_0.0.8a-min.js"></script>
    <script type="text/javascript" src="${ctx}/js/ie6Fixpng.js"></script>
    <![endif]-->
    <title>便民服务</title>

    <style>
        .search_box {
            padding-top: 0;
            padding-left: 0;
        }
    </style>
</head>
<body>
<#include "${pageContext.request.contentPath}/layout/header.ftl">
<div class="hr_15"></div>
<div class="comWidth clearfix products">
    <div class="search_box fl">
        <form action="/search/info" id="search_form" method="get">
            <div class="box-search" style="height: 73px;">
                <input type="text" name="keyName" placeholder="Search what you looking for ?">
                <span class="btn-search">
                        <button type="submit" class="waves-effect" style="top: -48px;left: 348px;">
                            <img src="${ctx}/images/icons/search.png" alt="">
                        </button>
                    </span>
            </div><!-- /.box-search -->
        </form>
    </div>
    <div class="rightArea" style="width: 1000px;min-height: 500px;">
        <h3 class="shopping_tit">搜索结果</h3>
        <#if searchResultList??>
            <#list searchResultList.rows as resultList>
                <div class="cart_cont clearfix">
                    <div class="cart_item t_name">
                        <div class="cart_shopInfo clearfix">
                            <div>
                                <img src="${ctx}/${helper.getUserOrderImageUrl(resultList.imageId)}" alt=""
                                     style="width: 129px;height: 137px;margin: 0 10px 5px 0;">
                                <div class="cart_shopInfo_cont">
                                    <h4 class="cart_link newsTitle" style="width: 590px;"><a
                                            href="#">${resultList.keyName}</a></h4>
                                    <p class="cart_info" style="font-size: 14px;width: 550px;">简介：${resultList.resultDesc}</p>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
                <div class="hr_25" style="margin: 5px 0 5px 0;">
                    <a href="${resultList.resultUrl}" class="btn_link" style="float: right;margin-right: 50px;">
                        <img src="${pageContext.request.contentPath}/images/icons/content.png" style="height: 23px;"/>
                        查看详情&nbsp;&nbsp;
                    </a>
                </div>
            </#list>
        </#if>
        <div>
            <#if searchResultList??>
                <#if searchResult??>
                    <@paging_macro.paging pagingList=searchResultList url="${ctx}/search/info/${searchResult.keyName}"/>
                </#if>
            </#if>
            <div class="clearfix"></div>
        </div><!-- /.blog-pagination -->
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

