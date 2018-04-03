package com.erp.utils;


public class ResultJson {
	// 状态(1:成功 ,0失败,-1:异常,-2:客户编号为空)
	private int status = 0;
	// 描述信息
	private String desc = "没数据或失败";
	// 数据
	private String data;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getData() {
		return data;
	}

	public void setData(Object obj) {
		if(null == obj){
			this.data = "";
		}else{
			this.data = GsonUtils.toStr(obj);
		}
	}

	/**
	 *  设置为成功状态:1 (默认为失败:0)
	 */
	public void setSuccess() {
		this.status = 1;
		this.desc = "成功";
	}
	/**
	 * 设置为异常状态:-1 (默认为失败:0)
	 */
	public void setException(String msg) {
		if(msg == null){
			msg = "";
		}
		this.status = -1;
		this.desc = msg.concat("出现异常");
	}
	/**
	 * 客户编号为空
	 */
	public void setCustomidIsNull() {
		this.status = -2;
		this.desc = "客户编号为空";
	}
}
