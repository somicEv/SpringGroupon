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
    <title>消息提醒</title>
</head>
<body>
<#include "layout/header.ftl">
<div class="hr_15"></div>
<div class="comWidth clearfix products">
    <div class="leftArea">
        <#include "user/left_menu.ftl">
    </div>
    <div class="rightArea">
        <h3 class="shopping_tit">消息提醒</h3>
        <!--表格-->
        <table class="table" cellspacing="0" cellpadding="0">
            <thead>
            <tr>
                <th width="20%">标题</th>
                <th width="60%">内容</th>
                <th width="10%">状态</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
                <#if messages??>
                    <#list messages as message>
                        <tr>
                            <td>${message.title}</td>
                            <td>${message.content}</td>
                            <td><@common.formatMessageStatus message.readed/></td>
                            <td>
                                <a href="javascript:void(0)" class="btn_link" onclick="">已读&nbsp;&nbsp;</a>
                                <a href="javascript:void(0)" class="btn_link" onclick="">删除</a>
                            </td>
                        </tr>
                    </#list>
                <#else>
                    <p>您还没有消息</p>
                </#if>
            </tbody>
        </table>
    </div>
</div>
<#include "layout/footer.ftl">
</body>
</html>

