package com.gen;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.util.ResourceUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * XML 文件操作
 */
public class XMLUtil {

    public static void main(String [] args){
    	try {
//			operateWrite("ts_test11","Test22");
    		String sourcePath = "D:/ProgramFiles/eclipseJava/workspace/erp/src/main/resources/gen/genxml.txt";
    		System.out.println(sourcePath.substring(0, sourcePath.lastIndexOf("/")+1));
    		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("-------------修改完成");
    }
	
    /**
     * 复制文件，追加内容方式处理
     * @param tableName
     * @param domainObjectName
     * @return
     * @throws Exception
     */
	public static String operateWrite(String tableName,String domainObjectName) throws Exception {
		String destPath = null;
	    try {
//        String genCfg = "mbgConfiguration.xml";
//        File directory = new File(".");
//        String xml_path = directory.getCanonicalPath(); //得到的是当前标准的路径
//        String testjavapath = "/src/main/resources/gen/";//接口文件路径
	        //获取mbgConfiguration.xml文件路径
//	        path = ResourceUtils.getFile("classpath:/gen/mbgConfiguration.xml").getPath();
//	    	path = "D:/ProgramFiles/eclipseJava/workspace/erp/src/main/resources/gen/mbgConfiguration.xml";
	    	
	    	String sourcePath = ResourceUtils.getFile("classpath:/gen/genxml.txt").getPath();
//	    	String sourcePath = "D:/ProgramFiles/eclipseJava/workspace/erp/src/main/resources/gen/genxml.txt";
	    	
	    	Path sourcepath = new File(sourcePath).toPath();
	    	
	    	
	    	String uuid = UUID.randomUUID().toString();
	    	
	    	String ss = sourcePath.substring(0, sourcePath.lastIndexOf("\\")+1);
	    	
	    	destPath = ss.concat(uuid).concat(".xml");
	    	System.out.println("----生成文件的XML文件:"+destPath);
	    	Path destpath = new File(destPath).toPath();
	    	
	    	Files.copy(sourcepath,destpath);
	    	
	    	
	    	 FileWriter writer = null;  
	         try {     
	             // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件     
	             writer = new FileWriter(destPath, true);
	             StringBuffer content = new StringBuffer();
	             content.append("\t\ttableName=\"");
	             content.append(tableName);
	             content.append("\" domainObjectName=\"");
	             content.append(domainObjectName);
	             content.append("\" >\r\n");     
	             content.append("\t</table>\r\n");
	             content.append("\t</context>\r\n"); 
	             content.append("</generatorConfiguration>\r\n");
	             writer.write(content.toString());       
	         } catch (IOException e) {     
	             e.printStackTrace();     
	         } finally {     
	             try {     
	                 if(writer != null){  
	                     writer.close();     
	                 }  
	             } catch (IOException e) {     
	                 e.printStackTrace();     
	             }     
	         }   
	         
	    	
//	         Files.delete(destpath);
	    	
//	    	 File xmlFile = new File(path);
//
//		    FileReader reader = new FileReader(xmlFile);
//	        BufferedReader br = new BufferedReader(reader);//一次读取一行
//	         
//	        //获取要写内容文件
//	        String newpath = "E:/mbgConfiguration1.xml";
//	    	
//	        File xmlNewFile = new File(newpath);
//            FileWriter writer = new FileWriter(xmlNewFile);
//            BufferedWriter  bw = new BufferedWriter(writer);
//            
//           
//            String str = null;//读取到的内容
//	        
//            while((str = br.readLine()) != null){
//            	 if(str.indexOf("domainObjectName") >= 0){
//            		 System.out.println(str);
//            	 }
//            	 if(str.indexOf("tableName") >= 0){
//            		 System.out.println(str);
//            	 }
//            	 bw.write(str);
//                 bw.write("\r\n");
//            }
//            
//            try{
//                if(bw != null){
//                    bw.flush();
//                    bw.close();
//                    bw = null;
//                }
//                if(br != null){
//                    br.close();
//                    br = null;
//                }
//            }catch (Exception e){
//                bw = null;
//                br = null;
//                throw new Exception("自动生成的 mapper 修改为 I***Mapper时,关闭文件流异常:",e);
//            }
	        	        
	    	}catch(Exception e){
	    		 throw new Exception("操作 XML 元素异常:",e);
	    	}
	    	return destPath;
		}
	
    /***
     * 操作 XML 元素
     * @param tableName
     * @param domainObjectName
     */
    public static String operate(String tableName,String domainObjectName) throws Exception{
        String path = null;
        try {
//            String genCfg = "mbgConfiguration.xml";
//            File directory = new File(".");
//            String xml_path = directory.getCanonicalPath(); //得到的是当前标准的路径
//            String testjavapath = "/src/main/resources/gen/";//接口文件路径
            //获取mbgConfiguration.xml文件路径
            path = ResourceUtils.getFile("classpath:/gen/mbgConfiguration.xml").getPath();
//        	path = "D:/ProgramFiles/eclipseJava/workspace/erp/src/main/resources/gen/mbgConfiguration.xml";

//            File xmlFile = new File(xml_path+testjavapath+genCfg);
            File xmlFile = new File(path);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder;

            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
//            doc.getDocumentElement().normalize();

            //update attribute value
            updateAttributeValue(doc,tableName,domainObjectName);//修改属性

            //update Element value
//            updateElementValue(doc);//修改元素

            //delete element
//            deleteElement(doc)//删除元素;

            //add new element
//            addElement(doc);//添加元素

            //write the updated document to file or console
//            doc.getDocumentElement().normalize();
//            TransformerFactory transformerFactory = TransformerFactory.newInstance();
//            Transformer transformer = transformerFactory.newTransformer();
//            DOMSource source = new DOMSource(doc);
////            StreamResult result = new StreamResult(new File(xml_path+testjavapath+"mbgConfiguration.xml"));
//            StreamResult result = new StreamResult(new File(path));
//
//            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//            transformer.transform(source, result);

            System.out.println("XML file updated successfully");
        } catch (Exception e1) {
//        } catch (SAXException | ParserConfigurationException | IOException | TransformerException e1) {
            e1.printStackTrace();
            throw new Exception("操作 XML 元素异常:",e1);
        }
        return path;
    }

    private static void addElement(Document doc) {
        NodeList employees = doc.getElementsByTagName("table");
        Element emp = null;

        //loop for each employee
        for(int i=0; i<employees.getLength();i++){
            emp = (Element) employees.item(i);
            Element salaryElement = doc.createElement("salary");
            salaryElement.appendChild(doc.createTextNode("10000"));
            emp.appendChild(salaryElement);
        }
    }

    private static void deleteElement(Document doc) {
        NodeList employees = doc.getElementsByTagName("table");
        Element emp = null;
        //loop for each employee
        for(int i=0; i<employees.getLength();i++){
            emp = (Element) employees.item(i);
            Node genderNode = emp.getElementsByTagName("gender").item(0);
            emp.removeChild(genderNode);
        }

    }

    private static void updateElementValue(Document doc) {
        NodeList employees = doc.getElementsByTagName("table");
        Element emp = null;
        //loop for each employee
        for(int i=0; i<employees.getLength();i++){
            emp = (Element) employees.item(i);
            Node name = emp.getElementsByTagName("name").item(0).getFirstChild();
            name.setNodeValue(name.getNodeValue().toUpperCase());
        }
    }

    private static void updateAttributeValue(Document doc,String tableName,String domainObjectName) {
        NodeList employees = doc.getElementsByTagName("table");
        Element emp = null;
        //loop for each employee
        for(int i=0; i<employees.getLength();i++){
            emp = (Element) employees.item(i);
            emp.setAttribute("tableName", tableName);
            emp.setAttribute("domainObjectName", domainObjectName);

//            String gender = emp.getElementsByTagName("gender").item(0).getFirstChild().getNodeValue();
//            if(gender.equalsIgnoreCase("male")){
//                //prefix id attribute with M
//                emp.setAttribute("id", "M"+emp.getAttribute("id"));
//            }else{
//                //prefix id attribute with F
//                emp.setAttribute("id", "F"+emp.getAttribute("id"));
//            }
        }
    }

    /**
     * 将表名、实体名添加到文本文件中，然后复制到属性文件
     * @param tableName
     * @param entityName
     * @return
     */
	public static void operateProper(String tableName, String entityName) {
		FileWriter writer = null; 
		try{
			String sourcePath = ResourceUtils.getFile("classpath:/gen/genproperty.txt").getPath();
			Path sourcepath = new File(sourcePath).toPath();
			
	    	String destPath = ResourceUtils.getFile("classpath:/gen/generator_config.properties").getPath();
	    	System.out.println("----生成文件的XML文件:"+destPath);
	    	
	    	File file = new File(destPath);
	    	Path destpath = file.toPath();
	    	
	    	if(file.exists()){
//	    		file.delete();
	    		 Files.delete(destpath);
	    	}
	    	
//	    	Path destpath = file.toPath();
	    	//从 sourcepath 写入 destpath 文件中
	    	Files.copy(sourcepath,destpath);
            
             // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件     
//             writer = new FileWriter(destPath, true);
	    	 writer = new FileWriter(destPath,true);
	    	 
             StringBuffer content = new StringBuffer();
             content.append("tableName=");
             content.append(tableName);
             content.append("\r\n");
             content.append("domainObjectName=");
             content.append(entityName);
             content.append("\r\n");
             writer.write(content.toString());
         } catch (IOException e) {     
             e.printStackTrace();     
         } finally {     
             try {     
                 if(writer != null){  
                     writer.close();     
                 }  
             } catch (IOException e) {     
                 e.printStackTrace();     
             }     
         } 
	}
}
