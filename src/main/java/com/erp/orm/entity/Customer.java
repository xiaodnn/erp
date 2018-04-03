/**
 * 
 */
package com.erp.orm.entity;

/**
 *
 * 客户信息
 * @author scy
 * @date 2016年3月9日
 */
public class Customer {

	/**
	 * 客户基础信息
	 */
	private CustomerBase customerBase;

	/**
	 *客户质量信息
	 */
	private CustomerQuality customerQuality;

	/**
	 * @return the customerBase
	 */
	public CustomerBase getCustomerBase() {
		return customerBase;
	}

	/**
	 * @param customerBase the customerBase to set
	 */
	public void setCustomerBase(CustomerBase customerBase) {
		this.customerBase = customerBase;
	}

	/**
	 * @return the customerQuality
	 */
	public CustomerQuality getCustomerQuality() {
		return customerQuality;
	}

	/**
	 * @param customerQuality the customerQuality to set
	 */
	public void setCustomerQuality(CustomerQuality customerQuality) {
		this.customerQuality = customerQuality;
	}
	
}
