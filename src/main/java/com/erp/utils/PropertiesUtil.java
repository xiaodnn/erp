/**
 * 
 */
package com.erp.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.springframework.util.ResourceUtils;

/**
 * @author xiao
 *
 */
public class PropertiesUtil {
	//属性文件的路径   
    static String profilepath="classpath:/gen/generator_config.properties";   
    /**  
    * 采用静态方法  
    */   
    Properties props = null;
    
    public PropertiesUtil(){    	
    	props = new Properties();    	
    	try {
			props.load(new FileInputStream(ResourceUtils.getFile(profilepath)));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
//    static {   
//        try {   
//            props.load( new FileInputStream(profilepath));   
//        } catch (Exception e) {   
//            e.printStackTrace();   
//            System.exit(-1);   
//        }
//    }   
  
    /**  
    * 读取属性文件中相应键的值  
    * @param key  
    *            主键  
    * @return String  
    */   
    public String getKeyValue(String key) {   
        return props.getProperty(key);   
    }   
  
    /**  
    * 根据主键key读取主键的值value  
    * @param filePath 属性文件路径  
    * @param key 键名  
    */   
    public String readValue(String filePath, String key) {   
//        Properties props = new Properties();
        try {   
//            InputStream in = new BufferedInputStream(new FileInputStream(   
//                    filePath));   
//            props.load(in);   
            String value = props.getProperty(key);   
            System.out.println(key +"键的值是："+ value);   
            return value;   
        } catch (Exception e) {   
            e.printStackTrace();   
            return null;   
        }   
    }   
      
    /**  
    * 更新（或插入）一对properties信息(主键及其键值)  
    * 如果该主键已经存在，更新该主键的值；  
    * 如果该主键不存在，则插件一对键值。  
    * @param keyname 键名  
    * @param keyvalue 键值  
    */   
    public void writeProperties(String keyname,String keyvalue) {          
        try {   
            // 调用 Hashtable 的方法 put，使用 getProperty 方法提供并行性。   
            // 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。   
//        	File file =  PropertiesUtil.class.getResourceAsStream(profilepath);
            OutputStream fos = new FileOutputStream(ResourceUtils.getFile(profilepath));   
            props.setProperty(keyname, keyvalue);   
            // 以适合使用 load 方法加载到 Properties 表中的格式，   
            // 将此 Properties 表中的属性列表（键和元素对）写入输出流   
            props.store(fos, "Update '" + keyname + "' value");
            fos.flush();
            fos.close();
        } catch (IOException e) {   
            System.err.println("属性文件writeProperties更新错误:"+e);   
        }   
    }   
  
    /**  
    * 更新properties文件的键值对  
    * 如果该主键已经存在，更新该主键的值；  
    * 如果该主键不存在，则插件一对键值。  
    * @param keyname 键名  
    * @param keyvalue 键值  
    */   
    public void updateProperties(String keyname,String keyvalue) {   
        try {
            
            // 调用 Hashtable 的方法 put，使用 getProperty 方法提供并行性。   
            // 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。   
            OutputStream fos = new FileOutputStream(ResourceUtils.getFile(profilepath));              
            props.setProperty(keyname, keyvalue);   
            // 以适合使用 load 方法加载到 Properties 表中的格式，   
            // 将此 Properties 表中的属性列表（键和元素对）写入输出流   
            props.store(fos, "Update '" + keyname + "' value");
            fos.flush();
            fos.close();
        } catch (IOException e) {   
            System.err.println("属性文件updateProperties更新错误:"+e);   
        }   
    }
}
