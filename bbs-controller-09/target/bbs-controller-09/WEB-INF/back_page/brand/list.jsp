<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/back_page/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>babasport-list</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 品牌管理 - 列表</div>
	<form class="ropt">
		<input class="add" type="button" value="添加" onclick="javascript:window.location.href='/brand/addinput.do'"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box">
<form action="/brand/list.do" method="post" style="padding-top:5px;">
品牌名称: <input type="text" name="name" value="${brandQuery.name }"/>
	<select name="isDisplay">
		<option value="1" <c:if test="${brandQuery.isDisplay==1 }">selected="selected"</c:if> >是</option>
		<option value="0" <c:if test="${brandQuery.isDisplay==0 }">selected="selected"</c:if> >不是</option>
	</select>
	<input type="submit" class="query" value="查询"/>
</form>
<table cellspacing="1" cellpadding="0" border="0" width="100%" class="pn-ltable">
	<thead class="pn-lthead">
		<tr>
			<th width="20"><input type="checkbox"  id="checkedall"/></th>
			<th>品牌ID</th>
			<th>品牌名称</th>
			<th>品牌图片</th>
			<th>品牌描述</th>
			<th>排序</th>
			<th>是否可用</th>
			<th>操作选项</th>
		</tr>
	</thead>
	<tbody class="pn-ltbody">
	<c:forEach items="${pagination.list }" var="brand">
		<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'">
			<td><input type="checkbox" name="ids" class="idclass" value="${brand.id }"/></td>
			<td align="center">${brand.id }</td>
			<td align="center">${brand.name}</td>
			<td align="center"><img width="40" height="40" src="${path}/${brand.imgUrl}"/></td>
			<td align="center">${brand.description }</td>
			<td align="center">${brand.sort }</td>
			<td align="center">${brand.isDisplay==1?'是':'否' }</td>
			<td align="center">
			<a class="pn-opt" href="${pageContext.request.contextPath}/brand/edit.do?id=${brand.id}&pageNo=${pageNo}">修改</a> | <a class="pn-opt"  href="${pageContext.request.contextPath}/brand/delete.do?id=${brand.id}">删除</a>
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
<div style="margin-top:15px;"><input class="del-button" type="button" value="删除" id="deletebtn" /></div>
</div>
</body>
</html>
<script>
$(function(){
	$("#checkedall").click(function(){
		var ischecked = $("#checkedall").attr("checked");
		if (ischecked == "checked") {
			$(".idclass").attr("checked",true);
		} else {
			$(".idclass").attr("checked",false);
		}
	})
	
	$("#deletebtn").click(function(){
		var count = $(".idclass:checked").size();
		alert(count);
		if (count < 1) {
			alert("请选择删除的用户");
			return;
		}
		if (!window.confirm("确定要删除吗？")) {
			return;
		}
		
			var ids="";
			$(".idclass:checked").each(function(){
				ids+=$(this).val()+","; 
			})
			ids=ids.substring(0, ids.lastIndexOf(","));
			$.ajax({
				url : '${pageContext.request.contextPath}/brand/deleteByIds.do',
				data : {"ids":ids},
				type : 'post',
				cache : false,
				dataType : 'json',
				beforeSend : function() {},
				success : function(data) {
					window.location.href="${pageContext.request.contextPath}/brand/list.do";
				},
				error : function() {
					alert("系统异常");
				}
			});
	})
})
</script>