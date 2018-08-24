<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>我的购物车</title>
<link rel="stylesheet" href="/res/css/style.css" />
<script src="/res/js/jquery.js"></script>
<script src="/res/js/com.js"></script>
<script type="text/javascript">
//结算
function trueBuy(){
 	window.location.href = "productOrder.jsp";
}
</script>
</head>
<body>
<div class="bar"><div class="bar_w">
	<p class="l">
		<span class="l">
			收藏本网站！北京<a href="#" title="更换">[更换]</a>
		</span>
	</p>
	<ul class="r uls">
		<li class="dev">
			您好,欢迎来到新巴巴运动网！
		</li>
	<li class="dev"><a href="javascript:void(0)" onclick="login()"  title="登陆">[登陆]</a></li>
	<li class="dev"><a href="javascript:void(0)" onclick="register()" title="免费注册">[免费注册]</a></li>
	<li class="dev"><a href="javascript:void(0)" onclick="logout()" title="退出">[退出]</a></li>
	<li class="dev"><a href="javascript:void(0)" onclick="myOrder()" title="我的订单">我的订单</a></li>
	<li class="dev"><a href="#" title="在线客服">在线客服</a></li>
	<li class="dev after"><a href="#" title="English">English</a></li>
	</ul>
</div></div>
<ul class="ul step st3_1">
<li title="1.我的购物车" class="here">1.我的购物车</li>
<li title="2.填写核对订单信息">2.填写核对订单信息</li>
<li title="3.成功提交订单">3.成功提交订单</li>
</ul>
<div class="w ofc case">
	<div class="confirm">
		<div class="tl"></div><div class="tr"></div>
		<div class="ofc pb40">

			<div class="page">
				<b class="l f14 blue pt48">
					我挑选的商品：
				</b>
			</div>
			<table cellspacing="0" class="tab tab4" summary="">
			<thead>
			<tr>
			<th class="wp">商品</th>
			<th>单价（元）</th>
			<th>数量</th>
			<th>操作</th>
			</tr>     
			</thead>
			<tbody id="tbodyobj">
				<c:forEach items="${list }" var="cart">
				<tr id="tr${cart.skuId }">
					<td class="nwp pic">
						<ul class="uls">
							<li>
								<a class="pic" title="${cart.name }" href="javascript:void(0)"><img alt="${cart.name }" src="${path }${cart.url }"></a>
								<dl>
									<dt><a title="${cart.name }" href="javascript:void(0)"> ${cart.name }--${cart.colorName }--${cart.size }</a></dt>
								</dl>
							</li>
						</ul>
					</td>
					<td>￥${cart.price }</td>
					<td><a onclick="subProductAmount(${cart.skuId})" class="inb arr" title="减" href="javascript:void(0);">-</a><input type="text" id="num${cart.skuId }" readonly="readonly" value="${cart.buycount }" name="" size="1" price=${cart.price } class="txts"><a onclick="addProductAmount(${cart.skuId}, ${cart.buylimit }, ${cart.count })" class="inb arr" title="加" href="javascript:void(0);">+</a></td>
					<td class="blue"><a onclick="delProduct(${cart.skuId})" title="删除" href="javascript:void(0);">删除</a></td>
				</tr>
				</c:forEach>
			</tbody>
			</table>
			<div class="page">
				<span class="l">
					<input type="button" onclick="window.open('/product/detail.do?id=${productId}')" class="hand btn100x26c" title="继续购物" value="继续购物">
					<input type="button" onclick="clearCart()" class="hand btn100x26c" title="清空购物车" value="清空购物车">
				</span>
				<span class="r box_gray">
					<dl class="total">
						<dt>购物车金额小计：<cite>(共<var id="productAmount">3</var>个商品)</cite></dt>
						<dd><em class="l">商品金额：</em>￥<var id="productPrice">689.01</var>元</dd>
						<dd><em class="l">运费：</em>￥<var id="fee">0.0</var>元</dd>
						<dd class="orange"><em class="l">应付总额：</em>￥<var id="totalPrice">689.01</var>元</dd>
						<dd class="alg_c"><input type="button" onclick="trueBuy();" class="hand btn136x36a" value="结算" id="settleAccountId"></dd>
					</dl>
				</span>
			</div>
		</div>
	</div>
</div>
<div class="w ofc case" style="display: none;">
	<div class="confirm">
		<div class="tl"></div><div class="tr"></div>
		<div class="ofc pb40" style="text-align: center;height: 200px;margin-top: 80px">
       		 <a href="http://localhost:8080" style="color: red;font-size: 30px;">去首页</a>挑选喜欢的商品
		</div>
	</div>
</div>
<div class="mode">
	<div class="tl"></div><div class="tr"></div>
	<ul class="uls">
		<li class="first">
			<span class="guide"></span>
			<dl>
			<dt title="购物指南">购物指南</dt>
			<dd><a href="#" title="购物流程">购物流程</a></dd>
			<dd><a href="#" title="购物流程">购物流程</a></dd>
			<dd><a href="#" target="_blank" title="联系客服">联系客服</a></dd>
			<dd><a href="#" target="_blank" title="联系客服">联系客服</a></dd>
			</dl>
		</li>
		<li>
			<span class="way"></span>
			<dl>
			<dt title="支付方式">支付方式</dt>
			<dd><a href="#" title="货到付款">货到付款</a></dd>
			<dd><a href="#" title="在线支付">在线支付</a></dd>
			<dd><a href="#" title="分期付款">分期付款</a></dd>
			<dd><a href="#" title="分期付款">分期付款</a></dd>
			</dl>
		</li>
		<li>
			<span class="help"></span>
			<dl>
			<dt title="配送方式">配送方式</dt>
			<dd><a href="#" title="上门自提">上门自提</a></dd>
			<dd><a href="#" title="上门自提">上门自提</a></dd>
			<dd><a href="#" title="上门自提">上门自提</a></dd>
			<dd><a href="#" title="上门自提">上门自提</a></dd>
			</dl>
		</li>
		<li>
			<span class="service"></span>
			<dl>
			<dt title="售后服务">售后服务</dt>
			<dd><a href="#" target="_blank" title="售后策略">售后策略</a></dd>
			<dd><a href="#" target="_blank" title="售后策略">售后策略</a></dd>
			<dd><a href="#" target="_blank" title="售后策略">售后策略</a></dd>
			<dd><a href="#" target="_blank" title="售后策略">售后策略</a></dd>
			</dl>
		</li>
		<li>
			<span class="problem"></span>
			<dl>
			<dt title="特色服务">特色服务</dt>
			<dd><a href="#" target="_blank" title="夺宝岛">夺宝岛</a></dd>
			<dd><a href="#" target="_blank" title="夺宝岛">夺宝岛</a></dd>
			<dd><a href="#" target="_blank" title="夺宝岛">夺宝岛</a></dd>
			<dd><a href="#" target="_blank" title="夺宝岛">夺宝岛</a></dd>
			</dl>
		</li>
	</ul>
</div>
</body>
</html>
<script>
$(function(){
	totalcount();
	totalprice();
})
function addProductAmount(skuId, buylimit, count) {
	var num = $("#num"+skuId).val();
	if (num >= buylimit) {
		alert("已经超过购买限制");
		return;
	}
	if (num >= count) {
		alert("没有库存了");
		return;
	}
	$.ajax({
		url : '${pageContext.request.contextPath}/cart/many.do',
		data : {"id":skuId},
		type : 'post',
		cache : false,
		dataType : 'json',
		aysnc : false,
		beforeSend : function() {},
		success : function(data) {
			$("#num"+skuId).val(data);
			totalcount();
			totalprice();
		},
		error : function() {
			alert("系统异常");
		}
	});
}

function subProductAmount(skuId) {
	var num = $("#num"+skuId).val();
	if (num <= 1) {
		return;
	}
	$.ajax({
		url : '${pageContext.request.contextPath}/cart/little.do',
		data : {"id":skuId},
		type : 'post',
		cache : false,
		dataType : 'json',
		aysnc : false,
		beforeSend : function() {},
		success : function(data) {
			$("#num"+skuId).val(data);
			totalcount();
			totalprice();
		},
		error : function() {
			alert("系统异常");
		}
	});
}

function delProduct(skuId) {
	if (!confirm("确定要删除吗？")) {
		return;
	}
	$.ajax({
		url : '${pageContext.request.contextPath}/cart/delete.do',
		data : {"id":skuId},
		type : 'post',
		cache : false,
		dataType : 'json',
		aysnc : false,
		beforeSend : function() {},
		success : function(data) {
			$("#tr"+skuId).remove();
			totalcount();
			totalprice();
		},
		error : function() {
			alert("系统异常");
		}
	});
}

function clearCart() {
	if (!confirm("确定要清空吗？")) {
		return;
	}
	
	$.ajax({
		url : '${pageContext.request.contextPath}/cart/deletes.do',
		data : {},
		type : 'post',
		cache : false,
		dataType : 'json',
		aysnc : false,
		beforeSend : function() {},
		success : function(data) {
			$("#tbodyobj").html("");
			totalcount();
			totalprice();
		},
		error : function() {
			alert("系统异常");
		}
	});
}

function totalcount() {
	var count = 0;
	$(".txts").each(function(){
		count += parseInt($(this).val());
	})
	$("#productAmount").html(count);
}

function totalprice() {
	var totalprice = 0.0;
	$(".txts").each(function(){
		var num = parseInt($(this).val());
		var price = parseFloat($(this).attr("price"));
		totalprice += num * price;
	})
	$("#productPrice").html(totalprice);
	$("#totalPrice").html(totalprice);
}
</script>