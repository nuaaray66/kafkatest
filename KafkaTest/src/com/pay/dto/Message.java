package com.pay.dto;

public class Message {
	private boolean success;
	private String msg;
	private String code;
	private Object data;
	
	public Message(boolean success,String msg,String code,Object data)
	{
		this.success = success;
		this.msg = msg;
		this.code = code;
		this.data = data;
	}
	
	public Message(boolean success,String msg,String code)
	{
		this.success = success;
		this.msg = msg;
		this.code = code;
	}
	
	public Message(boolean success)
	{
		this.success = success;
	}
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}



	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
