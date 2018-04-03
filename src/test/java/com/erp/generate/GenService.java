package com.erp.generate;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by scy on 2017/4/20.
 */
public class GenService {

    public static void createFile(){
//        String javapath = "/src/main/java/com/erp/service/";//生成文件路径
//        String interfaceName = "ICustomerService.java";//接口文件名
//        String implateName = "impl/CustomerServiceImpl.java";//实现接口文件名
//        try {
//            //创建接口文件
//            CreateFileUtil.createFile(javapath,interfaceName);
//            //创建接口实现文件
//            CreateFileUtil.createFile(javapath,implateName);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String javapath = "/src/main/java/com/erp/service/";//生成文件路径
//        String interfaceName = "ICustomerService.java";//接口文件名
//        String implateName = "impl/CustomerServiceImpl.java";//实现接口文件名
//        CreateFileUtil.generateFile(javapath,interfaceName,implateName);

    }
    /**
     * 写文件内容.生成Service接口
     */
    public static void writerContent(String name){
        String path = "/src/main/java/com/erp/service/I"+name+"Service.java";
        BufferedReader br = null;
        BufferedWriter bw = null;
        try{
            String javapath = "/src/main/java/com/erp/dao/";//接口文件路径
            String interfaceName = "I"+name+"Dao.java";//接口文件名

            //包名
            String packageName = "package com.erp.service;";
            //获取要读内容文件
            File directory = new File(".");
            String path_now = directory.getCanonicalPath(); //得到的是当前标准的路径

            //获取要写内容文件
            FileWriter writer = new FileWriter(path_now+path);
            bw = new BufferedWriter(writer);
            bw.write(packageName);
            bw.write("\r\n");
            bw.write("\r\n");

            FileReader reader = new FileReader(path_now+javapath+interfaceName);

            br = new BufferedReader(reader);//一次读取一行
            String str = br.readLine();//读取到的内容
            //一次读取一行，直到读入null时为文件结束
            while((str = br.readLine()) != null){
                if(str.indexOf("Dao") >= 0){
                    str = str.replace("Dao","Service");
                    bw.write(str);
                    bw.write("\r\n");
                    continue;
                }
                if(str.indexOf("delete") >= 0){
                    str = str.replace("delete","del");
                }
                if(str.indexOf("PrimaryKey") >= 0){
                    str = str.replace("PrimaryKey","Id");
                }
                if(str.indexOf("insert") >= 0){
                    str = str.replace("insert","save");
                }
                if(str.indexOf("Selective") >= 0){
                    str = str.replace("Selective","NotNull");
                }
                if(str.indexOf("select") >= 0){
                    str = str.replace("select","find");
                }
                if(str.indexOf("update") >= 0){
                    str = str.replace("update","modify");
                }

                bw.write(str);
                bw.write("\r\n");
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
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
        }
    }

    /**
     * 接口实现内容
     *
     */
    public static void writerImplContent(String name){
        String javapath = "/src/main/java/com/erp/service/";//需要实现接口路径
        String path = javapath + "impl/"+name+"ServiceImpl.java";//实现类文件名
        String interfaceName = "I"+name+"Service.java";//接口名
        String s = Character.toString(name.charAt(0));
        String name_lower = name.replaceFirst(s,s.toLowerCase());//小写实例名

        BufferedReader br = null;
        BufferedWriter bw = null;
        try{
            //包名
            String packageName = "package com.erp.service.impl;";
            //导入Dao接口
            String importDao = "import com.erp.dao.I"+name+"Dao;";
            //导入Service类
            String importService = "import com.erp.service.I"+name+"Service;";
            //导入注解
            String resource = "import javax.annotation.Resource;";
            //获取要读内容文件
            File directory = new File(".");
            String path_now = directory.getCanonicalPath(); //得到的是当前标准的路径

            //获取要写内容文件
            FileWriter writer = new FileWriter(path_now+path);
            bw = new BufferedWriter(writer);
            bw.write(packageName);
            bw.write("\r\n\r\n");
            bw.write(importDao);
            bw.write("\r\n");
            bw.write(importService);
            bw.write("\r\n");
            bw.write(resource);
            bw.write("\r\n");

            //
            String name_dao = name_lower+"Dao";
            //读取接口文件内容
            FileReader reader = new FileReader(path_now+javapath+interfaceName);

            br = new BufferedReader(reader);//一次读取一行
            String str = br.readLine();//读取到的内容
            //一次读取一行，直到读入null时为文件结束
            StringBuffer smethod = null;
            while((str = br.readLine()) != null){

                if(str.indexOf("interface") >= 0){//interface变成实现类
                    str = str.replace("interface","class "+name+"ServiceImpl implements ");
                    StringBuffer smapper = new StringBuffer();
                    smapper.append("\r\n\t@Resource\r\n");
                    smapper.append("\tprivate I"+name+"Dao "+name_dao+";\r\n");

                    str = str.concat(smapper.toString());
                    bw.write(str);
                }else if(str.indexOf(");") >= 0){//实现接口
                    smethod = new StringBuffer();
                    str = str.trim();
                    smethod.append("\r\n\t@Override\r\n");
                    smethod.append("\tpublic ");
                    smethod.append(str.replace(";","{\r\n"));
                    //实现内容
                    smethod.append("\t\treturn ");
                    smethod.append(name_dao);
                    smethod.append(".");
                    String scontent = str.substring(str.indexOf(" ")+1,str.length()-1);
                    //
                    if(scontent.indexOf("del") >= 0){
                        scontent = scontent.replace("del","delete");
                    }
                    if(scontent.indexOf("ById") >= 0){
                        scontent = scontent.replace("ById","ByPrimaryKey");
                    }
                    if(scontent.indexOf("save") >= 0){
                        scontent = scontent.replace("save","insert");
                    }
                    if(scontent.indexOf("NotNull") >= 0){
                        scontent = scontent.replace("NotNull","Selective");
                    }
                    if(scontent.indexOf("find") >= 0){
                        scontent = scontent.replace("find","select");
                    }
                    if(scontent.indexOf("modify") >= 0){
                        scontent = scontent.replace("modify","update");
                    }

                    scontent = scontent.replace(scontent.substring(scontent.indexOf("(")+1,scontent.indexOf(" ")+1),"");
                    smethod.append(scontent);
                    smethod.append(";\r\n");
                    smethod.append("\t}\r\n");
                    bw.write(smethod.toString());
                }else{
                    bw.write(str);
                }
                bw.write("\r\n");
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
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
        }
    }


//    public static void main(String[] args) {
//        String name = "Bcustomer";
////        writerContent(name);
////        System.out.println("----"+name+"Service--generate ok----");
//        writerImplContent(name);
//        System.out.println("----"+name+"ServiceImpl--generate ok----");
//    }

}
