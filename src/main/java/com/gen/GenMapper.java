package com.gen;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.util.ResourceUtils;

import com.erp.orm.entity.TableStruct;
import com.erp.utils.PropertiesUtil;

public class GenMapper {

	
	public static void main(String [] args){
		
//		 String path="D:/ProgramFiles/tomcat/webapps/erp/WEB-INF/classes/gen/06ce7969-f610-4031-9aa6-74c713785e37.xml";
		 try {
//			genMapperToPage(path,"Sellmain");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
     * 
     * @param 
     * @throws Exception
     */
    /**
     * 生成从 Mapper 到 views
     * @param tsMain 主单内容 (当为普通页面时为空)
     * @param tsSub 普通页面时，为主单内容，单据页面时为单据页面中子信息
     * @param entityName path xml 文件路径
     */
	public static void genMapperToPage(TableStruct tsMain,TableStruct tsSub,String entityName){

        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        Configuration config = null;
//        String name = "";
	    try{

//            String genCfg = "mbgConfiguration.xml";
    //        File configFile = new File("D:/ProgramFiles/eclipseJava/IdeaProjects/erp/src/test/resources/mbgConfiguration.xml");
//            File directory = new File(".");
//            String xml_path = directory.getCanonicalPath(); //得到的是当前标准的路径
//            String testjavapath = "/src/main/resources/gen";//接口文件路径
//            File configFile = new File(xml_path+testjavapath+genCfg);
	    	String path = ResourceUtils.getFile("classpath:/gen/mbgConfiguration.xml").getPath();
            File configFile = new File(path);
    //        try{
    //            File file = new File(genCfg);
    //            System.out.println(file.getPath());
    //            System.out.println(file.getCanonicalPath());//获取标准的路径
    //            System.out.println(file.getAbsolutePath());//获取绝对路径
    //        }catch(Exception e){
    //            e.printStackTrace();
    //        }


            ConfigurationParser cp = new ConfigurationParser(warnings);
//            Configuration config = null;
//            String name = "";

            config = cp.parseConfiguration(configFile);
//            Context context = config.getContext("jenovo_main_tables");
//            List<TableConfiguration> tables = context.getTableConfigurations();
//            TableConfiguration tc = tables.get(0);
//            name = tc.getDomainObjectName();
            System.out.println("----"+entityName+"--generate OK----");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (XMLParserException e) {
//            e.printStackTrace();
//        }
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = null;
//        try {
            myBatisGenerator = new MyBatisGenerator(config, callback, warnings);

//        } catch (InvalidConfigurationException e) {
//            e.printStackTrace();
//        }
//        try {
            
            ProgressCallback pcb = new ProgressCallback() {
				
				@Override
				public void startTask(String taskName) {
					System.out.println("--startTask--"+taskName);
				}
				
				@Override
				public void saveStarted(int totalTasks) {
					System.out.println("--saveStarted--"+totalTasks);
				}
				
				@Override
				public void introspectionStarted(int totalTasks) {
					System.out.println("--introspectionStarted--"+totalTasks);					
				}
				
				@Override
				public void generationStarted(int totalTasks) {
					System.out.println("--generationStarted--"+totalTasks);					
				}
				
				@Override
				public void done() {
					System.out.println("--done--");					
				}
				
				@Override
				public void checkCancel()  {
					System.out.println("--checkCancel--");					
				}
			};
            
//            myBatisGenerator.generate(null);
            myBatisGenerator.generate(pcb);
            PropertiesUtil pu = new PropertiesUtil();
            
            String rootPath = pu.getKeyValue("targetProject") ;
            
            System.out.println("----"+entityName+"Mapper--generate OK----");
            modifyMapperName(rootPath,entityName);//修改 Mapper 接口名

            GenDao.writerContent(rootPath,entityName);
            System.out.println("----I"+entityName+"Dao--generate OK----");
            
            GenDao.writerImplContent(rootPath,entityName);
            System.out.println("----"+entityName+"DaoImpl--generate OK----");
            
            GenService.writerContent(rootPath,entityName);
            System.out.println("----I"+entityName+"Service--generate OK----");
            
            GenService.writerImplContent(rootPath,entityName);
            System.out.println("----"+entityName+"ServiceImpl--generate OK----");
            
            GenController.writerContent(rootPath,entityName);
            System.out.println("----"+entityName+"Controller--generate OK----");
            
            GenPage.createPage(tsMain,tsSub,rootPath,entityName);
            System.out.println("----"+entityName+"page--generate OK----");

        } catch (Exception e) {
            e.printStackTrace();
//            throw  new Exception("生成从 Mapper 到 views异常:",e);
        }
    }

    /**
     * 自动生成的 mapper 修改为 I***Mapper
     */
    private static void modifyMapperName(String rootPath,String name) throws Exception {
        try {
            String javapath = "/com/erp/orm/inter/";//接口文件路径
            String oleMapperName = name + "Mapper.java";//修改前接口文件名

            String interfaceName = "I" + name + "Mapper.java";//修改后接口文件名

//            File directory = new File(".");
//            String path_now = directory.getCanonicalPath(); //得到的是当前标准的路径

            File oldFile = new File(rootPath + javapath + oleMapperName);
            if (!oldFile.exists()) {
                oldFile.createNewFile();
            }

            System.out.println("修改前文件名称是：" + oldFile.getName());
//            String rootPath = oldFile.getParent();
            System.out.println("根路径是：" + rootPath);
            File newFile = new File(rootPath + javapath + File.separator + interfaceName);
            System.out.println("修改后文件名称是：" + newFile.getName());

            //获取要写内容文件
            FileWriter writer = new FileWriter(newFile);
            BufferedWriter  bw = new BufferedWriter(writer);

            //File fileReader = new File(path_now+javapath+interfaceName);
            FileReader reader = new FileReader(oldFile);

            BufferedReader br = new BufferedReader(reader);//一次读取一行
            String str = br.readLine();//读取到的内容
            bw.write(str);
            bw.write("\r\n");
            bw.write("import java.util.List;");
            bw.write("\r\n");
            bw.write("import java.util.Map;");
            bw.write("\r\n");
            bw.write("import org.springframework.stereotype.Repository;");
            bw.write("\r\n");
            
            //一次读取一行，直到读入null时为文件结束
            String mappername = name +"Mapper";
            bw.write("\r\n");
            while((str = br.readLine()) != null){
            	if(str.indexOf(mappername) >= 0){
                	//添加 @Repository("wholesaleMapper")
                	String s = Character.toString(name.charAt(0));
                	String varname = mappername.replaceFirst(s,s.toLowerCase());                	
                	String repos = "@Repository(\"".concat(varname).concat("\")\r\n");                	                	
                    str = repos.concat(str.replace(mappername,"I"+mappername));//public interface 行
//                }
//                if(str.indexOf(mappername) >= 0){
//                    str = str.replace(mappername,"I"+mappername);
                }
                if(str.indexOf("record") >= 0){
                    String s = Character.toString(name.charAt(0));
                    str = str.replace("record",name.replaceFirst(s,s.toLowerCase()));
                }
                if(str.indexOf("}") >= 0){
                    str = "";
                }
                bw.write(str);
                bw.write("\r\n");
            }

            bw.write("\tList<"+name+"> selectByName(String name);\r\n\r\n");
            bw.write("\tList<"+name+"> selectByPage(Map<String,Integer> map);\r\n\r\n");
            bw.write("\tInteger selectCount(Map<String,Object> map);\r\n\r\n");
            bw.write("}");
            try{
                if(bw != null){
                    bw.flush();
                    bw.close();
                    bw = null;
                }
                if(br != null){
                    br.close();
                    br = null;
                }
            }catch (Exception e){
                bw = null;
                br = null;
                throw new Exception("自动生成的 mapper 修改为 I***Mapper时,关闭文件流异常:",e);
            }

//            if (oldFile.renameTo(newFile)) {
                System.out.println("------修改成功!" + oleMapperName + "--修改为:" + interfaceName);
//            } else {
//                System.out.println("------修改失败!" + oleMapperName + "--修改为:" + interfaceName);
//            }
            if (newFile.exists()) {//如果新文件存在，则删除旧文件

                oldFile.delete();
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("自动生成的 mapper 修改为 I***Mapper异常:",e);
        }
    }
}
