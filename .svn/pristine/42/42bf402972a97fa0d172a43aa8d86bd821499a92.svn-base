<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/back_page/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<style type="text/css">
	#spanname{
		color:#F00;
	}
</style>
<head>
<title>babasport-add</title>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 品牌管理 - 添加</div>
	<form class="ropt">
		<input type="submit" onclick="this.form.action='/brand/list.do';" value="返回列表" class="return-button"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box" style="float:right">
	<form id="jvForm" action="/brand/save.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="id"/>
		<table cellspacing="1" cellpadding="2" width="100%" border="0" class="pn-ftable">
			<tbody>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						品牌名称:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="required" id="name" name="name" maxlength="100"/><span id="spanname" ></span>
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
						<img width="100" height="100" src="${path}/${brand.imgUrl } " id="allImgUrl"/>
						<input type="file" name="pic" onchange="uploadPic()"/>
						<input type="hidden" id="imgUrl" name="imgUrl"/>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						品牌描述:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="description" maxlength="80"  size="60"/>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						排序:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="sort" maxlength="80"/>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						是否可用:</td><td width="80%" class="pn-fcontent">
						<input type="radio" name="isDisplay" value="1" checked="checked"/>可用
						<input type="radio" name="isDisplay" value="0" checked="checked"/>不可用
					</td>
				</tr>
			</tbody>
			<tbody>
				<tr>
					<td class="pn-fbutton" colspan="2">
						<input type="button" id="submitbtn" class="submit" value="提交"/> &nbsp; <input type="reset" class="reset" value="重置"/>
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
	$("#name").blur(function(){
	var name = $.trim($("#name").val());
		if(name == ""){
			$("#spanname").html("请输入品牌名称");
		}else{
			$("#spanname").html("");
		}
		
	})
	$("#submitbtn").click(function(){
		var name = $.trim($("#name").val());
		var imgUrl = $.trim($("#imgUrl").val());
		
		if (name == "") {
			alert("请输入品牌名称");
			return;
		}
		if (imgUrl == "") {
			alert("请选择上传的图片");
			return;
		}
		$.ajax({
			url : '${pageContext.request.contextPath}/brand/save.do',
			data : $("#jvForm").serialize(),
			type : 'post',
			cache : false,
			dataType : 'json',
			beforeSend : function() {},
			success : function(data) {
				if (data == "1") {
					alert("请输入品牌名称");
					return;
				}
				if (data == "2") {
					alert("请选择上传的图片");
					return;
				}
				if (data == "3") {
					alert("该品牌已经存在");
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
			$("#allImgUrl").attr("src", data.url);
			$("#imgUrl").val(data.path);
		}
	};
	
	//jquery.form使用方式
	$("#jvForm").ajaxSubmit(options);
}
</script>