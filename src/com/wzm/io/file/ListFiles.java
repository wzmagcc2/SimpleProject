package com.wzm.io.file;

import java.io.File;

import org.junit.Test;

/**
 * �����ļ�ϵͳ���ƶ�Ŀ¼�����е��ļ��к��ļ���
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
			System.out.println("�ļ���"+dir.getName());
			return;
		}else {//�������Ҫ�����ļ��У�����elseɾ������
			System.out.println("Ŀ¼��"+dir.getName());
		}
		for(File file:dir.listFiles()) {
			listAllFiles(file);//�ݹ�
		}
	}
}
