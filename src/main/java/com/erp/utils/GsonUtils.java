/**
 * 
 */
package com.erp.utils;

import java.lang.reflect.Type;
import java.util.List;

import com.erp.model.JsonTableStructField;
import com.erp.model.JsonWarehousingDetail;
import com.erp.model.JsonWholesaleApplyDetail;
import com.erp.model.JsonWholesaleDetail;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

/**
 *
 *
 * @author scy
 * @date 2015年12月2日
 */
public class GsonUtils {
	
	private static Gson gson = null;

	private static Gson getInstance(){
		if(null == gson){
//			gson = new Gson();
			gson = new GsonBuilder()
				    .setPrettyPrinting()
				    .disableHtmlEscaping()
				    .create();
		}
		return gson;
	}
	
	/**
	 * 对象 转 json
	 * @param obj
	 * @return
	 */
	public static String toStr(Object obj){
		Gson gson = getInstance();
//		String s = gson.toJson(obj, obj.getClass());
		String s = gson.toJson(obj);
		return s;
	}
	
		public static String toJsonTree(Object obj){
			Gson gson = getInstance();
			Type type = new TypeToken<List<Tree>>(){}.getType();
			JsonElement element = gson.toJsonTree(obj,type);
	        String s = gson.toJson(element);  
//			String s = gson.toJson(obj, type);
			return s;
		}
	 
	/**
	 * json 转 对象
	 * @param json
	 * @return
	 */
	public static <T>Object toBean(String json ,Class<T> clazz){
		Gson gson = getInstance();
		T rj = gson.fromJson(json, clazz);
		return rj;
	}
		
	public static <T> T toTobject(String data){
		Type type = new TypeToken<T>(){}.getType();
		Gson gson = getInstance();
		T list = gson.fromJson(data, type);
		return list;
	}

	/**
	 * 采购入库单明细
	 * @param data
	 * @return
	 */
	public static List<JsonWarehousingDetail> toToListWarehousingDetail(String data){
		Type type = new TypeToken<List<JsonWarehousingDetail>>(){}.getType();
		Gson gson = getInstance();
		return gson.fromJson(data, type);
	}

	/**
	 * 批发销售申请单
	 * @param data
	 * @return
	 */
	public static List<JsonWholesaleApplyDetail> toToListWholesaleApplyDetail(String data){
		Type type = new TypeToken<List<JsonWholesaleApplyDetail>>(){}.getType();
		Gson gson = getInstance();
		return gson.fromJson(data, type);
	}

	/**
	 * 批发销售单
	 * @param data
	 * @return
	 */
    public static List<JsonWholesaleDetail> toToListWholesaleDetail(String data) {
		Type type = new TypeToken<List<JsonWholesaleDetail>>(){}.getType();
		Gson gson = getInstance();
		return gson.fromJson(data, type);
    }
    
    /**
	 * json转List<T>
     * @param <T>
     * @param <T>
     * @param <T>
	 * @param data
	 * @return
	 */
    public static List<JsonTableStructField> jsonToJsonTableStructFieldList(String data) {
		Type type = new TypeToken<List<JsonTableStructField>>(){}.getType();
		Gson gson = getInstance();
		return  gson.fromJson(data, type);
    }
    
}
