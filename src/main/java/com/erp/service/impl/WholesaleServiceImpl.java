package com.erp.service.impl;

import static com.erp.common.LoggerComm.loggerError;
import static com.erp.common.LoggerComm.loggerInfo;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.dao.IWholesaleDao;
import com.erp.model.JsonWholesaleDetail;
import com.erp.orm.entity.Wholesale;
import com.erp.orm.entity.WholesaleDetail;
import com.erp.service.IStoreBatchService;
import com.erp.service.IStoreDetailService;
import com.erp.service.IStoreService;
import com.erp.service.IWholesaleDetailService;
import com.erp.service.IWholesaleService;
import com.erp.utils.GsonUtils;
import com.erp.utils.ResultJson;

@Transactional(rollbackFor = Exception.class)
@Service("wholesaleService")
public class WholesaleServiceImpl implements  IWholesaleService {
	@Resource
	private IWholesaleDao wholesaleDao;//批发销售主表
	@Resource
	private IWholesaleDetailService wholesaleDetailService;//批发销售明细表
	@Resource
	private IStoreService storeService;//库存主表
	@Resource
	private IStoreDetailService storeDetailService;//库存明细表
	@Resource
	private IStoreBatchService storeBatchService;//库存批次明细

	@Override
	public int delById(Integer wsId) throws Exception{
		return wholesaleDao.deleteByPrimaryKey(wsId);
	}

	@Override
	public int save(Wholesale wholesale) throws Exception{
		return wholesaleDao.insert(wholesale);
	}

	/**
	 * 保存操作
	 * @param wholesale
	 * @return
	 */
	@Override
	public ResultJson saveNotNull(Wholesale wholesale, String add, String del, String modify){
//public int saveNotNull(Wholesale wholesale){
		ResultJson rj = new ResultJson();
		StringBuffer msg = new StringBuffer();
        loggerInfo(this.getClass(),"保存批发销售单信息。");
		try {
//		int n = wholesaleService.saveNotNull(wholesale);
            int n = wholesaleDao.insertSelective(wholesale);

			if (n > 0) {
				rj.setSuccess();
				rj.setDesc("保存批发销售单信息成功");
				msg.append("保存批发销售单信息成功.");
//				rj.setDesc("保存批发销售单信息成功");
//                    int mId = 3;//模板ID
//			int nn = addApprove(request, Integer.toString(wholesale.getWsId()), Integer.parseInt(moduleId));//添加审批流程
//			switch (nn) {
//				case 1:
//					msg.append("保存批发销售单信息自动添加审批流程成功,单据ID:" + wholesale.getWsId() + ",模块ID:" + moduleId + ".");
//					loggerInfo(this.getClass(), "保存批发销售单信息自动添加审批流程成功,单据ID:" + wholesale.getWsId() + ",模块ID:" + moduleId);
//					break;
//				case 0:
//					msg.append("保存批发销售单信息自动添加审批流程失败,单据ID:" + wholesale.getWsId() + ",模块ID:" + moduleId + ".");
//					loggerError(this.getClass(), "保存批发销售单信息自动添加审批流程失败,单据ID:" + wholesale.getWsId() + ",模块ID:" + moduleId);
//					break;
//				default:
//					msg.append("保存批发销售单信息自动添加审批流程异常,单据ID:" + wholesale.getWsId() + ",模块ID:" + moduleId + ".");
//					loggerError(this.getClass(), "保存批发销售单信息自动添加审批流程异常,单据ID:" + wholesale.getWsId() + ",模块ID:" + moduleId);
//			}
				//删除批发销售单明细
				if (StringUtils.isNotBlank(del)) {
					//把json字符串转换成对象
					List<JsonWholesaleDetail> listDeleted = GsonUtils.toToListWholesaleDetail(del);//JSON.parseArray(deleted, WholesaleDetail.class);
					//下面就可以根据转换后的对象进行相应的操作了
					if (listDeleted != null && !listDeleted.isEmpty()) {
						int delnum = 0;
						for (JsonWholesaleDetail jwd : listDeleted) {
							WholesaleDetail wd = new WholesaleDetail(jwd);
							Integer wId = wd.getwId();
							if (wId != null && wId > 0) {//商品ID
//							delnum += wholesaleDetailService.delByWsIdAndWidAndBatchnoAndSbid(wholesale.getWsId(), wId,wd.getBatchNo(),wd.getSbId());//根据批发销售单ID和商品ID删除
								delnum += wholesaleDetailService.delByWsIdAndWidAndBatchnoAndSbid(wholesale.getWsId(), wId, wd.getBatchNo(), wd.getSbId());//根据批发销售单ID和商品ID删除
							}
						}
						msg.append("删除批发销售单明细记录:" + delnum + " 条.");
					}
				}
				//添加批发销售单明细
				if (StringUtils.isNotBlank(add)) {
					//把json字符串转换成对象
					List<JsonWholesaleDetail> insertList = GsonUtils.toToListWholesaleDetail(add);//JSON.parseArray(inserted, WholesaleDetail.class);
					if (insertList != null && !insertList.isEmpty()) {
						int addnum = 0;
						for (JsonWholesaleDetail jwd : insertList) {
							WholesaleDetail wd = new WholesaleDetail(jwd);
							if (StringUtils.isNotBlank(jwd.getwId())) {//商品ID
								wd.setWsId(wholesale.getWsId());//批发销售单ID
//							addnum += wholesaleDetailService.saveNotNull(wd);
								addnum += wholesaleDetailService.saveNotNull(wd);//添加批发销售明细记录
								//减库存(库存数减少,待出库增加)
								storeService.modifyAmountById(wd.getsId(),wd.getWsdAmount());//根据库存主键ID,库存数减少,待出库增加
								storeDetailService.modifyAmountById(wd.getSdId(),wd.getWsdAmount());//根据库存明细主键ID,库存数减少,待出库增加
								storeBatchService.modifyAmountById(wd.getSbId(),wd.getWsdAmount());//根据库存批次主键ID,库存数减少,待出库增加
							}
						}
						msg.append("添加批发销售单明细记录:" + addnum + " 条.");
					}
				}
				//修改批发销售单明细
				if (StringUtils.isNotBlank(modify)) {
					//把json字符串转换成对象
					List<JsonWholesaleDetail> listUpdated = GsonUtils.toToListWholesaleDetail(modify);// JSON.parseArray(updated, WholesaleDetail.class);
					if (listUpdated != null && !listUpdated.isEmpty()) {
						int mdfnum = 0;
						for (JsonWholesaleDetail jwd : listUpdated) {
							WholesaleDetail wd = new WholesaleDetail(jwd);
							if (StringUtils.isNotBlank(jwd.getwId())) {//商品ID
								wd.setWsId(wholesale.getWsId());//批发销售单ID
//							mdfnum += wholesaleDetailService.modifyByIdNotNull(wd);
								mdfnum += wholesaleDetailService.modifyByIdNotNull(wd);
							}
						}
						msg.append("修改批发销售单明细记录:" + mdfnum + " 条.");
					}
				}
			} else {
				rj.setDesc("保存批发销售单信息失败");
			}
//            throw new RuntimeException("测试回滚3");
        }catch(Exception e){
			rj.setException("保存批发销售单信息时异常:"+e.getMessage());
//			rj.setDesc("保存批发销售单信息时异常:"+e.getMessage());
            loggerError(this.getClass(),"保存批发销售单信息时异常:"+e.getMessage());
		    throw e;
        }
        return rj;
//		return wholesaleDao.insertSelective(wholesale);
	}



	@Override
	public Wholesale findById(Integer wsId){
		return wholesaleDao.selectByPrimaryKey(wsId);
	}

	/**
	 * 修改操作
	 * @param wholesale
	 * @return
	 */
	@Transactional
	@Override
	public ResultJson modifyByIdNotNull(Wholesale wholesale) throws Exception{
		//	public int modifyByIdNotNull(Wholesale wholesale){
		ResultJson rj = new ResultJson();

		Wholesale wa = this.findById(wholesale.getWsId());
		if (wa != null && wa.getWsId() > 0) {
			int n = wholesaleDao.updateByPrimaryKeySelective(wholesale);
			if (n > 0) {
				rj.setSuccess();
				rj.setDesc("修改批发销售单信息成功");
			} else {
				rj.setDesc("修改批发销售单信息失败");
			}
		}
		return rj;
//		return 0;
//		return wholesaleDao.updateByPrimaryKeySelective(wholesale);
	}



	@Override
	public int modifyById(Wholesale wholesale) throws Exception{
		return wholesaleDao.updateByPrimaryKey(wholesale);
	}



	@Override
	public Wholesale findByCode(String oCode){
		return wholesaleDao.selectByCode(oCode);
	}



	@Override
	public List<Wholesale> findByPage(Integer page, Integer rows){
		return wholesaleDao.selectByPage(page, rows);
	}



	@Override
	public Integer findCount( ){
		return wholesaleDao.selectCount();
	}

	@Override
	public List<Wholesale> findByName(String name) {
		return wholesaleDao.selectByName(name);
	}


}
