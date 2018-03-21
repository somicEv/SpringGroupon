<div class="headerBar">
<#include "${pageContext.request.getContextPath}/layout/topbar.ftl">
<#include "${pageContext.request.getContextPath}/layout/logobar.ftl">
<#if indexCategoryDealDTOs??>
    <div class="navBox" style="height: 66px;">
        <div class="comWidth clearfix">
            <div class="shopClass fl">
                <div>
                    <div class="container">
                        <div class="row">
                            <div class="col-md-3 col-2">
                                <div id="mega-menu">
                                    <div class="btn-mega"><span></span>
                                        所有分类
                                    </div>
                                    <ul class="menu">
                                        <#list indexCategoryDealDTOs as dto>
                                            <li>
                                                <a href="${ctx}/category/${dto.category.url_name}" title="">
                                                    <span class="menu-img">
                                                        <img src="images/icons/menu/01.png" alt="">
                                                    </span>
                                                    <span class="menu-title">${dto.category.name}</span>
                                                </a>
                                            </li>
                                        </#list>
                                    </ul>
                                </div>
                            </div><!-- /.col-md-3 -->

                        </div><!-- /.row -->
                    </div><!-- /.container -->
                </div><!-- /.header-bottom -->
            </div>
            <ul class="nav fl">
                <div class="nav-wrap menu">
                    <div id="mainnav" class="mainnav" style="padding-left: 96px;margin-top: 32px;height: 22px;">
                        <ul class="menu">
                            <li class="column-1">
                                <a href="${pageContext.request.contentPath}/index" title="">首页</a>
                            </li><!-- /.column-1 -->
                            <li class="column-1">
                                <a href="#" title="">便民服务</a>
                            </li><!-- /.column-1 -->
                            <li class="has-mega-menu">
                                <a href="#" title="">电子报刊</a>
                            </li><!-- /.has-mega-menu -->
                        </ul><!-- /.menu -->
                    </div><!-- /.mainnav -->
                </div><!-- /.nav-wrap -->
            </ul>
        </div>
    </div>
</#if>
</div>