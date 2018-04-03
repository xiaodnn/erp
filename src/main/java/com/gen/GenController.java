package com.gen;

import java.io.*;

import org.springframework.util.ResourceUtils;

/**
 * Created by scy on 2017/5/23.
 */
public class GenController {

    /**
     * Controller内容
     *
     */
    public static void writerContent(String rootPath,String name) throws Exception{
        String javapath = "/com/erp/controller/";//需要实现控制类路径
        String path = javapath + name+"Controller.java";//控制类文件名
//        String copyName = "OrganController.java";//被复制控制类名
        String copyName = ResourceUtils.getFile("classpath:/gen/controller.properties").getPath();
//		Path sourcepath = new File(copyName).toPath();
        

        BufferedReader br = null;
        BufferedWriter bw = null;
        try{
            //获取要读内容文件
//            File directory = new File(".");
//            String path_now = directory.getCanonicalPath(); //得到的是当前标准的路径

            //获取要写内容文件
            FileWriter writer = new FileWriter(rootPath+path);
            bw = new BufferedWriter(writer);

            //读取被复制控制类文件内容
//            FileReader reader = new FileReader(rootPath+javapath+copyName);
            FileReader reader = new FileReader(new File(copyName));

            br = new BufferedReader(reader);//一次读取一行
//            String str = br.readLine();//读取到的内容
            String str = null;
            //一次读取一行，直到读入null时为文件结束
//            StringBuffer smethod = null;
            while((str = br.readLine()) != null){
                if(str.indexOf("CONTNAME") >= 0){
                    str = str.replace("CONTNAME",name);
                }
                if(str.indexOf("contname") >= 0){
                    str = str.replace("contname",name.toLowerCase());
                }

                bw.write(str);
                bw.write("\r\n");
            }

        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("写Controller内容时异常:",e);
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
                throw new Exception("写Controller内容关闭文件流时异常:",e);
            }
        }
    }

//    public static void main(String [] args){
//        GenController.writerContent("Storezone");
//        System.out.println("ok");
//    }
}
