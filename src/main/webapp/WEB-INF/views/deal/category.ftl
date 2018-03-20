<#import "${pageContext.request.getContextPath}/macro/paging.ftl" as paging_macro>
<#import "${pageContext.request.getContextPath}/macro/common.ftl" as common>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.getContextPath}/stylesheets/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.getContextPath}/style/reset.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.getContextPath}/style/main.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.getContextPath}/stylesheets/style.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.getContextPath}/stylesheets/waves.min.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.getContextPath}/stylesheets/shortcodes.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.getContextPath}/stylesheets/responsive.css">
    <title>分类</title>
    <script type="text/javascript">
        function addToCart(skuId) {
        <#if username??>
            Submit.AjaxSubmit('${ctx}/cart/default/' + skuId);
        <#else >
            window.location = '${ctx}/login';
        </#if>
        }
    </script>
</head>
<body>
<#include "${pageContext.request.getContextPath}/layout/header.ftl">

<div class="hr_15"></div>
<div class="comWidth clearfix products">
    <main id="shop">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-4">
                    <div class="sidebar ">
                        <div class="widget widget-categories">
                            <div class="widget-title">
                                <h3>Categories<span></span></h3>
                            </div>
                            <ul class="cat-list style1 widget-content">
                            <#if dealCategory??>
                                <li>
                                    <span>${dealCategory.name}</span>
                                    <ul class="cat-child">
                                        <#list dealCategory.children as child>
                                            <li><a href="${ctx}/category/${child.url_name}">${child.name}</a></li>
                                        </#list>
                                    </ul>
                                </li>
                            </#if>
                            </ul><!-- /.cat-list -->
                        </div><!-- /.widget-categories -->
                    </div>
                </div><!-- /.col-lg-3 col-md-4 -->
                <div class="col-lg-9 col-md-8">
                    <div class="main-shop">
                        <div class="wrap-imagebox">
                            <div class="flat-row-title">
                                <h3>${dealCategory.name}</h3>
                                <div class="clearfix"></div>
                            </div>
                            <div class="tab-product">
                                <div class="row sort-box">
                                <#list pagingDealList.rows as deal>
                                    <div class="col-lg-4 col-sm-6">
                                        <div class="product-box">
                                            <div class="imagebox">
                                                <div class="box-image owl-carousel-1">
                                                    <a href="${ctx}/item/${deal.skuId}" title="">
                                                        <img src="${ctx}/${helper.getDealImageUrlForIndexDealList(deal)}"
                                                             alt="">
                                                    </a>
                                                    <a href="${ctx}/item/${deal.skuId}" title="">
                                                        <img src="${ctx}/${helper.getDealImageUrlForIndexDealList(deal)}"
                                                             alt="">
                                                    </a>
                                                    <a href="${ctx}/item/${deal.skuId}" title="">
                                                        <img src="${ctx}/${helper.getDealImageUrlForIndexDealList(deal)}"
                                                             alt="">
                                                    </a>
                                                </div><!-- /.box-image -->
                                                <div class="box-content">
                                                    <div class="cat-name">
                                                        <a href="#" title="">Cameras</a>
                                                    </div>
                                                    <div class="product-name">
                                                        <a href="${ctx}/item/${deal.skuId}">${deal.dealTitle}</a>
                                                    </div>
                                                    <div class="price">
                                                        <@common.formatPrice deal.dealPrice/>
                                                    </div>
                                                </div><!-- /.box-content -->
                                                <div class="box-bottom">
                                                    <div class="btn-add-cart">
                                                        <a href="#" title="" onclick="addToCart(${deal.skuId})">
                                                            <img src="images/icons/add-cart.png" alt="">Add to Cart
                                                        </a>
                                                    </div>
                                                    <div class="compare-wishlist">
                                                        <a href="#" class="compare" title="">
                                                            <img src="images/icons/compare.png" alt="">Compare
                                                        </a>
                                                        <a href="#" class="wishlist" title="">
                                                            <img src="images/icons/wishlist.png" alt="">Wishlist
                                                        </a>
                                                    </div>
                                                </div><!-- /.box-bottom -->
                                            </div><!-- /.imagebox -->
                                        </div>
                                    </div>
                                </#list>
                                </div>
                            </div>
                        </div><!-- /.wrap-imagebox -->
                        <div>
                            <#if pagingDealList??>
                                <#if dealCategory??>
                                    <@paging_macro.paging pagingList=pagingDealList url="${ctx}/category/${dealCategory.url_name}"/>
                                </#if>
                            </#if>
                            <div class="clearfix"></div>
                        </div><!-- /.blog-pagination -->
                    </div><!-- /.main-shop -->
                </div><!-- /.col-lg-9 col-md-8 -->
            </div><!-- /.row -->
        </div><!-- /.container -->
    </main><!-- /#shop -->
</div>
</div>
<script type="text/javascript" src="${pageContext.request.contentPath}/javascript/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath}/js/site.js"></script>
<script type="text/javascript" src="${pageContext.request.contentPath}/javascript/tether.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contentPath}/javascript/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contentPath}/javascript/waypoints.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contentPath}/javascript/jquery.circlechart.js"></script>
<script type="text/javascript" src="${pageContext.request.contentPath}/javascript/easing.js"></script>
<script type="text/javascript" src="${pageContext.request.contentPath}/javascript/jquery.flexslider-min.js"></script>
<script type="text/javascript" src="${pageContext.request.contentPath}/javascript/owl.carousel.js"></script>
<script type="text/javascript" src="${pageContext.request.contentPath}/javascript/smoothscroll.js"></script>
<script type="text/javascript" src="${pageContext.request.contentPath}/javascript/jquery-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contentPath}/javascript/jquery.mCustomScrollbar.js"></script>
<script type="text/javascript" src="${pageContext.request.contentPath}/javascript/gmap3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contentPath}/javascript/waves.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contentPath}/javascript/jquery.countdown.js"></script>
<script type="text/javascript" src=${pageContext.request.contentPath}/javascript/main.js></script>

</body>
</html>
