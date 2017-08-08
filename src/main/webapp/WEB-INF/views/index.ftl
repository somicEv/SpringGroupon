<#import "macro/common.ftl" as common>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>${title}</title>
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
		<title>首页</title>
	</head>
	<body>
		<#include "layout/header.ftl">
		<div class="banner comWidth clearfix">
			<div class="banner_bar banner_big">
				<ul class="imgBox">
					<li><a href="#"><img src="${ctx}/images/banner/banner_01.jpg" alt="banner"></a></li>
					<li><a href="#"><img src="${ctx}/images/banner/banner_02.jpg" alt="banner"></a></li>
				</ul>
				<div class="imgNum">
					<a href="#" class="active"></a><a href="#"></a><a href="#"></a><a href="#"></a>
				</div>
			</div>
		</div>

		<#if indexCategoryDealDTOs??>
			<#list indexCategoryDealDTOs as dto>
				<div class="shopTit comWidth">
					<span class="icon"></span><h3>${dto.name}</h3>
					<a href="${ctx}/category/${dto.url_name}" class="more">更多&gt;&gt;</a>
				</div>
				<div class="shopList comWidth clearfix">
					<div class="leftArea">
						<div class="banner_bar banner_sm">
							<ul class="imgBox">
								<li><a href="#"><img src="images/banner/banner_sm_01.jpg" alt="banner"></a></li>
								<li><a href="#"><img src="images/banner/banner_sm_02.jpg" alt="banner"></a></li>
							</ul>
							<div class="imgNum">
								<a href="#" class="active"></a><a href="#"></a><a href="#"></a><a href="#"></a>
							</div>
						</div>
					</div>
					<div class="rightArea">
						<#if dto.first?exists>
							<div class="shopList_top clearfix">
								<#list dto.first as deal>
									<div class="shop_item">
										<div class="shop_img">
											<a href="${ctx}/item/${deal.skuId}"><img src="${helper.getDealImageUrlForIndexDeal1List(deal)}" alt=""></a>
										</div>
										<h3>${deal.dealTitle}</h3>
										<p><@common.formatPrice deal.dealPrice/></p>
                                        <#--<p>${deal.dealPrice}</p>-->
									</div>
								</#list>
							</div>
						</#if>
						<#if dto.second?exists>
							<div class="shopList_sm clearfix">
								<#list dto.second as deal>
									<div class="shopItem_sm">
										<div class="shopItem_smImg">
											<a href="${ctx}/item/${deal.skuId}"><img src="${helper.getDealImageUrlForIndexDeal2List(deal)}" alt=""></a>
										</div>
										<div class="shopItem_text">
											<p>${deal.dealTitle}</p>
											<h3><@common.formatPrice deal.dealPrice/></h3>
										</div>
									</div>
								</#list>
							</div>
						</#if>
					</div>
				</div>
			</#list>
		</#if>
		<#include "layout/footer.ftl">
	</body>
</html>