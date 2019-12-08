package com.zhanglei.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** 
* @author Name: zhanglei
* @version Time：2019年12月6日 下午7:24:07 
* 类说明 
* 文件工具类
*/
public class FileUtil {
	/** 
	* @Title: getExtName 
	* @Description: 获取文件的扩展名 
	* @return String    返回类型 
	* @throws 
	*/
	public static String getExtName(String fileName){
		if(fileName==null || fileName.equals("")){
			throw new RuntimeException("文件名不能为空");
		}
		if(fileName.indexOf(".")<=-1){
			throw new RuntimeException("该文将没有扩展名");
		}
		String substring = fileName.substring(fileName.lastIndexOf("."));
		return substring;
	}
	
	/** 
	* @Title: getSystemUserHome 
	* @Description: 获取系统当前用户 
	* @return String    返回类型 
	* @throws 
	*/
	public static String getSystemUserHome(){
		return System.getProperty("user.home");
	}
	
	/** 
	* @Title: getSystemTempDirectory 
	* @Description: 操作系统临时目录 
	* @return String    返回类型 
	* @throws 
	*/
	public static String getSystemTempDirectory() {
		return System.getProperty("java.io.tmpdir");
	}
	
	/** 
	* @Title: readTextFileByLine 
	* @Description: 读取文件内容
	* @return String    返回类型 
	* @throws 
	*/
	public static String readTextFileByLine(String pathname) {
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		try {
			br = new BufferedReader(new FileReader(new File(pathname)));
			do {
				sb.append(br.readLine());
				sb.append("\r\n");
			}while(br.read()!=-1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}finally {
			StreamUtil.closeAll(br);
		}
		return sb.toString();
	}
	
	/** 
	* @Title: readTextFileOfList 
	* @Description: 按行读取文件内容到list集合
	* @return List<String>    返回类型 
	* @throws 
	*/
	public static List<String> readTextFileOfList(String pathname) {
		BufferedReader br = null;
		List<String> strList = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(new File(pathname)));
			do {
				strList.add(br.readLine());
			}while(br.read()!=-1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}finally {
			StreamUtil.closeAll(br);
		}
		return strList;
	}
	
	/** 
	* @Title: deleteFile 
	* @Description: 递归删除文件
	* @return void    返回类型 
	* @throws 
	*/
	public static void deleteFile(File file) {
		if(file.isDirectory()) {
			File[] listFiles = file.listFiles();
			for(File theFile:listFiles) {
				deleteFile(theFile);
			}
			file.delete();
		}else {
			file.delete();
		}
	}
	
	/** 
	* @Title: deleteFile 
	* @Description: 递归删除文件
	* @return void    返回类型 
	* @throws 
	*/
	public static void deleteFile(String filePath) {
		deleteFile(new File(filePath));
	}
	
	/** 
	* @Title: getFileSize 
	* @Description: 获取文件大小) 
	* @return String    返回类型 
	* @throws 
	*/
	public static String getFileSize(File file) {
		long length = file.length();
		double len = length/1024.0;
//		return Math.round((length/1024.0))+"kb";
		return String.format("%.2f",len)+"kb";
	}
	
	/** 
	* @Title: getFileSize 
	* @Description: 获取文件大小 
	* @return String    返回类型 
	* @throws 
	*/
	public static String getFileSize(String fileFullName) {
		return getFileSize(new File(fileFullName));
	}
}
