<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/back_page/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>babasport-edit</title>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 品牌管理 - 添加</div>
	<form class="ropt">
	<input type="hidden" name="pageNo" value="${pageNo}"/>
		<input type="submit" onclick="this.form.action='/brand/list.do';" value="返回列表" class="return-button"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box" style="float:right">
	<form id="jvForm" action="/brand/update.do" method="post">
	<input type="hidden" name="id" value="${brand.id }"/>
		<table cellspacing="1" cellpadding="2" width="100%" border="0" class="pn-ftable">
			<tbody>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						品牌名称:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="required" disabled="disabled" name="name" maxlength="100" value="${brand.name }"/>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						上传商品图片(90x150尺寸):</td>
						<td width="80%" class="pn-fcontent">
						注:该尺寸图片必须为90x150。
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h"></td>
						<td width="80%" class="pn-fcontent">
						<img width="100" height="100" src="${path}/${brand.imgUrl } " id="product_url"/>
						<input type="hidden" name="picPath" id="imgUrl"/>
						<input type="file" onchange="uploadPic()" name="pic"/>
					</td>

				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						品牌描述:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="description" maxlength="80"  size="60" value="${brand.description }"/>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						排序:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="sort" maxlength="80" value="${brand.sort }"/>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						是否可用:</td><td width="80%" class="pn-fcontent">
						<input type="radio" <c:if test="${brand.isDisplay==1}">checked="checked"</c:if> name="isDisplay" value="1"   />可用
						<input type="radio" <c:if test="${brand.isDisplay==0}">checked="checked"</c:if> name="isDisplay" value="0"/>不可用
					</td>
				</tr>
			</tbody>
			<tbody>
				<tr>
					<td class="pn-fbutton" colspan="2">
					<input type="hidden" name= "pageNo" value="${pageNo}"/>
						<input type="submit" id="submitbtn" class="submit" value="提交"/> &nbsp; <input type="reset" class="reset" value="重置"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
</body>
</html>
<script>
$(function(){
	$("#submitbtn").click(function(){
		var imgUrl = $.trim($("#imgUrl").val());
		
		if (imgUrl == "") {
			alert("请选择上传的图片");
			return;
		}
		$.ajax({
			url : '${pageContext.request.contextPath}/brand/update.do',
			data : $("#jvForm").serialize(),
			type : 'post',
			cache : false,
			dataType : 'json',
			beforeSend : function() {},
			success : function(data) {
				if (data == "1") {
					alert("请选择上传的图片");
					return;
				}
				if (data == "0") {
					window.location.href="${pageContext.request.contextPath}/brand/list.do";
				}
			},
			error : function() {
				alert("系统异常");
			}
		});
	})
})
function uploadPic() {
	//定义参数
	var options = {
		url : "/upload/uploadPic.do",
		dataType : "json",
		type :  "post",
		success : function(data){
			$("#product_url").attr("src", data.url);
			$("#imgUrl").val(data.path);
		}
	};
	
	//jquery.form使用方式
	$("#jvForm").ajaxSubmit(options);
}
</script>