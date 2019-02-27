/**
 * 2019年2月18日上午10:57:08
 * Demo
 * @author deng.limeng
 */
package com.dlm.demo.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author deng.limeng 2019年2月18日上午10:57:08 Demo
 */
public class Demo {

	public static void main(String[] args) throws Exception {

		ArrayList<String> list = new ArrayList<String>();
		FileUtil.getAllFilesInPath("D:\\source\\java\\workspace\\cu-edu\\WebContent\\studentarchives\\alienChange\\js", list);
		for (String string : list) {
			File f = new File(string);
			Calendar calendar = Calendar.getInstance();
			long time = f.lastModified();
			calendar.setTimeInMillis(time);
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()));
		}

	}
}
