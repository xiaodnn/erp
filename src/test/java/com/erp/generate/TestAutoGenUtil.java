package com.erp.generate;

import com.gen.XMLUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestAutoGenUtil {

    protected final static Logger logger = LoggerFactory.getLogger(TestAutoGenUtil.class);

    public static int genMapperToPage(String tableName,String entityName){
        try{
            logger.info("------自动生成功能开始-----------");
            //修改 mbgConfiguration.xml文件
//            String path = XMLUtil.operate(tableName,entityName);
            String path = "D:\\ProgramFiles\\eclipseJava\\IdeaProjects\\erp\\src\\test\\resources\\mbgConfiguration.xml";
                    //生成从 Mapper 到 views
            GenMapper.genMapperToPage(path);
            logger.info("------自动生成功能结束-----------");
            return 1;
        }catch(Exception e){
            logger.error("自动生成Mapper至页面过程异常:",e);
            return 0;
        }
    }
}
