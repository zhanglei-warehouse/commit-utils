package com.zhanglei.util;

import java.util.regex.Pattern;

/** 
* @author Name: zhanglei
* @version Time：2019年12月5日 下午1:41:50 
* 类说明 
*/
public class StringUtil {
	/**
	 * 
	* @Title: isNotBlank 
	* @Description: TODO(判断字符串是否不为空) 
	* @param @param string
	* @return boolean   返回类型  
	* @throws
	 */
	public static boolean isNotBlank(String string){
		if(string==null){
			return false;
		}
		string.trim();
		if(string.length()==0){
			return false;
		}
		return true;
	}
	/**
	 * 
	* @Title: isBlank 
	* @Description: TODO(判断字符串是否为空) 
	* @param @param string
	* @return boolean    返回类型 
	* @throws
	 */
	public static boolean isBlank(String string){
		return !isNotBlank(string);
	}
	/**
	 * 
	* @Title: isPhoneNum 
	* @Description: TODO(判断字符串是否为手机号) 
	* @return boolean    返回类型 
	* @throws
	 */
	public static boolean isPhoneNum(String string){
		String phoneNum = "1\\d{10}";
		boolean b = Pattern.matches(phoneNum, string);
		return b;
	}
	/**
	 * 
	* @Title: isEmail 
	* @Description: TODO(验证字符串是否是邮箱) 
	* @return boolean    返回类型 
	* @throws
	 */
	public static boolean isEmail(String string){
		String email = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		boolean b = Pattern.matches(email, string);
		return b;
	}
	
	/**
	 * 
	* @Title: isEnglish 
	* @Description: TODO(验证是否全为英文) 
	* @return boolean    返回类型 
	* @throws
	 */
	public static boolean isEnglish(String string){
		String english = "[A-z]+";
		boolean b = Pattern.matches(english, string);
		return b;
	}
	
	
	
	
}
