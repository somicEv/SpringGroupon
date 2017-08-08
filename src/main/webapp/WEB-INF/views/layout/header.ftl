<div class="headerBar">
    <#include "${pageContext.request.getContextPath}/layout/topbar.ftl">
    <#include "${pageContext.request.getContextPath}/layout/logobar.ftl">
    <#if categories??>
        <div class="navBox">
            <div class="comWidth clearfix">
                <div class="shopClass fl">
                    <h3>全部商品分类<i class="shopClass_icon"></i></h3>
                    <div class="shopClass_show">
                        <#list categories as category>
                            <dl class="shopClass_item">
                                <dt><a href="${ctx}/category/${category.url_name}" class="b">${category.name}</a></dt>
                                <dd>
                                    <#if category.children??>
                                        <#list category.children as child>
                                            <a href="${ctx}/category/${child.url_ame}">${child.name}</a>
                                        </#list>
                                    </#if>
                                </dd>
                            </dl>
                        </#list>
                    </div>
                </div>
                <ul class="nav fl">
                    <li><a href="${ctx}" <#if controller?? && controller=="index">class="active"</#if>>团购</a></li>
                    <li><a href="${ctx}" <#if controller?? && controller=="takeout">class="active"</#if>>二手特卖</a></li>
                </ul>
            </div>
        </div>
    </#if>
</div>