/**
 * 
 */
package com.erp.orm.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * 客户基础信息
 * @author scy
 * @date 2016年3月9日
 */
public class CustomerBase {
	
	/**
	客户编码
	*/
	private Integer cbId;
	/**
	客户名称
	*/
	private String cbFullname;
	/**
	客户简称
	*/
	private String cbShortname;
	/**
	助记码
	*/
	private String cbAbbrev;
	/**
	法人代表
	*/
	private String cbAgentname;
	/**
	企业负责人
	*/
	private String cbBusname;
	/**
	质量负责人
	*/
	private String cbGspname;
	/**
	注册资金
	*/
	private BigDecimal cbRegister;
	/**
	经济性质
	*/
	private String cbEconomic;
	/**
	经营方式
	*/
	private String cbOperate;
	/**
	客户地址
	*/
	private String cbAddress;
	/**
	仓库地址
	*/
	private String cbStorehouse;
	/**
	省份
	*/
	private String cbProvince;
	/**
	城市
	*/
	private String cbCity;
	/**
	联系人
	*/
	private String cbLinkman;
	/**
	联系人电话
	*/
	private String cbPhone;
	/**
	传真电话
	*/
	private String cbFax;
	/**
	邮箱
	*/
	private String cbEmail;
	/**
	邮政编码
	*/
	private String cbPostcode;
	/**
	开户银行
	*/
	private String cbBankname;
	/**
	银行帐号
	*/
	private String cbBankcode;
	/**
	税号
	*/
	private String cbTaxcode;
	/**
	客户状态
	*/
	private Byte cbState;
	/**
	创建时间
	*/
	private Date cbInitime;
	/**
	'创建人'
	*/
	private String cbCreator;
	/**
	 * @return the cbId
	 */
	public Integer getCbId() {
		return cbId;
	}
	/**
	 * @param cbId the cbId to set
	 */
	public void setCbId(Integer cbId) {
		this.cbId = cbId;
	}
	/**
	 * @return the cbFullname
	 */
	public String getCbFullname() {
		return cbFullname;
	}
	/**
	 * @param cbFullname the cbFullname to set
	 */
	public void setCbFullname(String cbFullname) {
		this.cbFullname = cbFullname;
	}
	/**
	 * @return the cbShortname
	 */
	public String getCbShortname() {
		return cbShortname;
	}
	/**
	 * @param cbShortname the cbShortname to set
	 */
	public void setCbShortname(String cbShortname) {
		this.cbShortname = cbShortname;
	}
	/**
	 * @return the cbAbbrev
	 */
	public String getCbAbbrev() {
		return cbAbbrev;
	}
	/**
	 * @param cbAbbrev the cbAbbrev to set
	 */
	public void setCbAbbrev(String cbAbbrev) {
		this.cbAbbrev = cbAbbrev;
	}
	/**
	 * @return the cbAgentname
	 */
	public String getCbAgentname() {
		return cbAgentname;
	}
	/**
	 * @param cbAgentname the cbAgentname to set
	 */
	public void setCbAgentname(String cbAgentname) {
		this.cbAgentname = cbAgentname;
	}
	/**
	 * @return the cbBusname
	 */
	public String getCbBusname() {
		return cbBusname;
	}
	/**
	 * @param cbBusname the cbBusname to set
	 */
	public void setCbBusname(String cbBusname) {
		this.cbBusname = cbBusname;
	}
	/**
	 * @return the cbGspname
	 */
	public String getCbGspname() {
		return cbGspname;
	}
	/**
	 * @param cbGspname the cbGspname to set
	 */
	public void setCbGspname(String cbGspname) {
		this.cbGspname = cbGspname;
	}
	/**
	 * @return the cbRegister
	 */
	public BigDecimal getCbRegister() {
		return cbRegister;
	}
	/**
	 * @param cbRegister the cbRegister to set
	 */
	public void setCbRegister(BigDecimal cbRegister) {
		this.cbRegister = cbRegister;
	}
	/**
	 * @return the cbEconomic
	 */
	public String getCbEconomic() {
		return cbEconomic;
	}
	/**
	 * @param cbEconomic the cbEconomic to set
	 */
	public void setCbEconomic(String cbEconomic) {
		this.cbEconomic = cbEconomic;
	}
	/**
	 * @return the cbOperate
	 */
	public String getCbOperate() {
		return cbOperate;
	}
	/**
	 * @param cbOperate the cbOperate to set
	 */
	public void setCbOperate(String cbOperate) {
		this.cbOperate = cbOperate;
	}
	/**
	 * @return the cbAddress
	 */
	public String getCbAddress() {
		return cbAddress;
	}
	/**
	 * @param cbAddress the cbAddress to set
	 */
	public void setCbAddress(String cbAddress) {
		this.cbAddress = cbAddress;
	}
	/**
	 * @return the cbStorehouse
	 */
	public String getCbStorehouse() {
		return cbStorehouse;
	}
	/**
	 * @param cbStorehouse the cbStorehouse to set
	 */
	public void setCbStorehouse(String cbStorehouse) {
		this.cbStorehouse = cbStorehouse;
	}
	/**
	 * @return the cbProvince
	 */
	public String getCbProvince() {
		return cbProvince;
	}
	/**
	 * @param cbProvince the cbProvince to set
	 */
	public void setCbProvince(String cbProvince) {
		this.cbProvince = cbProvince;
	}
	/**
	 * @return the cbCity
	 */
	public String getCbCity() {
		return cbCity;
	}
	/**
	 * @param cbCity the cbCity to set
	 */
	public void setCbCity(String cbCity) {
		this.cbCity = cbCity;
	}
	/**
	 * @return the cbLinkman
	 */
	public String getCbLinkman() {
		return cbLinkman;
	}
	/**
	 * @param cbLinkman the cbLinkman to set
	 */
	public void setCbLinkman(String cbLinkman) {
		this.cbLinkman = cbLinkman;
	}
	/**
	 * @return the cbPhone
	 */
	public String getCbPhone() {
		return cbPhone;
	}
	/**
	 * @param cbPhone the cbPhone to set
	 */
	public void setCbPhone(String cbPhone) {
		this.cbPhone = cbPhone;
	}
	/**
	 * @return the cbFax
	 */
	public String getCbFax() {
		return cbFax;
	}
	/**
	 * @param cbFax the cbFax to set
	 */
	public void setCbFax(String cbFax) {
		this.cbFax = cbFax;
	}
	/**
	 * @return the cbEmail
	 */
	public String getCbEmail() {
		return cbEmail;
	}
	/**
	 * @param cbEmail the cbEmail to set
	 */
	public void setCbEmail(String cbEmail) {
		this.cbEmail = cbEmail;
	}
	/**
	 * @return the cbPostcode
	 */
	public String getCbPostcode() {
		return cbPostcode;
	}
	/**
	 * @param cbPostcode the cbPostcode to set
	 */
	public void setCbPostcode(String cbPostcode) {
		this.cbPostcode = cbPostcode;
	}
	/**
	 * @return the cbBankname
	 */
	public String getCbBankname() {
		return cbBankname;
	}
	/**
	 * @param cbBankname the cbBankname to set
	 */
	public void setCbBankname(String cbBankname) {
		this.cbBankname = cbBankname;
	}
	/**
	 * @return the cbBankcode
	 */
	public String getCbBankcode() {
		return cbBankcode;
	}
	/**
	 * @param cbBankcode the cbBankcode to set
	 */
	public void setCbBankcode(String cbBankcode) {
		this.cbBankcode = cbBankcode;
	}
	/**
	 * @return the cbTaxcode
	 */
	public String getCbTaxcode() {
		return cbTaxcode;
	}
	/**
	 * @param cbTaxcode the cbTaxcode to set
	 */
	public void setCbTaxcode(String cbTaxcode) {
		this.cbTaxcode = cbTaxcode;
	}
	/**
	 * @return the cbState
	 */
	public Byte getCbState() {
		return cbState;
	}
	/**
	 * @param cbState the cbState to set
	 */
	public void setCbState(Byte cbState) {
		this.cbState = cbState;
	}
	/**
	 * @return the cbInitime
	 */
	public Date getCbInitime() {
		return cbInitime;
	}
	/**
	 * @param cbInitime the cbInitime to set
	 */
	public void setCbInitime(Date cbInitime) {
		this.cbInitime = cbInitime;
	}
	/**
	 * @return the cbCreator
	 */
	public String getCbCreator() {
		return cbCreator;
	}
	/**
	 * @param cbCreator the cbCreator to set
	 */
	public void setCbCreator(String cbCreator) {
		this.cbCreator = cbCreator;
	}

}
