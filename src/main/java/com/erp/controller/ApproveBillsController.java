package com.erp.controller;

import com.erp.common.BaseController;
import com.erp.orm.entity.ApproveBills;
import com.erp.orm.entity.Employee;
import com.erp.orm.entity.User;
import com.erp.service.IApproveBillsService;
import com.erp.service.IEmployeeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 需要审批单据
 */
@RestController
@RequestMapping("approvebill")
public class ApproveBillsController extends BaseController {

    @Resource
    private IApproveBillsService approveBillsService;
    @Resource
    private IEmployeeService employeeService;

    @RequestMapping("index")
    public List<ApproveBills> index(HttpServletRequest request){
        User user = BaseController.getUser(request);
        List<ApproveBills> approveBills = new ArrayList<ApproveBills>();
        if(user != null && user.getuId() > 0){
            Integer uId =user.getuId();
            Employee employee = employeeService.findByUid(uId);
            if(employee != null && employee.geteId() > 0) {
                approveBills = approveBillsService.findByEid(employee.geteId());
            }
        }

        return approveBills;
//        return new ModelAndView("/approve/index");
    }


}
