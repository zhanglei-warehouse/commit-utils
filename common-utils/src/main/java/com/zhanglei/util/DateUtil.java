package com.zhanglei.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/** 
* @author Name: zhanglei
* @version Time：2019年12月5日 下午2:34:48 
* 类说明 
*/
public class DateUtil {
	/**
	 * 
	* @Title: getAge 
	* @Description: 根据生日计算年龄
	* @return int    返回类型 
	* @throws
	 */
	public static int getAge(Date date){
		//获取日历控件
		Calendar calendar = Calendar.getInstance();
		int nowYear = calendar.get(Calendar.YEAR);
		int nowMonth = calendar.get(Calendar.MONTH);
		int nowDay = calendar.get(Calendar.DAY_OF_MONTH);
		//设置生日
		calendar.setTime(date);
		int birthYear = calendar.get(Calendar.YEAR);
		int birthMonth = calendar.get(Calendar.MONDAY);
		int birthDay = calendar.get(Calendar.DAY_OF_MONTH);
		//年龄
		int age = nowYear-birthYear;
		if(birthMonth>nowMonth){
			age--;
		}
		if(birthMonth==nowMonth && nowDay<birthDay){
			age--;
		}
		return age;
	}
	
	/**
	 * 
	* @Title: getAge 
	* @Description:  根据生日计算年龄
	* @return int    返回类型 
	* @throws
	 */
	public static int getAge(String birthDate){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-hh");
		Date date = null;
		try {
			date = simpleDateFormat.parse(birthDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getAge(date);
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws ParseException {
		/*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = simpleDateFormat.parse("1999-06-14");
		
		int age = getAge(date);
		System.out.println(age);*/
		
		int age = getAge("1999-06-14");
		System.out.println(age);
	}
}
