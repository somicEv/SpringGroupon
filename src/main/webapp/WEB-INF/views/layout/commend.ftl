<#import "${pageContext.request.getContentPath}/macro/common.ftl" as common>
<#import "${pageContext.request.getContentPath}/macro/paging.ftl" as paging_macro>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon"/>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon"/>
    <link rel="bookmark" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/reset.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/main.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/style.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/waves.min.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/shortcodes.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/responsive.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/jquery.raty.css"/>
    <script>
        <#if result == 1>
            alert('添加评论成功');
        <#elseif result == 0>
            alert('添加评论失败0000000');
        </#if>

    </script>
    <!--[if IE 6]>
    <script type="text/javascript" src="${ctx}/js/DD_belatedPNG_0.0.8a-min.js"></script>
    <script type="text/javascript" src="${ctx}/js/ie6Fixpng.js"></script>
    <![endif]-->
    <title>提交评论</title>
</head>
<body>
<#include "${pageContext.request.contextPath}/layout/header.ftl">
<div class="hr_15"></div>
<div class="comWidth clearfix products">
    <div class="leftArea" style="width: 500px;min-height: 500px;">
        <div>
            <img src="${ctx}/${helper.getUserOrderImageUrl(dealInfo.imageId)}" alt=""
                 style="width: 200px;height: 300px;margin-left: 50px;">
            <div class="cart_shopInfo_cont">
                <h4 class="cart_link newsTitle" style="width: 590px;"><a
                        href="#">${dealInfo.dealTitle}</a></h4>
                <p class="cart_info" style="font-size: 14px;width: 550px;"><@common.formatPrice dealInfo.dealPrice/></p>
            </div>
        </div>
    </div>
    <div class="rightArea" style="width: 500px;min-height: 500px;">
        <div class="col-md-6" style="max-width: 100%;">
            <div class="form-review">
                <div class="title">
                    Add a review
                </div>
                <div class="your-rating queue">
                    <span>Your Rating</span>
                    <div id="rate"></div>
                </div>
                <form action="/commend/add" method="get" accept-charset="utf-8">
                    <div class="review-form-name">
                        <input type="text" name="userName" value="${userInfo.username}" placeholder="Name" readonly="readonly">
                    </div>
                    <div class="review-form-comment">
                        <textarea name="commend" placeholder="Your commend" id="commend_area"></textarea>
                    </div>
                    <div class="btn-submit">
                        <input type="hidden" name="rate" value="">
                        <input type="hidden" name="skuId" value="${dealInfo.skuId}">
                        <button type="submit">Add Review</button>
                    </div>
                </form>
            </div><!-- /.form-review -->
        </div><!-- /.col-md-6 -->
    </div>
</div>

<#include "${pageContext.request.contentPath}/layout/footer.ftl">

<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/tether.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/waypoints.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/easing.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/jquery.flexslider-min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/owl.carousel.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/smoothscroll.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/"
<script type="text/javascript"
        src="${pageContext.request.contextPath}/javascript/jquery.mCustomScrollbar.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/js/jquery.raty.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/gmap3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/waves.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/jquery.countdown.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/site.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/commend.js"></script>
</body>
</html>

