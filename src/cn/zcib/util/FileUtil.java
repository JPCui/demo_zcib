package cn.zcib.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
	/**
	 * 文件保存
	 * @param file 文件，用以获取文件内容
	 * @param path 全路径：realPath + fileName，用以保存文件的路径及文件名
	 * @param del 原文件是否删除
	 * @throws IOException
	 */
	public static boolean save(File file,String path,boolean delete)
	{
		try {
			FileInputStream fis;
			fis = new FileInputStream(file);
			FileOutputStream fos = new FileOutputStream(path);
			byte[] buf = new byte[1024];
			int length = 0;
			while ((length = fis.read(buf)) != -1) {
				fos.write(buf, 0, length);
			}
			fis.close();
			fos.flush();
			fos.close();
//        if(delete) file.delete();//老是出错
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
