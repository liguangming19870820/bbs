//统一封装方法，作用：提示信息
function message_alert(data){
	//从返回的json数据中获取结果信息
	var data_v = data.resultInfo;
	
	//提交结果类型
	var type=data_v.type;
	//结果提示信息
	var message=data_v.message;
	//alert(message);
	if(type==0){
		//如果type等于0表示失败，调用 jquery easyui的信息提示组件
		$.messager.alert('提示信息',message,'error');
	}else if(type==1){
		$.messager.alert('提示信息',message,'success');
	}else if(type==2){
		$.messager.alert('提示信息',message,'warning');
	}else if(type==3){
		$.messager.alert('提示信息',message,'info');
	}
}

function message_alert_error(message){
	$.messager.alert('提示信息',message,'error');
}