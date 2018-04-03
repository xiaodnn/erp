package com.erp.generate;

import java.io.*;

public class GenPage {

    /**
     * 根据 mapusermodule 文件夹复制 当前生成的 页面目录和文件
     * @param name
     */
    public static void copyPage(String name) throws Exception{
        try {
            //获取要读内容文件
            File directory = new File(".");
            String root_path = directory.getCanonicalPath(); //得到的是当前标准的路径

            String views_path = "/src/main/webapp/WEB-INF/views/";//页面路径

            String srcname = "warehousing";//源文件夹名称
            String desname = name.toLowerCase();//目标文件夹名称


            copy(root_path+views_path+srcname ,root_path+views_path+desname,srcname,desname);
            System.out.println("文件拷贝完成!");

        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("生成页面时异常:",e);
        }
    }

    /**
     * 复制文件夹包含文件
     * @param src
     * @param des
     */
    private static void copy(String src, String des, String srcname,String desname) throws Exception{
        File file1=new File(src);
        File[] fs=file1.listFiles();
        File file2=new File(des);
        if(!file2.exists()){
            file2.mkdirs();
        }
        for (File f : fs) {
            if(f.isFile()){
                fileCopy(f.getPath(),des+"/"+f.getName(),srcname,desname); //调用文件拷贝的方法
            }else if(f.isDirectory()){
                copy(f.getPath(),des+"/"+f.getName(),srcname,desname);
            }
        }
    }

    /**
     * 文件拷贝的方法
     */
    private static void fileCopy(String src, String des, String srcname,String desname) throws Exception {

        BufferedReader br=null;
        PrintStream ps=null;

        try {
            br=new BufferedReader(new InputStreamReader(new FileInputStream(src)));
            ps=new PrintStream(new FileOutputStream(des));
            String s=null;
            while((s=br.readLine())!=null){
                if( s.indexOf(srcname) >= 0){
                    s= s.replace(srcname,desname);
                }
                ps.println(s);
                ps.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("生成页面文件拷贝的方法时异常:",e);
        }finally{

            try {
                if(br!=null)  br.close();
                if(ps!=null)  ps.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new Exception("生成页面文件拷贝的方法关闭文件流时异常:",e);
            }
        }
    }
}
