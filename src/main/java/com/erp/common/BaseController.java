package com.erp.common;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.erp.orm.entity.Approve;
import com.erp.orm.entity.User;
import com.erp.service.IApproveService;
import com.erp.service.IMapApproveRecordService;

public abstract class BaseController extends LoggerComm {

//	protected static String uri = null;

//	@Resource
	private static IApproveService approveService;
//	@Resource
	private static IMapApproveRecordService mapapproverecordService;

	public IApproveService getApproveService() {
		return approveService;
	}
	@Resource
	public void setApproveService(IApproveService approveService) {
		BaseController.approveService = approveService;
	}

	public IMapApproveRecordService getMapapproverecordService() {
		return mapapproverecordService;
	}
	@Resource
	public void setMapapproverecordService(IMapApproveRecordService mapapproverecordService) {
		BaseController.mapapproverecordService = mapapproverecordService;
	}

	/**
	 * 获取 header中地址
	 * @param request
	 * @return
	 */
	public static User getUser(HttpServletRequest request){
		HttpSession session = request.getSession();
		return (User)session.getAttribute("user_"+session.getId());
	}

	/**
	 * 添加单据审批流程
	 * @param request
	 * @param rId 单据ID
	 * @param mId 模块ID
	 * @return
	 */
	public static int addApprove(HttpServletRequest request , String rId,Integer mId){
		int n = 0;
		try{
			//添加审批流程
			User user = getUser(request);
			if(user != null && user.getuId() > 0){
				//根据机构ID和模块ID获取审核流程
				Approve approve = approveService.findByOgranAndModule(user.getoId(),mId);
				n = mapapproverecordService.saveNotNull(rId,user.getuId(),approve);
			}
		}catch(Exception e){
			loggerError(BaseController.class,"添加模块ID:"+mId+" , 单据ID:"+rId+" 审批流程异常",e);
			n = -1;
		}

		return n;
	}
//	public static String customerUri(HttpServletRequest request)throws Exception{
//		String uri = request.getHeader("c_uri");
//		if(StringUtils.isBlank(uri)){
//			throw new Exception("ip为空.");
//		}
//		uri = "http://".concat(uri).concat(":8015/api");
//		return uri;
//	}
	
//	public static String customerID(HttpServletRequest request)throws Exception{
//		String cid = request.getHeader("c_id");
//		if(StringUtils.isBlank(cid)){
//			throw new Exception("客户id为空.");
//		}
//		return cid;
//	}

}