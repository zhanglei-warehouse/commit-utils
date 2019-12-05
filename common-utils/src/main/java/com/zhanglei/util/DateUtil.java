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
	
	/**
	 * 
	* @Title: getDayNum 
	* @Description: 获取两个时间点间的天数
	* @return int    返回类型 
	* @throws
	 */
	public static int getDayNum(Date date1,Date date2){
		//计算一天有多少毫秒
		Long dayTime = 1000*60*60*24L;
		//获取两个日期的毫秒值
		long startTime = date1.getTime();
		long endTime   = date2.getTime();
		double dayNum = Math.ceil( Math.abs((startTime-endTime)/(dayTime*1.0)));
		
		return (int)dayNum;
	}
	
	/** 
	* @Title: getDayNum 
	* @Description: 相比较今天差几天 
	* @return int    返回类型 
	* @throws 
	*/
	public static int getDayNum(Date date){
		Date date1 = new Date();
		return getDayNum(date1, date);
	}
	
	
	
	
	
	
	public static void main(String[] args) throws ParseException {
		/*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = simpleDateFormat.parse("1999-06-14");
		
		int age = getAge(date);
		System.out.println(age);*/
		
		/*int age = getAge("1999-06-14");
		System.out.println(age);*/
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd");
		Date date1 = simpleDateFormat.parse("2019-12-04");
		
		int i = getDayNum(date1);
		System.out.println(i);
	}
}
