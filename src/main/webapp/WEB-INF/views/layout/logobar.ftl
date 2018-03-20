<div class="logoBar" style="background-color: #ffffff">
    <div class="comWidth">
        <div class="logo fl">
            <a href="${ctx}/index"><img src="${ctx}/images/logos/logo.png" style="width: 124px;height: 40px;"></a>
        </div>
        <div class="search_box fl">
            <form action="/search" id="search_form" method="get">
                <div class="box-search" style="height: 73px;">
                    <input type="text" name="search" placeholder="Search what you looking for ?">
                    <span class="btn-search">
                        <button type="submit" class="waves-effect" style="top: -48px;left: 250px;">
                            <img src="${ctx}/images/icons/search.png" alt="">
                        </button>
                    </span>
                </div><!-- /.box-search -->
            </form>
        </div>
        <!-- /.col-md-3 -->
        <div class="shopCar fr">
            <span class="fl"><#--<a href="${ctx}/cart">购物车</a>-->
            <#--<div class="col-md-3">-->
                <div class="box-cart" style="padding: 0px;">
                    <div class="inner-box">
                        <a href="${pageContext.request.contentPath}/home/favorite" title="">
                            <div class="icon-cart" style="margin-right: 20px;">
                                <img src="${pageContext.request.contextPath}/images/icons/wishlist.png" alt=""
                                     style="margin-top: 12px;">
                            </div>
                        </a>
                    </div><!-- /.inner-box -->
                    <div class="inner-box">
                        <a href="${ctx}/cart" title="">
                            <div class="icon-cart">
                                <img src="${pageContext.request.contextPath}/images/icons/cart.png" alt=""
                                     style="margin-top: 10px;">
                            </div>
                        </a>
                    </div><!-- /.inner-box -->
                </div><!-- /.box-cart -->
            </span>
        </div>
    </div>
</div>