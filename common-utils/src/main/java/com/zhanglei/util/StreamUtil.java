package com.zhanglei.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/** 
* @author Name: zhanglei
* @version Time：2019年12月5日 下午2:55:34 
* 类说明 
* 
* 流工具类
*/
public class StreamUtil {
	
	/** 
	* @Title: closeAll 
	* @Description: 关闭流的方法
	* @return void    返回类型 
	* @throws 
	*/
	public static void closeAll(AutoCloseable...autoCloseables){
		if(autoCloseables!=null){
			for(AutoCloseable autoCloseable:autoCloseables){
				try {
					autoCloseable.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	/** 
	* @Title: readTextFile 
	* @Description: 使用流 读取文本内容
	* @return String    返回类型 
	* @throws 
	*/
	public static String readTextFile(File file){
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			byte[] b = new byte[1024];
			String string = null;
			while(inputStream.read(b)!=-1){
				string +=new String(b);
			}
			return string;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(inputStream);
		}
		
		return "";
	}
	/** 
	* @Title: readTestFile 
	* @Description: 根据文件全名读取文件内容 
	* @return String    返回类型 
	* @throws 
	*/
	public static String readTextFile(String fileFullName){
		return readTextFile(new File(fileFullName));
	}
}
