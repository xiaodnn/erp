package com.erp.generate;

import java.io.File;

/**
 * Created by scy on 2017/4/21.
 */
public class CreateFileUtil {

    /**
     * 生成文件
     * @param javapath 生成路径
     * @param interfaceName 生成接口文件名
     * @param implateName 生成实现接口文件名
     */
    public static void generateFile(String javapath,String interfaceName,String implateName){
        try {
            //创建接口文件
            createFile(javapath,interfaceName);
            //创建接口实现文件
            createFile(javapath,implateName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建文件
     * @param filePath 文件路径
     * @param fileName 文件名
     */
    private static void createFile(String filePath , String fileName){
        try {
//            File directory = new File(".");
//            String path = directory.getCanonicalPath(); //得到的是当前标准的路径

            String path = CreateFileUtil.class.getClass().getResource("/").getPath();

            File file = new File(path+filePath+fileName);//文件路径

            String file_path =  file.getCanonicalPath();//文件最后创建路径

            if(!file.exists()){
                boolean flag = file.createNewFile();
                if(flag){
                    System.out.println(file_path+"文件创建成功！");
                }else{
                    System.out.println(file_path+"文件创建失败！");
                }
            }else{
                System.out.println(file_path+"文件已存在！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
