package com.gen;

import java.io.*;

/**
 * Created by scy on 2017/4/20.
 */
public class GenDao {

    /**
     * 创建Dao接口和实现类
     */
    public static void createFile(){
//        String javapath = "/src/main/java/com/erp/dao/";//生成文件路径
//        String interfaceName = "ICustomerDao.java";//接口文件名
//        String implateName = "impl/CustomerDaoImpl.java";//实现接口文件名
//        CreateFileUtil.generateFile(javapath,interfaceName,implateName);
    }

    /**
     * 写Dao文件内容
     */
    public static void writerContent(String rootPath,String name) throws Exception{
    	
        String path = "/com/erp/dao/I"+name+"Dao.java";
        BufferedReader br = null;
        BufferedWriter bw = null;
        try{
            String javapath = "/com/erp/orm/inter/";//接口文件路径
            String interfaceName = "I"+name+"Mapper.java";//接口文件名
            //包名
            String packageName = "package com.erp.dao;";
            //导入Mapper类
//            String importMapper = "import com.erp.orm.inter.IBcustomerMapper;";
            //获取要读内容文件
//            File directory = new File(".");
//            String path_now = directory.getCanonicalPath(); //得到的是当前标准的路径

            //获取要写内容文件
            FileWriter writer = new FileWriter(rootPath+path);
            bw = new BufferedWriter(writer);
            bw.write(packageName);
            bw.write("\r\n");
//            bw.write(importMapper);
            bw.write("\r\n");
            //File fileReader = new File(path_now+javapath+interfaceName);
            FileReader reader = new FileReader(rootPath+javapath+interfaceName);

            br = new BufferedReader(reader);//一次读取一行
            String str = br.readLine();//读取到的内容
            //一次读取一行，直到读入null时为文件结束

            while((str = br.readLine()) != null){
                if(str.indexOf("Mapper") >= 0){
                    str = str.replace("Mapper","Dao");
                }
                if(str.indexOf("record") >= 0){
                    String s = Character.toString(name.charAt(0));
                    str = str.replace("record",name.replaceFirst(s,s.toLowerCase()));
                }
                if(str.indexOf("Map<String,Integer> map") >= 0){
                    str = str.replace("Map<String,Integer> map","Integer page, Integer rows");
                }
                if(str.indexOf("Map<String,Object> map") >= 0){
                    str = str.replace("Map<String,Object> map"," ");
                }

                bw.write(str);
                bw.write("\r\n");
            }

        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("写Dao文件内容异常:",e);
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
                throw new Exception("写Dao文件内容异常:",e);
            }
        }
    }

    /**
     * Dao接口实现内容
     *
     */
    public static void writerImplContent(String rootPath,String name) throws Exception{
        String javapath = "/com/erp/dao/";//需要实现接口路径
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
//            File directory = new File(".");
//            String path_now = directory.getCanonicalPath(); //得到的是当前标准的路径

            //获取要写内容文件
            FileWriter writer = new FileWriter(rootPath+path);
            bw = new BufferedWriter(writer);
            bw.write(packageName);
            bw.write("\r\n\r\n");
            bw.write(importMapper);
            bw.write("\r\n");
            bw.write(importInterface);
            bw.write("\r\n");
            bw.write(resource);
            bw.write("\r\n");
            bw.write("import java.util.HashMap;");
            bw.write("\r\n");

            //
            String name_mapper = name_lower+"Mapper";
            //读取接口文件内容
            FileReader reader = new FileReader(rootPath+javapath+interfaceName);

            br = new BufferedReader(reader);//一次读取一行
            String str = br.readLine();//读取到的内容
            //一次读取一行，直到读入null时为文件结束
            StringBuffer smethod = null;
            while((str = br.readLine()) != null){

                if(str.indexOf("interface") >= 0){ //interface变成实现类
                    str = str.replace("interface","class "+name+"DaoImpl implements ");
                    StringBuffer smapper = new StringBuffer();
                    smapper.append("\r\n\t@Resource\r\n");
                    smapper.append("\tprivate I"+name+"Mapper "+name_mapper+";\r\n");

                    str = str.concat(smapper.toString());
                    bw.write(str);
                }else if(str.indexOf("selectByPage(Integer page, Integer rows);") >= 0){//实现 selectByPage 接口
                    smethod = new StringBuffer();
                    str = str.trim();
                    smethod.append("\r\n\t@Override\r\n");
                    smethod.append("\tpublic ");
                    smethod.append(str.replace(";","{\r\n"));
                    //实现内容
                    smethod.append("\t\tMap<String,Integer> map = new HashMap<String,Integer>();\r\n");
                    smethod.append("\t\tmap.put(\"pageStart\",page*rows);\r\n");
                    smethod.append("\t\tmap.put(\"pageSize\",rows);\r\n");
                    smethod.append("\t\treturn ");
                    smethod.append(name_mapper);
                    smethod.append(".selectByPage(map)");
                    smethod.append(";\r\n");
                    smethod.append("\t}\r\n");
                    bw.write(smethod.toString());
                }else if(str.indexOf("selectCount( );") >= 0){//实现 selectCount 接口
                    smethod = new StringBuffer();
                    str = str.trim();
                    smethod.append("\r\n\t@Override\r\n");
                    smethod.append("\tpublic ");
                    smethod.append(str.replace(";","{\r\n"));
                    //实现内容
                    smethod.append("\t\tMap<String,Object> map = new HashMap<>();\r\n");
                    smethod.append("\t\treturn ");
                    smethod.append(name_mapper);
                    smethod.append(".selectCount(map)");
                    smethod.append(";\r\n");
                    smethod.append("\t}\r\n");
                    bw.write(smethod.toString());
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
            throw new Exception("写Dao接口实现内容异常:",e);
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
                throw new Exception("写Dao接口实现内容异常:",e);
            }
        }
    }

//    public static void main(String[] args) {
//        String name = "Bcustomer";
//        writerContent(name);
//        System.out.println("----"+name+"Dao--generate ok----");
//    }

}
