/**
 * 
 */
package com.erp.utils;

import java.io.Serializable;

/**
 *
 * easyui combobox option 选项组
 * @author scy
 * @date 2017年1月5日
 */
public class Options implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2597869028482361272L;
	
	private String value="";
	private String text="";
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	
}
