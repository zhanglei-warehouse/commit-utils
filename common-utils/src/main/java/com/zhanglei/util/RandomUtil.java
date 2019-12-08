package com.zhanglei.util;

import java.util.Random;

/** 
* @author Name: zhanglei
* @version Time：2019年12月8日 下午7:40:06 
* 类说明 
*/
public class RandomUtil {

	
	/** 
	* @Title: random 
	* @Description: 获得最小数与最大数之间的随机数 
	* @return int    返回类型 
	* @throws 
	*/
	public static int random(int min,int max) {
		Random random = new Random();
		return min+random.nextInt(max-min+1);
	}
	
	/** 
	* @Title: random 
	* @Description: 获得最小数与最大数之间的多个随机树
	* @return int[]    返回类型 
	* @throws 
	*/
	public static int[] random(int min,int max,int num) {
		int[] intArray = new int[num];
		for (int i = 0; i < num; i++) {
			intArray[i] = random(min, max);
		}
		return intArray;
	}
}
