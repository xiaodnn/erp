package com.erp.generate;


import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.stereotype.Repository;

public class GenMapper {
	public static void main(String[] args) {

//        List<String> warnings = new ArrayList<String>();
//        boolean overwrite = true;
//        Configuration config = null;
//        String name = "";
	    try{
//            String path = "D:\\ProgramFiles\\eclipseJava\\IdeaProjects\\erp\\src\\test\\resources\\mbgConfiguration.xml";
//            genMapperToPage(path);
//
//            String genCfg = "mbgConfiguration.xml";
//    //        File configFile = new File(GenMapper.class.getClass().getResource(genCfg).getPath());
//    //        File configFile = new File("D:/ProgramFiles/eclipseJava/IdeaProjects/erp/src/test/resources/mbgConfiguration.xml");
            File directory = new File(".");
            String root_path = directory.getCanonicalPath(); //得到的是当前标准的路径
            String xml_path = "/src/test/resources/mbgConfiguration.xml";//接口文件路径

//            File configFile = new File(xml_path+testjavapath+genCfg);
//            String path = "D:\\ProgramFiles\\eclipseJava\\IdeaProjects\\erp\\src\\test\\resources\\mbgConfiguration.xml";
            String path = root_path + xml_path;
            genMapperToPage(path);
//    //        try{
//    //            File file = new File(genCfg);
//    //            System.out.println(file.getPath());
//    //            System.out.println(file.getCanonicalPath());//获取标准的路径
//    //            System.out.println(file.getAbsolutePath());//获取绝对路径
//    //        }catch(Exception e){
//    //            e.printStackTrace();
//    //        }
//
//
//            ConfigurationParser cp = new ConfigurationParser(warnings);
////            Configuration config = null;
////            String name = "";
//
//            config = cp.parseConfiguration(configFile);
//            Context context = config.getContext("jenovo_main_tables");
//            List<TableConfiguration> tables = context.getTableConfigurations();
//            TableConfiguration tc = tables.get(0);
//            name = tc.getDomainObjectName();
//            System.out.println("----"+name+"--generate OK----");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (XMLParserException e) {
//            e.printStackTrace();
//        }
//        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
//        MyBatisGenerator myBatisGenerator = null;
//        try {
//            myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
//
//        } catch (InvalidConfigurationException e) {
//            e.printStackTrace();
//        }
//        try {
//            myBatisGenerator.generate(null);
//            System.out.println("----"+name+"Mapper--generate OK----");
//            modifyMapperName(name);//修改 Mapper 接口名
//
//            GenDao.writerContent(name);
//            System.out.println("----I"+name+"Dao--generate OK----");
//            GenDao.writerImplContent(name);
//            System.out.println("----"+name+"DaoImpl--generate OK----");
//            GenService.writerContent(name);
//            System.out.println("----I"+name+"Service--generate OK----");
//            GenService.writerImplContent(name);
//            System.out.println("----"+name+"ServiceImpl--generate OK----");
//            GenController.writerContent(name);
//            System.out.println("----"+name+"Controller--generate OK----");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void genMapperToPage(String path){

        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        Configuration config = null;
        String name = "";
        try{

//            String genCfg = "mbgConfiguration.xml";
            //        File configFile = new File(GenMapper.class.getClass().getResource(genCfg).getPath());
            //        File configFile = new File("D:/ProgramFiles/eclipseJava/IdeaProjects/erp/src/test/resources/mbgConfiguration.xml");
//            File directory = new File(".");
//            String xml_path = directory.getCanonicalPath(); //得到的是当前标准的路径
//            String testjavapath = "/src/main/resources/gen";//接口文件路径
//            File configFile = new File(xml_path+testjavapath+genCfg);
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
            Context context = config.getContext("jenovo_main_tables");
            List<TableConfiguration> tables = context.getTableConfigurations();
            TableConfiguration tc = tables.get(0);
            name = tc.getDomainObjectName();
            System.out.println("----"+name+"--generate OK----");
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
            myBatisGenerator.generate(null);
            System.out.println("----"+name+"Mapper--generate OK----");            
           // modifyMapperName(name);//修改 Mapper 接口名

//            GenDao.writerContent(name);
//            System.out.println("----I"+name+"Dao--generate OK----");
//            GenDao.writerImplContent(name);
//            System.out.println("----"+name+"DaoImpl--generate OK----");
//            GenService.writerContent(name);
//            System.out.println("----I"+name+"Service--generate OK----");
//            GenService.writerImplContent(name);
//            System.out.println("----"+name+"ServiceImpl--generate OK----");
//            GenController.writerContent(name);
//            System.out.println("----"+name+"Controller--generate OK----");
            //GenPage.copyPage(name);
            //System.out.println("----"+name+"page--generate OK----");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("生成从 Mapper 到 views异常:");
        }
    }

    /**
     * 自动生成的 mapper 修改为 I***Mapper
     */
    public static void modifyMapperName(String name) {
        try {
            String javapath = "/src/main/java/com/erp/orm/inter/";//接口文件路径
            String oleMapperName = name + "Mapper.java";//修改前接口文件名

            String interfaceName = "I" + name + "Mapper.java";//修改后接口文件名

            File directory = new File(".");
            String path_now = directory.getCanonicalPath(); //得到的是当前标准的路径

            File oldFile = new File(path_now + javapath + oleMapperName);
            if (!oldFile.exists()) {
                oldFile.createNewFile();
            }

            System.out.println("修改前文件名称是：" + oldFile.getName());
            String rootPath = oldFile.getParent();
            System.out.println("根路径是：" + rootPath);
            File newFile = new File(rootPath + File.separator + interfaceName);
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
                e.printStackTrace();
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
        }
    }
}
