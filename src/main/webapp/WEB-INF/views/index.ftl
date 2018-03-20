<#import "macro/common.ftl" as common>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>首页</title>
    <link rel="icon" href="images/favicon.ico" type="image/x-icon"/>
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon"/>
    <link rel="bookmark" href="images/favicon.ico" type="image/x-icon"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.getContextPath}/style/reset.css">
    <link type="text/css" rel="stylesheet" href="${ctx}/style/main.css">
    <link type="text/css" rel="stylesheet" href="${ctx}/stylesheets/style.css"/>
    <link type="text/css" rel="stylesheet" href="${ctx}/stylesheets/waves.min.css"/>
    <link type="text/css" rel="stylesheet" href="${ctx}/stylesheets/shortcodes.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/stylesheets/responsive.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/stylesheets/bootstrap.min.css">
    <script type="text/javascript" src="${pageContext.request.getContextPath}/js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.getContextPath}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.getContextPath}/js/site.js"></script>
    <!--[if IE 6]>
    <script type="text/javascript" src="${ctx}/js/DD_belatedPNG_0.0.8a-min.js"></script>
    <script type="text/javascript" src="${ctx}/js/ie6Fixpng.js"></script>
    <![endif]-->
    <script>
        function addToCart(skuId) {
        <#if username??>
            Submit.AjaxSubmit('${ctx}/cart/default/' + skuId, 1);
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
    </script>
    <style>
        .nav a {
            height: 0px;
        }

        .banner_big, .banner_big img {
            width: 1001px;
        }
    </style>
</head>
<body>
<#include "${pageContext.request.contextPath}/layout/header.ftl">
<!-- /.flat-slider -->
<#if indexRecommendInfo??>
<section class="flat-row flat-slider">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="slider owl-carousel">
                    <#list indexRecommendInfo as recommendList>
                        <div class="slider-item style2">
                            <div class="item-text">
                                <div class="header-item">
                                    <h2 class="name"><span>${recommendList.recommend.recommendName}</span></h2>
                                    <p>${recommendList.recommend.recommendDesc}</p>
                                </div>
                                <div class="divider65"></div>
                                <div class="content-item">
                                    <div class="price">
                                        <span class="sale">${recommendList.deal.dealPrice}</span>
                                        <span class="btn-shop">
												<a href="#" title="">SHOP NOW <img src="images/icons/right-2.png"
                                                                                   alt=""></a>
                                    </span>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="item-image">
                                <img src="images/slider/03.png" alt="">
                            </div>
                            <div class="clearfix"></div>
                        </div><!-- /.slider -->

                    </#list>
                </div><!-- /.slider -->
            </div><!-- /.col-md-12 -->
        </div><!-- /.row -->
    </div><!-- /.container -->
</section><!-- /.flat-slider -->
</#if>

<section class="flat-imagebox">
    <div class="container">
        <!-- 新到商品 -->
        <div class="row">
            <div class="col-md-12">
                <div class="product-tab">
                    <ul class="tab-list">
                        <li class="active">New Arrivals</li>
                        <a href="${ctx}/category/jiadian" class="more">更多&gt;&gt;</a>
                    </ul>
                </div><!-- /.product-tab -->
            </div><!-- /.col-md-12 -->
        </div><!-- /.row -->
        <div class="box-product">
            <div class="row">
            <#if newArrivalList ??>
                <#list newArrivalList as arrivalList>
                    <div class="col-lg-3 col-sm-6">
                        <#list arrivalList.deals as dealList>
                            <div class="product-box">
                                <div class="imagebox">
                                    <!--<span class="item-new">NEW</span>-->
                                    <ul class="box-image owl-carousel-1">
                                        <li>
                                            <a href="#" title="">
                                                <img src="${pageContext.request.contextPath}/${helper.getDealImageUrlForIndexDealList(dealList)}" alt="">
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#" title="">
                                                <img src="${pageContext.request.contextPath}/${helper.getDealImageUrlForIndexDealList(dealList)}" alt="">
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#" title="">
                                                <img src="${pageContext.request.contextPath}/${helper.getDealImageUrlForIndexDealList(dealList)}" alt="">
                                            </a>
                                        </li>
                                    </ul><!-- /.box-image -->
                                    <div class="box-content">
                                        <div class="product-name">
                                            <a href="${pageContext.request.contextPath}/item/${dealList.skuId}" title="">${dealList.dealTitle}</a>
                                        </div>
                                        <div class="price">
                                            <span class="sale">￥${dealList.dealPrice}</span>
                                        </div>
                                    </div><!-- /.box-content -->
                                    <div class="box-bottom">
                                        <div class="btn-add-cart">
                                            <a href="#" title="" onclick="addToCart(${dealList.skuId})">
                                                <img src="${pageContext.request.contextPath}/images/icons/add-cart.png" alt="">Add to Cart
                                            </a>
                                        </div>
                                        <div style="margin: 20px 0px 0px 0px;">
                                            <a href="#" title="" onclick="addToFavorite(${dealList.skuId})"">
                                                <img src="${pageContext.request.contextPath}/images/icons/wishlist.png" alt="">Add to WishList
                                            </a>
                                        </div>
                                    </div><!-- /.box-bottom -->
                                </div><!-- /.imagebox -->
                            </div>
                        </#list>
                    </div>
                </#list><!-- /.col-lg-3 col-sm-6 -->
            </#if>
            </div><!-- /.row -->
        </div><!-- /.box-product -->
    </div><!-- /.container -->
</section><!-- /.flat-imagebox -->
<#include "layout/footer.ftl">

<!-- Javascript -->
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