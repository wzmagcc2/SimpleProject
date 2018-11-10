package com.wzm.io.file;

import java.io.File;

import org.junit.Test;

/**
 * 罗列文件系统下制定目录下所有的文件夹和文件名
 * @author WZMAGCC2
 *
 */
public class ListFiles {
	
	@Test
	public void testListFiles() {
		String filePath = "D:\\Images";
		File file = new File(filePath);
		ListFiles.listAllFiles(file);
	}

	
	private static void listAllFiles(File dir) {
		if(dir == null || !dir.exists()) 
			return;
		if(dir.isFile()) {
			System.out.println("文件："+dir.getName());
			return;
		}else {//如果不需要罗列文件夹，这里else删除即可
			System.out.println("目录："+dir.getName());
		}
		for(File file:dir.listFiles()) {
			listAllFiles(file);//递归
		}
	}
}
