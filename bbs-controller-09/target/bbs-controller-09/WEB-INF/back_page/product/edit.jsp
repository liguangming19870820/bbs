<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/back_page/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>babasport-add</title>
<style type="">
.h2_ch a:hover, .h2_ch a.here {
    color: #FFF;
    font-weight: bold;
    background-position: 0px -32px;
}
.h2_ch a {
    float: left;
    height: 32px;
    margin-right: -1px;
    padding: 0px 16px;
    line-height: 32px;
    font-size: 14px;
    font-weight: normal;
    border: 1px solid #C5C5C5;
    background: url('/res/itcast/img/admin/bg_ch.gif') repeat-x scroll 0% 0% transparent;
}
a {
    color: #06C;
    text-decoration: none;
}
</style>
<script type="text/javascript">
$(function(){
	var tObj;
	$("#tabs a").each(function(){
		// 0  -1 -1  
		//找不到就是-1  找到就是0
		
		if($(this).attr("class").indexOf("here") == 0){tObj = $(this)}
		$(this).click(function(){
			//here  nor
			var c = $(this).attr("class");
			//
			if(c.indexOf("here") == 0){return;}
			var ref = $(this).attr("ref");
			var ref_t = tObj.attr("ref");
			tObj.attr("class","nor");
			$(this).attr("class","here");
			$(ref_t).hide();
			$(ref).show();
			tObj = $(this);
			if(ref == '#tab_2'){
				var fck = new FCKeditor("productdesc");
				fck.BasePath = "/res/fckeditor/";
				fck.Height = 400 ;
				fck.Config["ImageUploadURL"] = "/upload/uploadFck.do";
				fck.ReplaceTextarea();
			}
		});
	});
});
</script>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 商品管理 - 修改</div>
	<form class="ropt">
		<input type="submit" onclick="this.form.action='/product/list.do';" value="返回列表" class="return-button"/>
	</form>
	<div class="clear"></div>
</div>
<h2 class="h2_ch"><span id="tabs">
<a href="javascript:void(0);" ref="#tab_1" title="基本信息" class="here">基本信息</a>
<a href="javascript:void(0);" ref="#tab_2" title="商品描述" class="nor">商品描述</a>
<a href="javascript:void(3);" ref="#tab_3" title="商品参数" class="nor">包装清单</a>
</span></h2>
<div class="body-box" style="float:right">
	<form id="jvForm" action="/product/update.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="id" value="${product.id }"/>
		<table cellspacing="1" cellpadding="2" width="100%" border="0" class="pn-ftable">
			<tbody id="tab_1">
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						商品类型:</td><td width="80%" class="pn-fcontent">
								<select id="typeId" name="typeId">
									<option value="">请选择</option>
									<c:forEach items="${typeList}" var="t">
										<option value="${t.id }" <c:if test="${product.typeId==t.id}">selected="selected"</c:if> >${t.name}</option>
									</c:forEach>
								</select>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						商品名称:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="required" id="name" name="name" maxlength="100" size="100" value="${product.name }"/>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						商品品牌:</td><td width="80%" class="pn-fcontent">
						<select name="brandId">
							<option value="">请选择品牌</option>
							<c:forEach items="${brandList}" var="b">
								<option value="${b.id }" <c:if test="${product.brandId==b.id}">selected="selected"</c:if> >${b.name }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						商品毛重:</td><td width="80%" class="pn-fcontent">
						<input type="text" value="0.6" class="required" name="weight" maxlength="10" value="${product.weight }"/>KG
					</td>
				</tr>
				<tr>
				 	<td width="20%" class="pn-flabel pn-flabel-h">
						材质:</td><td width="80%" class="pn-fcontent">
						<c:forEach items="${ featureList}" var="f">
							<input type="checkbox"  class="featureIds" id="F_${f.id }" name="feature" value="${f.id }"  />${f.name }
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						颜色:</td><td width="80%" class="pn-fcontent">
						<c:forEach items="${colorList }" var="c">
							<input type="checkbox" value="${c.id }" name="color"  id="C_${c.id }" class="colorIds"/>${c.name }
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						尺码:</td><td width="80%" class="pn-fcontent">
						<input type="checkbox" id="S" name="size" value="S"/>S
						<input type="checkbox" id="M" name="size" value="M"/>M
						<input type="checkbox" id="L" name="size" value="L"/>L
						<input type="checkbox" id="XL" name="size" value="XL"/>XL
						<input type="checkbox" id="XXL" name="size" value="XXL"/>XXL
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						状态:</td><td width="80%" class="pn-fcontent">
						<input type="checkbox" name="isNew" value="1" <c:if test="${product.isNew=='1' }">checked="checked"</c:if> />新品
						<input type="checkbox" name="isCommend" value="1" <c:if test="${product.isCommend=='1' }">checked="checked"</c:if> />推荐
						<input type="checkbox" name="isHot" value="1" <c:if test="${product.isHot=='1' }">checked="checked"</c:if> />热卖
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
						<img src="${path }${img.url}" width="100" height="100" id="allImgUrl"/>
						<input type="file" name="pic" onchange="uploadPic()" />
						<input type="hidden" id="imgUrl" name="imgUrl" value="${img.url }"/>
					</td>
				</tr>
			</tbody>
			<tbody id="tab_2" style="display: none">
				<tr>
					<td >
						<textarea rows="10" cols="10" id="productdesc" name="description">${product.description }</textarea>
					</td>
				</tr>
			</tbody>
			<tbody id="tab_3" style="display: none">
				<tr>
					<td >
						<textarea rows="15" cols="136" id="productList" name="packageList">${product.packageList }</textarea>
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
	
	var feature = "${product.feature}";
	if (feature != "") {
		var featurearr = feature.split(",");
		for (var i=0; i<featurearr.length; i++) {
			$("#F_"+featurearr[i]).attr("checked", true);
		}
	}
	
	var color = "${product.color}";
	if (color != "") {
		var colorarr = color.split(",");
		for (var i=0; i<colorarr.length; i++) {
			$("#C_"+colorarr[i]).attr("checked", true);
		}
	}
	
	var size = "${product.size}";
	if (size != "") {
		var sizearr = size.split(",");
		for (var i=0; i<sizearr.length; i++) {
			$("#"+sizearr[i]).attr("checked", true);
		}
	}
	$("#submitbtn").click(function(){
		var typeId = $("#typeId").val();
		var color = $("input[name='color']:checked").size();
		var size = $("input[name='size']:checked").size();
		var imgUrl = $("#imgUrl").val();
		
		if (typeId == "") {
			alert("请选择商品类型");
			return;
		}
		if (color < 1) {
			alert("请选择颜色");
			return;
		}
		if (size < 1) {
			alert("请选择尺码");
			return;
		}
		if (imgUrl == "") {
			alert("请选择图片");
			return;
		}
		var content = "";
		try {
			content = FCKeditorAPI.GetInstance("productdesc").GetXHTML("true"); 
			$("#productdesc").val(content);
		} catch (e) {
			console.log(e);
		} 
		$.ajax({
			url : '${pageContext.request.contextPath}/product/update.do',
			data : $("#jvForm").serialize(),
			type : 'post',
			cache : false,
			dataType : 'json',
			beforeSend : function() {},
			success : function(data) {
				if (data == "0") {
					window.location.href="${pageContext.request.contextPath}/product/list.do";
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