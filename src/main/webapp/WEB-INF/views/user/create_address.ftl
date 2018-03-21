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
    <style>
        .select{
            height: auto;
        }
    </style>
    <!--[if IE 6]>
    <script type="text/javascript" src="${ctx}/js/DD_belatedPNG_0.0.8a-min.js"></script>
    <script type="text/javascript" src="${ctx}/js/ie6Fixpng.js"></script>
    <![endif]-->
    <title>新增收货地址</title>
</head>
<body>
<#include "${pageContext.request.getContextPath}/layout/header.ftl">
<div class="hr_15"></div>
<div class="comWidth clearfix products">
    <div class="leftArea">
        <#include "${pageContext.request.getContextPath}/user/left_menu.ftl">
    </div>
    <div class="rightArea">
        <table class="table">
            <form action="${ctx}/home/address/create" method="post">
                <tr>
                    <td style="width: 20%">收货人：</td><td><input type="text" name="receiver" class="big_input"></td>
                </tr>
                <tr>
                    <td>所在地区：</td><td><input type="text" name="area" class="big_input"></td>
                </tr>
                <tr>
                    <td>详细地址：</td><td><input type="text" value="" name="detail" class="big_input"></td>
                </tr>
                <tr>
                    <td>电话：</td><td><input type="text" value="" name="phone" class="big_input"></td>
                </tr>
                <tr>
                    <td>类型：</td><td>
                        <select name="addressType" class="select">
                            <option value="HOME">家</option>
                            <option value="COMPANY">公司</option>
                            <option value="OTHER">其它</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="center" colspan="2"><input type="submit" value="提交" class="btn"/></td>
                </tr>
            </form>
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

