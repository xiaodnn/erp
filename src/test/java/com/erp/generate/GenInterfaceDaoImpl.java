package com.erp.generate;

import java.io.*;

/**
 * Created by scy on 2017/4/22.
 */
public class GenInterfaceDaoImpl {

    String interfaceName = "ICustomerDao11";

    /**
     * 接口实现内容
     *
     */
    public static void writerImplContent(String name){
        String javapath = "/src/main/java/com/erp/dao/";//需要实现接口路径
        String path = javapath + "impl/"+name+"DaoImpl.java";//实现类文件名
        String interfaceName = "I"+name+"Dao.java";//接口名
        String s = Character.toString(name.charAt(0));
        String name_lower = name.replaceFirst(s,s.toLowerCase());//小写实例名

        BufferedReader br = null;
        BufferedWriter bw = null;
        try{
            //包名
            String packageName = "package com.erp.dao.impl;";
            //导入Mapper类
            String importMapper = "import com.erp.orm.inter.I"+name+"Mapper;";
            //导入Dao接口
            String importInterface = "import com.erp.dao.I"+name+"Dao;";
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
            bw.write(importMapper);
            bw.write("\r\n");
            bw.write(importInterface);
            bw.write("\r\n");
            bw.write(resource);
            bw.write("\r\n");

            //
            String name_mapper = name_lower+"Mapper";
            //读取接口文件内容
            FileReader reader = new FileReader(path_now+javapath+interfaceName);

            br = new BufferedReader(reader);//一次读取一行
            String str = br.readLine();//读取到的内容
            //一次读取一行，直到读入null时为文件结束
            StringBuffer smethod = null;
            while((str = br.readLine()) != null){

                if(str.indexOf("interface") >= 0){//interface变成实现类
                    str = str.replace("interface","class "+name+"DaoImpl implements ");
                    StringBuffer smapper = new StringBuffer();
                    smapper.append("\r\n\t@Resource\r\n");
                    smapper.append("\tprivate I"+name+"Mapper "+name_mapper+";\r\n");

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
                    smethod.append(name_mapper);
                    smethod.append(".");
                    String scontent = str.substring(str.indexOf(" ")+1,str.length()-1);
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

//    public static void main(String [] args){
//        String name = "Bcustomer";
//        writerImplContent(name);
//        System.out.println("----ok----");
//    }
}
