package com.erp.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.erp.common.BaseController;
import com.erp.common.LoggerComm;
import com.erp.orm.entity.Approve;
import com.erp.orm.entity.ApproveHistory;
import com.erp.orm.entity.Employee;
import com.erp.orm.entity.Store;
import com.erp.orm.entity.StoreBatch;
import com.erp.orm.entity.StoreDetail;
import com.erp.orm.entity.User;
import com.erp.orm.entity.Warehousing;
import com.erp.orm.entity.WarehousingDetail;
import com.erp.orm.entity.WaresPrice;
import com.erp.utils.ResultJson;

@Service("approveOperateComm")
public class ApproveOperateComm extends LoggerComm {

    @Resource
    private IApproveService approveService;

//    public IApproveService getApproveService() {
//        return approveService;
//    }
//
//    public void setApproveService(IApproveService approveService) {
//        this.approveService = approveService;
//    }

    @Resource
    private IEmployeeService employeeService;

//    public IEmployeeService getEmployeeService() {
//        return employeeService;
//    }
//
//    public void setEmployeeService(IEmployeeService employeeService) {
//        this.employeeService = employeeService;
//    }

    @Resource
    private IApproveHistoryService approvehistoryService;

//    public IApproveHistoryService getApprovehistoryService() {
//        return approvehistoryService;
//    }
//
//    public void setApprovehistoryService(IApproveHistoryService approvehistoryService) {
//        this.approvehistoryService = approvehistoryService;
//    }

    @Resource
    private IMapApproveRecordService mapapproverecordService;

//    public IMapApproveRecordService getMapapproverecordService() {
//        return mapapproverecordService;
//    }
//
//    public void setMapapproverecordService(IMapApproveRecordService mapapproverecordService) {
//        this.mapapproverecordService = mapapproverecordService;
//    }

    @Resource
    private IWarehousingService warehousingService;

//    public IWarehousingService getWarehousingService() {
//        return warehousingService;
//    }
//
//    public void setWarehousingService(IWarehousingService warehousingService) {
//        this.warehousingService = warehousingService;
//    }

    @Resource
    private IStoreService storeService;

//    public IStoreService getStoreService() {
//        return storeService;
//    }
//
//    public void setStoreService(IStoreService storeService) {
//        this.storeService = storeService;
//    }

    @Resource
    private IStoreBatchService storeBatchService;

//    public IStoreBatchService getStoreBatchService() {
//        return storeBatchService;
//    }
//
//    public void setStoreBatchService(IStoreBatchService storeBatchService) {
//        this.storeBatchService = storeBatchService;
//    }

    @Resource
    private IStoreDetailService storeDetailService;

//    public IStoreDetailService getStoreDetailService() {
//        return storeDetailService;
//    }
//
//    public void setStoreDetailService(IStoreDetailService storeDetailService) {
//        this.storeDetailService = storeDetailService;
//    }

    @Resource
    private IWaresPriceService waresPriceService;

//    public IWaresPriceService getWaresPriceService() {
//        return waresPriceService;
//    }
//
//    public void setWaresPriceService(IWaresPriceService waresPriceService) {
//        this.waresPriceService = waresPriceService;
//    } public IWaresPriceService getWaresPriceService() {
//        return waresPriceService;
//    }
//
//    public void setWaresPriceService(IWaresPriceService waresPriceService) {
//        this.waresPriceService = waresPriceService;
//    }

    public ResultJson approveOperate(HttpServletRequest request, Integer mId, String mName, String rId, String remark, Byte state){

        ResultJson rj = new ResultJson();

        User user = BaseController.getUser(request);
        if(user == null || user.getuId() == null){
            rj.setDesc("请登录后再审批,谢谢！");
            return rj;
        }
        int uId =  user.getuId();
        Employee employee = employeeService.findByUid(uId);
        if(employee == null || employee.geteId() == null){
            rj.setDesc("用户在员工表中不存在,请确认信息后再审批,谢谢！");
            return rj;
        }
        int eId = employee.geteId();
        String oId = employee.geteOid();
        //根据模块ID获取审批流程
        Approve approve = approveService.findByMid(mId);
        int n = 0;
        //当前审核人是第几级审核
        if(eId == approve.getaLevelUid1()){
            n = 1;
        }else if(eId == approve.getaLevelUid2()){
            n = 2;
        }else if(eId == approve.getaLevelUid3()){
            n = 3;
        }else if(eId == approve.getaLevelUid4()){
            n = 4;
        }else if(eId == approve.getaLevelUid5()){
            n = 5;
        }else if(eId == approve.getaLevelUid6()){
            n = 6;
        }
        //记录审核日志
        ApproveHistory approveHistory = new ApproveHistory(mId, rId, eId, state, remark+".n:"+n);
        int an = approvehistoryService.saveNotNull(approveHistory);//添加审批日志
        if(an > 0){
            loggerInfo(this.getClass(),"审批记录,mid:"+mId+",rId:"+ rId +",eId:" + eId);
        }

        int un = 0;
        //判断审核状态
        switch (state){
            case 1://通过
                if(n == approve.getaLevel()){//最后一级审核，需要修改库存信息
                    //需要添加事务,入库审批通过后,记录入库信息.
                    //库存(tb_store)、库存批次(tb_store_batch)、库存明细(tb_store_detail)、商品价格（最新进价,tb_wares_price）、更新商品信息中最新供应商(tb_wares_base)
                    state = 3;
                    un = mapapproverecordService.modifyByApproveInfoToPass(mId,rId,n,eId,oId,state);
                    if(mId == 1){//采购入库审批单
                        //修改库存(tb_store)
                        //品种存在就增加库存，不存在就添加
                        Warehousing warehousing = warehousingService.findById(rId);//入库单
                        if(warehousing != null && warehousing.getWarehousingDetails() != null && !warehousing.getWarehousingDetails().isEmpty()){
                            Store store = null;
                            List<WarehousingDetail> warehousingDetails = warehousing.getWarehousingDetails();
                            for(WarehousingDetail warehousingDetail : warehousingDetails){
                                if(warehousingDetail == null || StringUtils.isBlank(warehousingDetail.getwId())){
                                    continue;
                                }
                                //修改库存(tb_store)
                                List<Store> stores = storeService.findByWid(warehousingDetail.getwId());
                                if(stores == null || stores.isEmpty()) {//不存在，添加
                                    store = new Store();
                                    store.setwId(warehousingDetail.getwId());
                                    store.setAmountSum(warehousingDetail.getWdAmount());//总数
                                    store.setCostPrice(warehousingDetail.getWdDiscPrice());//最新进价
                                    store.setcId(warehousing.getcId());//供应商ID
                                    store.setoCode(warehousing.getoId());
//                                    storeService.saveOrModify(store);
                                    storeService.saveNotNull(store);
                                }else{//存在，更新
                                    store = stores.get(0);
                                    store.setwId(warehousingDetail.getwId());
                                    store.setAmountSum(store.getAmountSum() + warehousingDetail.getWdAmount());//总数
                                    store.setCostPrice(warehousingDetail.getWdDiscPrice());//最新进价
                                    store.setcId(warehousing.getcId());//供应商ID
                                    store.setoCode(warehousing.getoId());
//                                    storeService.saveOrModify(store);
                                    storeService.modifyByWid(store);
                                }

                                //添加批次表
                                StoreBatch storeBatch = new StoreBatch();
                                storeBatch.setsId(store.getsId());
                                storeBatch.setwId(warehousingDetail.getwId());
                                storeBatch.setcId(warehousing.getcId());
                                storeBatch.setAmount(warehousingDetail.getWdAmount());
                                storeBatch.setCostprice(warehousingDetail.getWdCostprice());
                                storeBatch.setBatchNo(warehousingDetail.getWdBatchNo());
                                storeBatch.setProduceDate(warehousingDetail.getWdDate());
                                storeBatch.setValidDate(warehousingDetail.getWdIndate());
//                                storeBatch.setBuyer();
                                storeBatchService.saveNotNull(storeBatch);
                                //添加明细

                                StoreDetail storeDetail = new StoreDetail();
                                storeDetail.setsId(store.getsId());
                                storeDetail.setoCode(warehousing.getoId());
                                storeDetail.setShCode(warehousing.getShId());
                                storeDetail.setwId(warehousingDetail.getwId());
                                storeDetail.setBatchNo(warehousingDetail.getWdBatchNo());
                                storeDetail.setSpCode(warehousingDetail.getWdAllocation());
                                storeDetail.setProduceDate(warehousingDetail.getWdDate());
                                storeDetail.setValidDate(warehousingDetail.getWdIndate());
                                storeDetail.setAmount(warehousingDetail.getWdAmount());

                                storeDetailService.saveNotNull(storeDetail);

                                //商品价格（最新进价,tb_wares_price）
                                WaresPrice waresPrice = new WaresPrice();
                                waresPrice.setwId(warehousingDetail.getwId());
                                waresPrice.setwCostprice(warehousingDetail.getWdCostprice());
                                waresPrice.setwSaleprice(warehousingDetail.getWdSaleprice());
                                waresPriceService.saveOrModify(waresPrice);
                            }

                        }


                        //库存批次(tb_store_batch)

                        //库存明细(tb_store_detail)

                        //商品价格（最新进价,tb_wares_price）

                        //更新商品信息中最新供应商(tb_wares_base)


                    }

                }else{//还有下一级审核时
                    un = mapapproverecordService.modifyByApproveInfoToPass(mId,rId,n,eId,oId,state);
                }
                break;
            case 2://驳回
                if(n > 1){
                    n = n - 1;
//                    eId = null;
                    oId = null;
                }
//                un = mapapproverecordService.modifyByApproveInfoToReject(mId,rId,n,eId,oId,state);
                un = mapapproverecordService.modifyByApproveInfoToPass(mId,rId,n,null,oId,state);
                break;
            case 3://作废
//                un = mapapproverecordService.modifyByApproveInfoToCancelled(mId,rId,n,eId,oId,state);
                un = mapapproverecordService.modifyByApproveInfoToPass(mId,rId,n,eId,oId,state);
                break;
            case 4://撤回
                un = mapapproverecordService.modifyByApproveInfoToRecall(mId,rId,n,eId,oId,state);
                break;
            case 5://终止
//                un = mapapproverecordService.modifyByApproveInfoToAbort(mId,rId,n,eId,oId,state);
                un = mapapproverecordService.modifyByApproveInfoToPass(mId,rId,n,eId,oId,state);
                break;

        }
        if(un > 0){
            rj.setDesc("审批成功！");
            rj.setSuccess();
        }else{
            rj.setDesc("审批失败！");
        }

        return rj;
    }
}
