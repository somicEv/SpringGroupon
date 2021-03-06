<#import "${pageContext.request.getContextPath}/macro/common.ftl" as common>
<html>
<head>
    <meta charset="utf-8">
    <title>购物车</title>
    <link rel="icon" href="images/favicon.ico" type="image/x-icon"/>
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon"/>
    <link rel="bookmark" href="images/favicon.ico" type="image/x-icon"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.getContextPath}/style/reset.css">
    <link type="text/css" rel="stylesheet" href="${ctx}/style/main.css">
    <link type="text/css" rel="stylesheet" href="${ctx}/stylesheets/style.css"/>
    <link type="text/css" rel="stylesheet" href="${ctx}/stylesheets/waves.min.css"/>
<#--   <link type="text/css" rel="stylesheet" href="${ctx}/stylesheets/shortcodes.css"/>-->
    <link rel="stylesheet" type="text/css" href="${ctx}/stylesheets/responsive.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/stylesheets/bootstrap.min.css">
    <style>
        input[type="checkbox"] {
            opacity: unset;

        }

        input[type="text"] {
            padding: 0;
            border: hidden;
            border-radius: inherit;
            height: 31px;
        }

        .des_number {
            width: 57px;
        }
    </style>
    <script type="text/javascript" src="${ctx}/javascript/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/site.js"></script>

    <script type="text/javascript">
        var ctx = '${ctx}';

        function check(object, cartId) {
            console.log(321);
            if (object.checked) {
                alert(1);
            } else {
                alert(2);
            }

            var val = Number(0);//声明一个数组保存结果
            var chk = document.getElementsByTagName("input");
            var cartIds = '';
            for (var i = 0; i < chk.length; i++) {
                if (chk[i].type == 'checkbox' && chk[i].checked) {
                    val += Number(document.getElementById('subtotal_' + chk[i].id).value);
                    cartIds += chk[i].id + ',';
                }
            }
            var totalSpan = document.getElementsByTagName("span");
            totalSpan[0].innerHTML = '￥' + val / 100;

            document.getElementById("totalPrice").value = val;
            document.getElementById("cartIds").value = cartIds.substring(0, cartIds.length - 1);
        }

        function dealCount(type, cartId, maxPurchaseCount) {
            var id = 'count_' + cartId;
            var id_subtotal_price = 'subtotal_price_' + cartId;
            var id_subtotal = 'subtotal_' + cartId;
            if (type == 1) {
                var addCount = Number(document.getElementById(id).value);
                if (addCount >= maxPurchaseCount) {
                    document.getElementById(id).value = maxPurchaseCount;
                } else {
                    document.getElementById(id).value = addCount + 1;
                    Submit.AjaxSubmit(ctx + '/cart/' + cartId + '/1');
                }
                var add_update_count = Number(document.getElementById(id).value);
                var add_update_price = Number(document.getElementById('price_' + cartId).value);
                // TODO
                var addTotalCount = (add_update_count) * add_update_price;
                // input hidden 的值
                document.getElementById(id_subtotal).value = addTotalCount;
                console.log(add_update_count + ',' + add_update_price + ',' + addTotalCount + ',' + document.getElementById(id_subtotal).value);
                // 页面显示的值
                document.getElementById(id_subtotal_price).innerText = '￥' + addTotalCount / 100;
            } else {
                var subCount = Number(document.getElementById(id).value);
                if (subCount <= 1) {
                    document.getElementById(id).value = 1;
                } else {
                    document.getElementById(id).value = subCount - 1;
                    Submit.AjaxSubmit(ctx + '/cart/' + cartId + '/0');
                }
                var sub_update_count = Number(document.getElementById(id).value);
                var sub_update_price = Number(document.getElementById('price_' + cartId).value);
                var subTotalCount = (sub_update_count) * sub_update_price;
                // input hidden 的值
                document.getElementById(id_subtotal).value = subTotalCount;
                console.log(sub_update_count + ',' + sub_update_price + ',' + subTotalCount + ','/*+document.getElementById(id_subtotal).value*/);
                // 页面显示的值
                document.getElementById(id_subtotal_price).innerText = '￥' + subTotalCount / 100;
            }
        }
        
        function deleteDealCart(cartId) {
            Submit.AjaxSubmit(ctx + '/cart/delete/' + cartId);

        }
    </script>
</head>

<body>
<div class="headerBar">
<#include "${pageContext.request.getContextPath}/layout/topbar.ftl">
    <div class="logoBar">
        <div class="comWidth">
            <div class="logo fl">
                <a href="${ctx}/index"><img src="${ctx}/images/logos/logo.png" alt="慕课网"></a>
            </div>
            <div class="stepBox fr">
                <div class="step"></div>
                <ul class="step_text">
                    <li class="s01 active">提交订单</li>
                    <li class="s02">确认订单</li>
                    <li class="s03">购买成功</li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="shoppingCart comWidth">
    <div class="shopping_item">
        <h3 class="shopping_tit">购物车</h3>
        <div class="shopping_cont pb_10">
            <div class="cart_inner">
                <div class="cart_head clearfix">
                    <div class="cart_item t_name">商品名称</div>
                    <div class="cart_item t_price">单价</div>
                    <div class="cart_item t_num">数量</div>
                    <div class="cart_item t_return">折扣</div>
                    <div class="cart_item t_subtotal">小计</div>
                    <div class="cart_item t_status">状态</div>
                    <div class="cart_item t_operate">操作</div>
                </div>
            <#if carts??>
                <#list carts as cart>
                    <div class="cart_cont clearfix">

                        <div class="cart_item t_name">
                            <div class="cart_shopInfo clearfix">
                                <input type="checkbox" id="${cart.cart.id}" onclick="check(this, ${cart.cart.id})"
                                       style="float:left; margin-top:40px; margin-right: 10px;border: solid 5px #000000;"/>
                                <div>
                                    <img src="${pageContext.request.contextPath}/${helper.getDealImageUrlForDealCart(cart.cart)}"
                                         alt="">
                                    <div class="cart_shopInfo_cont">
                                        <p class="cart_link"><a
                                                href="${ctx}/item/${cart.deal.skuId}">${cart.deal.dealTitle}</a></p>
                                        <p class="cart_info">7天退换</p>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="cart_item t_price" id="cart_item_price">
                            <input id="price_${cart.cart.id}" type="hidden" value="${cart.deal.dealPrice}">
                            <@common.formatPrice cart.deal.dealPrice/>
                        </div>
                        <div class="cart_item t_num">
                            <div class="des_number">
                                <div class="reduction"
                                     onclick="dealCount(0, '${cart.cart.id}', '${cart.deal.maxPurchaseCount}')">-
                                </div>
                                <div class="des_input">
                                    <#if (cart.cart.dealCount > cart.deal.maxPurchaseCount)>
                                        <input type="text" id="count_${cart.cart.id}" name="count"
                                               value="${cart.deal.maxPurchaseCount}" readonly>
                                    <#else>
                                        <input type="text" id="count_${cart.cart.id}" name="count"
                                               value="${cart.cart.dealCount}" readonly>
                                    </#if>
                                </div>
                                <div class="plus"
                                     onclick="dealCount(1, '${cart.cart.id}', '${cart.deal.maxPurchaseCount}')">+
                                </div>
                            </div>
                        </div>
                        <div class="cart_item t_return"><@common.formatDiscount cart.deal.discount/></div>
                        <div class="cart_item t_subtotal t_red">
                            <input id="subtotal_${cart.cart.id}" type="hidden" value="${cart.subtotal}">
                            <p id="subtotal_price_${cart.cart.id}"><@common.formatPrice cart.subtotal/></p>
                        </div>
                        <div class="cart_item t_status">
                            <#if cart.deal.start>
                                进行中
                            <#elseif cart.deal.end>
                                已结束
                            <#else>
                                未开始
                            </#if>
                        </div>
                        <div class="cart_item t_operate"><a href="#" onclick="deleteDealCart(${cart.cart.id})" class="btn_link">删除</a></div>
                    </div>
                </#list>
                <div class="cart_message">
                    若有问题请留言
                </div>
            <#else>
                <div class="cart_message">
                    购物车内还没有商品~~
                </div>
            </#if>

            </div>
        </div>
    </div>
    <div class="hr_25"></div>
    <div class="shopping_item">
    <#--<h3 class="shopping_tit">订单结算</h3>-->
        <div class="shopping_cont padding_shop clearfix">
            <div class="cart_count fr">
                <div class="cart_rmb">
                    <i>总计：</i><span></span>
                </div>
                <div class="settlement_btnBox">
                    <form action="${ctx}/settlement" method="post" id="settlement_form">
                        <input type="hidden" id="totalPrice" name="totalPrice">
                        <input type="hidden" id="cartIds" name="cartIds">
                        <input type="submit" class="settlement_btn" value="提交订单">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "${pageContext.request.getContextPath}/layout/footer.ftl">
</body>
</html>
