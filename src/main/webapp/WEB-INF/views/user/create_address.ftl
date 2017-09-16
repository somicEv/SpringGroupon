<#import "macro/paging.ftl" as paging_macro>
<#import "macro/common.ftl" as common>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="icon" href="images/favicon.ico" type="image/x-icon" />
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
    <link rel="bookmark" href="images/favicon.ico" type="image/x-icon" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.getContextPath}/style/reset.css">
    <link type="text/css" rel="stylesheet" href="${ctx}/style/main.css">
    <script type="text/javascript" src="${ctx}/js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/site.js"></script>
    <!--[if IE 6]>
    <script type="text/javascript" src="${ctx}/js/DD_belatedPNG_0.0.8a-min.js"></script>
    <script type="text/javascript" src="${ctx}/js/ie6Fixpng.js"></script>
    <![endif]-->
    <title>新增收货地址</title>
</head>
<body>
<#include "layout/header.ftl">
<div class="hr_15"></div>
<div class="comWidth clearfix products">
    <div class="leftArea">
        <#include "user/left_menu.ftl">
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
                        <select name="addressType" id="" class="select">
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
<#include "layout/footer.ftl">
</body>
</html>

