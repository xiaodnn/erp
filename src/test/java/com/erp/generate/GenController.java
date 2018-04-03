package com.erp.generate;

import java.io.*;

/**
 * Created by scy on 2017/5/23.
 */
public class GenController {

    /**
     * Controller内容
     *
     */
    public static void writerContent(String name){
        String javapath = "/src/main/java/com/erp/controller/";//需要实现控制类路径
        String path = javapath + name+"Controller.java";//控制类文件名
        String copyName = "OrganController.java";//被复制控制类名

        BufferedReader br = null;
        BufferedWriter bw = null;
        try{
            //获取要读内容文件
            File directory = new File(".");
            String path_now = directory.getCanonicalPath(); //得到的是当前标准的路径

            //获取要写内容文件
            FileWriter writer = new FileWriter(path_now+path);
            bw = new BufferedWriter(writer);

            //读取被复制控制类文件内容
            FileReader reader = new FileReader(path_now+javapath+copyName);

            br = new BufferedReader(reader);//一次读取一行
//            String str = br.readLine();//读取到的内容
            String str = null;
            //一次读取一行，直到读入null时为文件结束
            StringBuffer smethod = null;
            while((str = br.readLine()) != null){
                if(str.indexOf("Organ") >= 0){
                    str = str.replace("Organ",name);
                }
                if(str.indexOf("organ") >= 0){
                    str = str.replace("organ",name.toLowerCase());
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

    public static void main(String [] args){
        GenController.writerContent("Storezone");
        System.out.println("ok");
    }
}
