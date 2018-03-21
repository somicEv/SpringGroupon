<#import "${pageContext.request.getContextPath}/macro/paging.ftl" as paging_macro>
<#import "${pageContext.request.getContextPath}/macro/common.ftl" as common>
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
    <title>收货地址</title>
</head>
<body>
<#include "${pageContext.request.getContextPath}/layout/header.ftl">
<div class="hr_15"></div>
<div class="comWidth clearfix products">
    <div class="leftArea">
    <#include "${pageContext.request.getContextPath}/user/left_menu.ftl">
    </div>
    <div class="rightArea">
        <h3 class="shopping_tit">收货地址</h3>
        <div class="btn_link" style="margin-bottom: 25px;">
            <a class="btn" href="${ctx}/home/address/new">新增收货地址</a>
        </div>
        <!--表格-->
        <table class="table" cellspacing="0" cellpadding="0">
            <thead>
            <tr>
                <th width="10%">收货人</th>
                <th width="30%">地区</th>
                <th width="40%">详细地址</th>
                <th width="15%">手机</th>
            </tr>
            </thead>
            <tbody>
            <#if addresses??>
                <#list addresses as address>
                <tr>
                    <td>${address.receiver}</td>
                    <td>${address.area}</td>
                    <td>${address.detail}</td>
                    <td>${address.phone}</td>
                </tr>
                </#list>
            <#else>
            <p>您还没有添加收货地址</p>
            </#if>
            </tbody>
        </table>
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
<script type="text/javascript"
        src="${pageContext.request.getContextPath}/javascript/jquery.mCustomScrollbar.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath}/javascript/gmap3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath}/javascript/waves.min.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath}/javascript/jquery.countdown.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath}/javascript/main.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath}/js/site.js"></script>
</body>
</html>

