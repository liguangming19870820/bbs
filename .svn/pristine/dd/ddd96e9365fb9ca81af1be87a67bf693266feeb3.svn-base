<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/back_page/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>babasport-list</title>
<script type="text/javascript">
function getTableForm() {
	return document.getElementById('tableForm');
}
function changePageNo(){
	$("input[name='pageNo']").val(1);
}

</script>

</head>
<body>
	<div class="box-positon">
		<div class="rpos">当前位置: 库存管理 - 列表</div>
		<div class="clear"></div>
	</div>
	<div class="body-box">
		<form method="post" id="tableForm" action="/sku/list.do">
		<input type="hidden" value="" name="pageNo"/>
		<input type="hidden" value="" name="queryName"/>
		
			<table cellspacing="1" cellpadding="0" border="0" width="100%"
				class="pn-ltable">
				<thead class="pn-lthead">
					<tr>
						<th width="20"><input type="checkbox"
							onclick="Pn.checkbox('ids',this.checked)" /></th>
						<th>商品编号</th>
						<th>商品颜色</th>
						<th>商品尺码</th>
						<th>市场价格</th>
						<th>销售价格</th>
						<th>库 存</th>
						<th>购买限制</th>
						<th>运 费</th>
						<th>是否赠品</th>
						<th>操 作</th>
					</tr>
				</thead>
				<tbody class="pn-ltbody">
					<c:forEach items="${skuLists}" var="sku">
							<input type="hidden" value="${sku.productId }" name="productId"/>
						<tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'"
							onmouseout="this.bgColor='#ffffff'">
							<td><input type="checkbox" name="ids"  value="${sku.id }" /></td>
							<td>${product.no}</td>
							<td align="center"> ${colorMap.get(sku.colorId).name }</td>
							<td align="center">${sku.size}</td>
							<td align="center"><input type="text"  id="m52" name="marketPrice"
								value="${sku.marketPrice }" disabled="disabled" size="10" /></td>
							<td align="center"><input type="text"  id="s52" name="skuPrice"
								value="${sku.skuPrice }" disabled="disabled" size="10" /></td>
							<td align="center"><input type="text"  id="i52" name="stockInventory"
								value="${sku.stockInventory }" disabled="disabled" size="10" /></td>
							<td align="center"><input type="text"  id="l52" name="skuUpperLimit"
								value="${sku.skuUpperLimit }" disabled="disabled" size="10" /></td>
							<td align="center"><input type="text"  id="f52" name="deliveFee"
								value="${sku.deliveFee }" disabled="disabled" size="10" /></td>
							<td align="center"><c:if test="${sku.skuType =='1'}">不是</c:if>
								<c:if test="${sku.skuType =='0'}">是</c:if></td>
							<td align="center"><a href="javascript:updateSku(${sku.id })"
								class="pn-opt" id="xiu">修改</a> | <a href="javascript:addSku(${sku.id })"
								class="pn-opt" id="save">保存</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="page pb15">
			<span class="r inb_a page_b">
				<c:forEach items="${pagination.pageView }" var="page">
					${page }
				</c:forEach>
			</span>
			</div>
		</form>
	</div>
</body>
</html>
<script>
$(function(){
	$("#xiu").live("click",function(){
		var $parentTr = $(this).parent().parent();
		$parentTr.children("td:(4)").children("input").removeAttr("disabled");
		$parentTr.children("td:(5)").children("input").removeAttr("disabled");
		$parentTr.children("td:(6)").children("input").removeAttr("disabled");
		$parentTr.children("td:(7)").children("input").removeAttr("disabled");
		$parentTr.children("td:(8)").children("input").removeAttr("disabled");
	})
	
	$("#save").live("click",function(){
		
		
		var $parentTr = $(this).parent().parent();
		var marketPrice = $parentTr.children("td:eq(4)").children("input").val();
		var skuPrice = $parentTr.children("td:eq(5)").children("input").val();
		var stockInventory = $parentTr.children("td:eq(6)").children("input").val();
		var skuUpperLimit = $parentTr.children("td:eq(7)").children("input").val();
		var deliveFee = $parentTr.children("td:eq(8)").children("input").val();
		
		
		
		if(marketPrice == ""){
			alert("市场价不能为空");
			return;
		}
		if(skuPrice == ""){
			alert("售价不能为空");
			return;
		}
		if(stockInventory == ""){
			alert("库存不能为空");
			return;
		}
		if(skuUpperLimit == ""){
			alert("购买限制不能为空");
			return;
		}
		if(deliveFee == ""){
			alert("运费不能为空");
			return;
		}
		
		var productId = $("input[name='productId']").val();
		var id = $parentTr.children("td:eq(0)").children("input").val()
		
		
		$.ajax({
			url : '${pageContext.request.contextPath}/sku/update.do',
			data : {"id":id,"productId":productId,"marketPrice":marketPrice,"skuPrice":skuPrice,"stockInventory":stockInventory,"skuUpperLimit":skuUpperLimit,"deliveFee":deliveFee},
			type : 'post',
			cache : false,
			async :	false,
			dataType : 'json',
			beforeSend : function() {},
			success : function(data) {
				if(data == 0){
					$("#m52").attr("disabled",true);
					$("#s52").attr("disabled",true);
					$("#i52").attr("disabled",true);
					$("#l52").attr("disabled",true);
					$("#f52").attr("disabled",true);
					window.location.href="${pageContext.request.contextPath}/sku/list.do?id="+productId;
				}
			},
			error : function() {
				alert("系统异常");
			}
		});
		
	})
})
</script>

