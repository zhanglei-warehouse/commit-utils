package com.zhanglei.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


/** 
* @author Name: zhanglei
* @version Time：2019年12月6日 下午7:24:07 
* 类说明 
* 文件工具类
*/
public class FileUtil {
	/***
	 * @Title: writeFile * @Description: 按照指定的编码把内容写入指定的文件中 * @param path * @param
	 *         content * @param charset * @throws IOException * @return: void
	 */
	public static void writeFile(String path, String content, String charset) throws IOException {
		// 创建写入的文件
		File file = new File(path);
		// 创建输出流对象
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset));
		bw.write(content);
		bw.flush();
		bw.close();

	}
	
	
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
			String str = null;
			while((str=br.readLine())!=null){
				strList.add(str);
			}
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
	public static List<String> readFileUrl(String file){
		File file2 = new File(file);
		return readFileUrl(file2);
	}
	//读取文件夹中的文件路径
	public static List<String> readFileUrl(File file) {
		List<String> list = new ArrayList<String>();
		if(file.isDirectory()) {
			File[] listFiles = file.listFiles();
			//循环获取文件路径
			for (File file2 : listFiles) {
				//使用文件路径读取文件
				String readTextFileByLine = readTextFileByLine(file2.toString());
				//截取文件名
				String[] split = file2.toString().split("\\\\");
				//添加到集合中
				list.add(split[2]+"@@"+readTextFileByLine);
			}
		}
		return list;
		
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
	public static void main(String[] args) {
		List<String> readTextFileOfList = readTextFileOfList("C:\\Users\\zhanglei\\Desktop\\第二周复习\\10zk2\\pom.xml");
		for (String string : readTextFileOfList) {
			System.out.println(string);
		}
	}
	//读取文件夹中内容 
	
	
}
