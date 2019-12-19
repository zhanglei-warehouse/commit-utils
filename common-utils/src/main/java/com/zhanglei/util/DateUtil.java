package com.zhanglei.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/** 
* @author Name: zhanglei
* @version Time：2019年12月5日 下午2:34:48 
* 类说明 
* 
* 日期工具类
*/
public class DateUtil {
	@SuppressWarnings("unused")
	public static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * @Title: format   
	 * @Description: 时间格式化  
	 * @param: @param theDate
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String format(Date theDate) {
		return dateFormat.format(theDate);
	}
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
	
	/** 
	* @Title: isToday 
	* @Description:验证日期是否为今天 
	* @return boolean    返回类型 
	* @throws 
	*/
	public static boolean isToday(Date theDate){
		
		Date nowDate = new Date();
		String nowDateStr = dateFormat.format(nowDate);
		String theDateStr = dateFormat.format(theDate);
		return nowDateStr.equals(theDateStr);
	}
	
	/** 
	* @Title: isToday 
	* @Description: 验证日期是否为今天 
	* @return boolean    返回类型 
	* @throws 
	*/
	public static boolean isToday(String theDateStr){
		try {
			Date theDate = dateFormat.parse(theDateStr);
			return isToday(theDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	/** 
	* @Title: isInWeek 
	* @Description: 判定日期是否在本周 
	* @return boolean    返回类型 
	* @throws 
	*/
	public static boolean isInWeek(Date theDate){
		Calendar calendar = Calendar.getInstance();
		int nowYear = calendar.get(Calendar.YEAR);
		int nowWeek = calendar.get(Calendar.WEEK_OF_YEAR);
		calendar.setTime(theDate);
		int theYear = calendar.get(Calendar.YEAR);
		int theWeek = calendar.get(Calendar.WEEK_OF_YEAR);
		return nowYear==theYear && nowWeek==theWeek;
	}
	
	
	/** 
	* @Title: getFirstDateInMonth 
	* @Description: 获得这月 开始的时间
	* @return Date    返回类型 
	* @throws 
	*/
	public static Date getFirstDateInMonth(Date theDate){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(theDate);
		calendar.set(Calendar.DAY_OF_MONTH,1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}
	
	/** 
	* @Title: getLastDateInMonth 
	* @Description: 获得日期的最后一天
	* @return Date    返回类型 
	* @throws 
	*/
	public static Date getLastDateInMonth(Date theDate) {
		Calendar c = Calendar.getInstance();
		c.setTime(theDate);
		c.add(Calendar.MONTH, 1);
		Date firstDateInMonth = getFirstDateInMonth(c.getTime());
		c.setTime(firstDateInMonth);
		c.add(Calendar.SECOND, -1);
		return c.getTime();
	}
	
	/** 
	* @Title: compareTime 
	* @Description: 两个时间比较 相等返回0 大于返回1 小于返回-1 
	* @return int    返回类型 
	* @throws 
	*/
	public static int compareTime(Date date1,Date date2) {
		long time1 = date1.getTime();
		long time2 = date2.getTime();
		if(time1==time2) {
			return 0;
		}
		if(time1>time2) {
			return 1;
		}
		return -1;
	}
}
