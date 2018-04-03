/**
 * 
 */
package com.erp.utils;

/**
 *
 *
 * @author scy
 * @date 2016年12月13日
 */
public class Children {

	/**
	 * 节点的 id，它对于加载远程数据很重要
	 */
	private int id;
	/**
	 * 要显示的节点文本。
	 */
	private String text;
	/**
	 * 节点状态，'open' 或 'closed'，默认是 'open'。当设置为 'closed' 时，该节点有子节点，并且将从远程站点加载它们。
	 */
	private String state;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	
}
