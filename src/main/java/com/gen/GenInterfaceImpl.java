package com.gen;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Date;


/**
 * Created by scy on 2017/4/22.
 */
public class GenInterfaceImpl {

//    private String packageOutPath = "com.zero2ipo.cfj.common";//指定实体生成所在包的路径
//    private String authorName = "zhengyunfei";//作者名字
//    private String tablename = "cfj_article_attr";//表名
//    private String[] colnames; // 列名数组
//    private String[] colTypes; //列名类型数组
//    private int[] colSizes; //列名大小数组
//
//    //数据库连接
//    private static final String URL ="jdbc:mysql://172.168.8.39:3306/caifujie";
//    private static final String NAME = "root";
//    private static final String PASS = "zhengyunfei";
//    private static final String DRIVER ="com.mysql.jdbc.Driver";
//
//    /*
//     * 构造函数
//     */
//    public GenInterfaceImpl(){
//        //创建连接
//        Connection con;
//        //查要生成实体类的表
//        String sql = "select * from " + tablename;
//        PreparedStatement pStemt = null;
//        try {
//            try {
//                Class.forName(DRIVER);
//            } catch (ClassNotFoundException e1) {
//                e1.printStackTrace();
//            }
//            con = DriverManager.getConnection(URL,NAME,PASS);
//            pStemt = con.prepareStatement(sql);
//            ResultSetMetaData rsmd = pStemt.getMetaData();
//            int size = rsmd.getColumnCount();   //统计列
//            colnames = new String[size];
//            colTypes = new String[size];
//            colSizes = new int[size];
//            for (int i = 0; i < size; i++) {
//                colnames[i] = rsmd.getColumnName(i + 1);
//                colTypes[i] = rsmd.getColumnTypeName(i + 1);
//                colSizes[i] = rsmd.getColumnDisplaySize(i + 1);
//            }
//            String content = parse(colnames,colTypes,colSizes);
//            try {
//                File directory = new File("");
//                String path=this.getClass().getResource("").getPath();
//                System.out.println(path);
//                System.out.println("src/?/"+path.substring(path.lastIndexOf("/com/", path.length())) );
////              String outputPath = directory.getAbsolutePath()+ "/src/"+path.substring(path.lastIndexOf("/com/", path.length()), path.length()) + initcap(tablename) + ".java";
//                String outputPath = directory.getAbsolutePath()+ "/src/"+this.packageOutPath.replace(".", "/")+"/"+initcap(tablename)+"Impl" + ".java";
//                FileWriter fw = new FileWriter(outputPath);
//                PrintWriter pw = new PrintWriter(fw);
//                pw.println(content);
//                pw.flush();
//                pw.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally{
////          try {
////              con.close();
////          } catch (SQLException e) {
////              // TODO Auto-generated catch block
////              e.printStackTrace();
////          }
//        }
//    }

//    /**
//     * 功能：生成实体类主体代码
//     * @param colnames
//     * @param colTypes
//     * @param colSizes
//     * @return
//     */
//    private String parse(String[] colnames, String[] colTypes, int[] colSizes) {
//        StringBuffer sb = new StringBuffer();
//        sb.append("package " + this.packageOutPath + ";\r\n");
//        tablename=replaceUnderlineAndfirstToUpper(tablename.toLowerCase(),"_","");
//        importPackage(sb,this.packageOutPath+"."+initcap(tablename));
//        //注释部分
//        sb.append("   /**\r\n");
//        sb.append("    * "+tablename+" 实体类\r\n");
//        sb.append("    * "+new Date()+" "+this.authorName+"\r\n");
//        sb.append("    */ \r\n");
//        //实体部分
//        sb.append("\t@Service(\""+tablename+"\")\r\n");
//        sb.append("\tnpublic class " + initcap(tablename)+"Impl implements I"+tablename + "{\r\n");
//        sb.append("\t@Autowired @Qualifier(\"baseDao\")\r\n");
//        sb.append("\tprivate IBaseDao baseDao;\r\n");
//        add(sb,tablename);
//        update(sb,tablename);
//        delete(sb,tablename);
//        findById(sb,tablename);
//        findAllList(sb,tablename);
//        sb.append("}\r\n");
//
//        return sb.toString();
//    }
    /**
     * 导入包
     *@title
     *@date 2014-10-17
     *@author ZhengYunfei
     * @param sb
     */
    public static void importPackage(StringBuffer sb,String tablename){
        sb.append("import java.util.List;\r\n");
        sb.append("import java.util.Map;\r\n");
        sb.append("import java.util.ArrayList;\r\n");
        sb.append("import java.util.HashMap;\r\n");
        sb.append("import org.springframework.beans.factory.annotation.Autowired;\r\n");
        sb.append("import org.springframework.beans.factory.annotation.Qualifier;\r\n");
        sb.append("import org.springframework.stereotype.Service;\r\n");
        sb.append("import com.zero2ipo.framework.FwConstant;\r\n");
        sb.append("import com.zero2ipo.framework.db.bizc.IBaseDao;\r\n");
        sb.append("import com.zero2ipo.framework.exception.BaseException;\r\n");
        sb.append("import com.zero2ipo.framework.log.BaseLog;\r\n");
        sb.append("import "+tablename+"Bo;\r\n");
        sb.append("import "+tablename+"Entity;\r\n");

    }
    /**
     * 页面跳转初始化
     *@title
     *@date 2014-10-17
     *@author ZhengYunfei
     * @param sb
     * @param tablename
     */
    public static void init(StringBuffer sb,String tablename){
        infoMsg(sb,"页面跳转初始化");
        sb.append("\t@Autowired @Qualifier(\"article\")\r\n");
        sb.append("\rprivate I"+initcap(tablename)+" "+tablename+";\r\n");
        sb.append("\t@RequestMapping(\"forInit\")\r\n");
        sb.append("\tpublic ModelAndView forInit(){\t\n");
        sb.append("\tModelAndView mv=new ModelAndView();\r\n");
        sb.append("\treturn mv;\r\n");
        sb.append("\t}\r\n");
    }
    public static void add(StringBuffer sb,String tablename){
        infoMsg(sb,"新增");
        sb.append("\tpublic String add("+tablename+"Bo bo){\r\n");
        sb.append("\tString backInfo=\"保存成功\";\r\n");
        sb.append("\ttry{\r\n");
        sb.append("\t\t"+tablename +"Entity entity="+tablename+"Bo.boToEntity(bo);\r\n");
        sb.append("\t\tbaseDao.setDbType(FwConstant.DBTYPE_GLOBAL);\r\n");
        sb.append("\t\tbaseDao.addObject(\"add"+tablename+"\", entity);\r\n");
        sb.append("\t   }catch(Exception e){;\r\n");
        sb.append("\t    backInfo=\"保存失败\";\r\n");
        sb.append("\t    BaseLog.e(this.getClass(), \"add 添加失败\", e);\r\n");
        sb.append("\t    throw new BaseException(\"添加！\",e);\r\n");
        sb.append("\t}\r\n");
        sb.append("\treturn backInfo;\r\n}\r\n");

    }
    public static void update(StringBuffer sb,String tablename){
        infoMsg(sb,"修改");
        sb.append("\tpublic String update("+tablename+"Bo bo){\r\n");
        sb.append("\tString backInfo=\"修改成功\";\r\n");
        sb.append("\ttry{\r\n");
        sb.append("\t\t"+tablename +"Entity entity="+tablename+"Bo.boToEntity(bo);\r\n");
        sb.append("\t\tbaseDao.setDbType(FwConstant.DBTYPE_GLOBAL);\r\n");
        sb.append("\t\tbaseDao.updObject(\"update"+tablename+"\", entity);\r\n");
        sb.append("\t   }catch(Exception e){;\r\n");
        sb.append("\t    backInfo=\"保存失败\";\r\n");
        sb.append("\t    BaseLog.e(this.getClass(), \"update更新失败\", e);\r\n");
        sb.append("\t    throw new BaseException(\"更新！\",e);\r\n");
        sb.append("\t}\r\n");
        sb.append("\treturn backInfo;\r\n}\r\n");
    }
    public static void delete(StringBuffer sb,String tablename){
        infoMsg(sb,"删除");
        sb.append("\tpublic String delete(String id){\r\n");
        sb.append("\tString backInfo=\"删除成功\";\r\n");
        sb.append("\ttry{\r\n");
        sb.append("\t\tbaseDao.setDbType(FwConstant.DBTYPE_GLOBAL);\r\n");
        sb.append("\t\tMap<String,Object> map=new HashMap<String, Object>();\r\n");
        sb.append("\t\t map.put(\"id\",id.split(\",\"));\r\n");
        sb.append("\t\tbaseDao.delObject(\"delete"+tablename+"\", id);\r\n");
        sb.append("\t   }catch(Exception e){;\r\n");
        sb.append("\t    backInfo=\"保存失败\";\r\n");
        sb.append("\t    BaseLog.e(this.getClass(), \"add 添加失败\", e);\r\n");
        sb.append("\t    throw new BaseException(\"添加！\",e);\r\n");
        sb.append("\t}\r\n");
        sb.append("\treturn backInfo;\r\n}\r\n");
    }
    /**
     * 根据id查询
     *@title
     *@date 2014-10-17
     *@author ZhengYunfei
     * @param sb
     * @param tablename
     */
    public static void findById(StringBuffer sb,String tablename){
        infoMsg(sb,"根据Id查询");
        sb.append("\tpublic "+tablename+"Bo"+" findById(String id){\r\n");
        sb.append("\t\t"+tablename+"Entity entity=null;\r\n");
        sb.append("\t\t"+tablename +"Bo bo=null;\r\n");
        sb.append("\ttry{\r\n");
        sb.append("\t\t    baseDao.setDbType(FwConstant.DBTYPE_GLOBAL);\r\n");
        sb.append("\t\t    Map<String,Object> map=new HashMap<String, Object>();\r\n");
        sb.append("\t\t    map.put(\"id\",id);\r\n");
        sb.append("\t\t    entity=("+tablename+"Entity)baseDao.findForObject(\"findById"+tablename+"\", id);\r\n");
        sb.append("\t\t  bo="+tablename+"Bo.entityToBo(entity);\r\n");
        sb.append("\t   }catch(Exception e){;\r\n");
        sb.append("\t    BaseLog.e(this.getClass(), \"findById 查询失败\", e);\r\n");
        sb.append("\t    throw new BaseException(\"查询！\",e);\r\n");
        sb.append("\t}\r\n");
        sb.append("\treturn bo;\r\n}\r\n");
    }
    /**
     * 查询所有信息
     *@title
     *@date 2014-10-17
     *@author ZhengYunfei
     * @param sb
     * @param tablename
     */
    public static void findAllList(StringBuffer sb,String tablename){
        infoMsg(sb,"查询所有信息");


        sb.append("\tpublic List<"+tablename+"Bo"+" findAllList(Map<String,Object> map,String curNo, String curSize){\r\n");
        sb.append("\t\tList<"+tablename+"Bo"+"> boList=new ArrayList<"+tablename+"Bo"+">();\r\n");
        sb.append("\t\tList<"+tablename+"Entity"+"> entityList=new ArrayList<"+tablename+"Entity"+">();\r\n");
        sb.append("\ttry{\r\n");
        sb.append("\t    baseDao.setDbType(FwConstant.DBTYPE_GLOBAL);\r\n");
        sb.append("\t    entityList=baseDao.findForList(\"findById"+tablename+"\", map);\r\n");
        sb.append("\t\tfor(int i=0;i<entityList.size();i++){"+"\r\n");
        sb.append("\t\t"+tablename+"Entity"+" entity=entityList.get(i);\r\n");
        sb.append("\t\t"+tablename+"Bo bo="+tablename+"Bo.entityToBo(entity);"+"\r\n");
        sb.append("\t\t"+"boList.add(bo);"+"\r\n");
        sb.append("\t"+"}"+"\r\n");
        sb.append("\t   }catch(Exception e){;\r\n");
        sb.append("\t    BaseLog.e(this.getClass(), \"findById 查询失败\", e);\r\n");
        sb.append("\t    throw new BaseException(\"查询！\",e);\r\n");
        sb.append("\t}\r\n");
        sb.append("\treturn boList;\r\n}\r\n");
    }
    /**
     * 自动生成注释
     *@title
     *@date 2014-10-17
     *@author ZhengYunfei
     */
    public static void infoMsg(StringBuffer sb,String msg){
        sb.append("\t/**\r\n");
        sb.append("\t*"+msg+"\r\n");
        sb.append("\t*@author zhengYunFei\r\n");
        sb.append("\t*@date "+new Date()+"\r\n");
        sb.append("\t*/\r\n");
    }
    /**
     * 首字母大写
     *
     * @param srcStr
     * @return
     */
    public static String firstCharacterToUpper(String srcStr) {
        return srcStr.substring(0, 1).toUpperCase() + srcStr.substring(1);
    }
    /**
     * 替换字符串并让它的下一个字母为大写
     * @param srcStr
     * @param org
     * @param ob
     * @return
     */
    public static String replaceUnderlineAndfirstToUpper(String srcStr,String org,String ob)
    {
        String newString = "";
        int first=0;
        while(srcStr.indexOf(org)!=-1)
        {
            first=srcStr.indexOf(org);
            if(first!=srcStr.length())
            {
                newString=newString+srcStr.substring(0,first)+ob;
                srcStr=srcStr.substring(first+org.length(),srcStr.length());
                srcStr=firstCharacterToUpper(srcStr);
            }
        }
        newString=newString+srcStr;
        return newString;
    }


    /**
     * 功能：将输入字符串的首字母改成大写
     * @param str
     * @return
     */
    private static String initcap(String str) {

        char[] ch = str.toCharArray();
        if(ch[0] >= 'a' && ch[0] <= 'z'){
            ch[0] = (char)(ch[0] - 32);
        }

        return new String(ch);
    }

    /**
     * 出口
     * TODO
     * @param args
     */
//    public static void main(String[] args) {
//
//        new GenInterfaceImpl();
//
//    }
}
