<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/back_page/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
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
	<div class="rpos">当前位置: 商品管理 - 列表</div>
	<form class="ropt">
		<input class="add" type="button" value="添加" onclick="javascript:window.location.href='/product/addinput.do'"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box">
<form action="/product/list.do" id="searchform" method="post" style="padding-top:5px;">

名称: <input type="text" onkeyup="changePageNo()" value="${productQuery.name }" name="name"/>
	<select onchange="changePageNo()" name="brandId">
		<option value="" >请选择品牌</option>
		<c:forEach items="${brandList}" var="b">
			<option value="${b.id }" <c:if test="productQuery.brandId==b.id">selected="selected"</c:if>>${b.name }</option>
		</c:forEach>
	</select>
	<select onchange="changePageNo()" name="isShow">
		<option value="1" <c:if test="${productQuery.isShow==1 }">selected="selected"</c:if> >上架</option>
		<option value="0" <c:if test="${productQuery.isShow==0 }">selected="selected"</c:if> >下架</option>
	</select>
	<input type="submit" class="query" value="查询"/>
</form>
<form method="post" id="tableForm">
<input type="hidden" value="" name="pageNo"/>
<input type="hidden" value="" name="queryName"/>

<table cellspacing="1" cellpadding="0" width="100%" border="0" class="pn-ltable">
	<thead class="pn-lthead">
		<tr>
			<th width="20"><input type="checkbox" onclick="checkBox(this.checked)"/></th>
			<th>商品编号</th>
			<th>商品名称</th>
			<th>图片</th>
			<th width="4%">新品</th>
			<th width="4%">热卖</th>
			<th width="4%">推荐</th>
			<th width="4%">上下架</th>
			<th width="12%">操作选项</th>
		</tr>
	</thead>
	<tbody class="pn-ltbody">
	
	<c:forEach items="${pagination.list }" var="product">
		<tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
			<td><input type="checkbox" name="ids" no="${product.no }" class="idclass" value="${product.id }"/></td>
			<td>${product.no }</td>
			<td align="center">${product.name }</td>
			<td align="center"><img width="50" height="50" src="${path}${product.imgUrl}"/></td>
			<td align="center">${product.isNew==1?'是':'否'}</td>
			<td align="center">${product.isHot==1?'是':'否'}</td>
			<td align="center">${product.isCommend==1?'是':'否'}</td>
			<td align="center">${product.isShow==1?'上架':'下架'}</td>
			<td align="center">
			<a href="${pageContext.request.contextPath}/product/detail.do?id=${product.id}" class="pn-opt">查看</a> | <a href="${pageContext.request.contextPath}/product/edit.do?id=${product.id}" class="pn-opt">修改</a> | <a href="javascript:void(0)" onclick="if(!confirm('您确定删除吗？')) {return false;}" class="pn-opt" onclick="deleteobj(${product.id})" >删除 </a> | <a href="${pageContext.request.contextPath}/sku/list.do?id=${product.id}" class="pn-opt">库存</a>
			</td>
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
<div style="margin-top:15px;"><input class="del-button" type="button" value="删除" onclick="optDelete();" /><input class="add" type="button" value="上架" onclick="isShow();"/><input class="del-button" type="button" value="下架" onclick="isDown();"/></div>
</form>
</div>
</body>
</html>
<script>
function deleteobj(productId){
	if (!confirm("确定要删除吗？")) {
		return;
	}
	$.ajax({
		url : '${pageContext.request.contextPath}/product/delete.do',
		data : {"id":productId},
		type : 'post',
		cache : false,
		dataType : 'json',
		beforeSend : function() {},
		success : function(data) {
			if (data == "1") {
				window.location.href="${pageContext.request.contextPath}/product/list.do";
			}
		},
		error : function() {
			alert("系统异常");
		}
	});
}
function checkBox(ischecked){
	$("input[name='ids']").attr("checked", ischecked);
}

function isShow() {
	var count = $("input[name='ids']:checked").size();
	if (count < 1) {
		alert("请选择要上架的商品");
		return;
	}
	if (!confirm("确定要上架吗?")) {
		return;
	}
	var msg = "";
	var flag = true;
	$("input[name='ids']:checked").each(function(){
		var id = $(this).val();
		var no = $("input[name='ids']:checked").attr("no");
		$.ajax({
			url : '${pageContext.request.contextPath}/product/isShow.do',
			data : {"ids":id},
			type : 'post',
			cache : false,
			/* 同步 */
			async :	false,
			dataType : 'json',
			beforeSend : function() {},
			success : function(data) {
				if (data == "1") {
					msg += "商品编号为"+no+"的商品不存在\r\n";
					flag = false;
				} else if (data == "2") {
					msg += "商品编号为"+no+"的商品已经删除\r\n";
					flag = false;
				} else if (data == "3") {
					msg += "商品编号为"+no+"的商品处于上架状态\r\n";
					flag = false;
				}
			},
			error : function() {
				alert("系统异常");
			}
		});
	})
	if (flag) {
		alert("上架成功");
	} else {
		alert(msg);
	}
	$("#searchform").submit();
}


function isDown(){
	
	var count = $("input[name='ids']:checked").size();
	if (count < 1) {
		alert("请选择要下架的商品");
		return;
	}
	if (!confirm("确定要下架吗?")) {
		return;
	}
	var msg = "";
	var flag = true;
	$("input[name='ids']:checked").each(function(){
		var id = $(this).val();
		var no = $("input[name='ids']:checked").attr("no");
		$.ajax({
			url : '${pageContext.request.contextPath}/product/isDown.do',
			data : {"ids":id},
			type : 'post',
			cache : false,
			async :	false,
			dataType : 'json',
			beforeSend : function() {},
			success : function(data) {
				if (data == "1") {
					msg += "商品编号为"+no+"的商品不存在\r\n";
					flag = false;
				} else if (data == "2") {
					msg += "商品编号为"+no+"的商品已经删除\r\n";
					flag = false;
				} else if (data == "3") {
					msg += "商品编号为"+no+"的商品处于下架状态\r\n";
					flag = false;
				}
			},
			error : function() {
				alert("系统异常");
			}
		});
	})
	if (flag) {
		alert("下架成功");
	} else {
		alert(msg);
	}
	$("#searchform").submit();
}

function optDelete() {
	var count = $("input[name='ids']:checked").size();
	if (count < 1) {
		alert("请选择要删除的商品");
		return;
	}
	if (!confirm("确定要删除吗?")) {
		return;
	}
	var msg = "";
	var flag = true;
	$("input[name='ids']:checked").each(function(){
		var id = $(this).val();
		$.ajax({
			url : '${pageContext.request.contextPath}/product/delete.do',
			data : {"id":id},
			type : 'post',
			cache : false,
			async :	false,
			dataType : 'json',
			beforeSend : function() {},
			success : function(data) {
				if (data == "1") {
					msg += "商品编号为"+id+"的商品不存在\r\n";
					flag = false;
				} else if (data == "2") {
					msg += "商品编号为"+id+"的商品处于上架状态\r\n";
					flag = false;
				} else if (data == "3") {
					msg += "商品编号为"+id+"的商品已经删除\r\n";
					flag = false;
				}
			},
			error : function() {
				alert("系统异常");
			}
		});
	})
	if (flag) {
		alert("删除成功");
	} else {
		alert(msg);
	}
	$("#searchform").submit();
}

</script>