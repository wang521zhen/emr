package com.yjemr.util;

/**
 * 字符串相关方法
 */
public class StringUtil {

	/**
	 * 将以逗号分隔的字符串转换成字符串数组
	 * 
	 * @param valStr
	 * @return String[]
	 */
	public static String[] StrList(String valStr) {
		int i = 0;
		String TempStr = valStr;
		String[] returnStr = new String[valStr.length() + 1 - TempStr.replace(",", "").length()];
		valStr = valStr + ",";
		while (valStr.indexOf(',') > 0) {
			returnStr[i] = valStr.substring(0, valStr.indexOf(','));
			valStr = valStr.substring(valStr.indexOf(',') + 1, valStr.length());

			i++;
		}
		return returnStr;
	}
	
	/**
	 * 转String
	 * @param obj
	 * @return
	 */
	public static String toString(Object obj){
		if(null != obj)
			return String.valueOf(obj);
		return null;
	} 
	
	/**
	 * 转String，null时返回""
	 * @param obj
	 * @return
	 */
	public static String toStringOrEmpty(Object obj){
		if(null != obj)
			return String.valueOf(obj);
		return "";
	}
	
	/**
	 * 判断是否为null或空
	 * @param str
	 * @return
	 */
	public static boolean isNotNull(String str){
		if(str != null && str.trim().length() > 0)
			return true;
		return false;
	}
}
