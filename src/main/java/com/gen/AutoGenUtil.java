package com.gen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.erp.orm.entity.TableStruct;

public class AutoGenUtil {

    protected final static Logger logger = LoggerFactory.getLogger(AutoGenUtil.class);

    public static int genMapperToPage(TableStruct tsMain,TableStruct tsSub,String tableName,String entityName){
        try{
            logger.info("------自动生成功能开始-----------");
            //修改 mbgConfiguration.xml文件
//            String path = XMLUtil.operateWrite(tableName,entityName);
//            String path = XMLUtil.operateWrite(tableName,entityName);
//           String path = "D:/ProgramFiles/eclipseJava/workspace/erp/src/main/resources/gen/mbgConfiguration.xml";
            
//            String path = XMLUtil.operateWrite(tableName,entityName);
             XMLUtil.operateProper(tableName,entityName);
//            path="e:/149ab08e-3cf0-4a55-b0d6-2e521f458946.xml";
//            String path = ResourceUtils.getFile("classpath:/gen/mbgConfiguration.xml").getPath();
            //生成从 Mapper 到 views
//            GenMapper.genMapperToPage(path,entityName);
            // 修改属性文件值
//            PropertiesUtil pu = new PropertiesUtil();
//            pu.updateProperties("tableName", tableName);
//            pu.updateProperties("domainObjectName", entityName);

            GenMapper.genMapperToPage(tsMain,tsSub,entityName);
            logger.info("------自动生成功能结束-----------");
//            Files.delete(new File(path).toPath());
            return 1;
        }catch(Exception e){
            logger.error("自动生成Mapper至页面过程异常:",e);
            return 0;
        }
    }
}
