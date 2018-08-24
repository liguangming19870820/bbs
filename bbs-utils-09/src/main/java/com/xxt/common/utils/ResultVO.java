package com.xxt.common.utils;

import java.io.Serializable;

public class ResultVO implements Serializable {

	private Integer status;
	private String msg;
	private String data;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResultVO [status=" + status + ", msg=" + msg + ", data=" + data + "]";
	}
	
	
}
