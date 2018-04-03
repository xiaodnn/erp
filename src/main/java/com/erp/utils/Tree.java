package com.erp.utils;

import java.util.List;

import net.sf.json.JSONObject;


/**
 *
 * 树(一级菜单)
 * @author scy
 * @date 2016年12月13日
 */
public class Tree {
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
	private String state="closed";
	/**
	 * 指示节点是否被选中。
	 */
	private boolean checked;
	/**
	 * ：给一个节点添加的自定义属性。
	 */
//	private List<Attribute> attributes;
	private JSONObject attributes;

	/**
	 * 
	 */
	private List<Tree> children;

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

	/**
	 * @return the checked
	 */
	public boolean isChecked() {
		return checked;
	}

	/**
	 * @param checked the checked to set
	 */
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	/**
	 * @return the attributes
	 */
	public JSONObject getAttributes() {
		return attributes;
	}

	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(JSONObject attributes) {
		this.attributes = attributes;
	}

	/**
	 * @return the children
	 */
	public List<Tree> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(List<Tree> children) {
		this.children = children;
	}

}
