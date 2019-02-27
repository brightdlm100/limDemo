package com.dlm.demo.socket;

import com.dlm.demo.file.FileUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerDemo {

	/**
	 * Socket服务端
	 *
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		try {
			ServerSocket serverSocket = new ServerSocket(8888);
			System.out.println("服务端已启动，等待客户端连接..");
			Socket socket = serverSocket.accept();// 侦听并接受到此套接字的连接,返回一个Socket对象
			String webPath = "D:\\source\\java\\workspace\\cu-edu"; //
			String dbPath = "D:\\source\\java\\workspace\\13.Code Management\\Trunk\\db";
			String demoPath = "D:\\source\\java\\workspace\\demo";
			String javaPath = "D:\\source\\java\\workspace\\gtafe-edu";
			List<String> totalList = new ArrayList<String>();
			totalList.add(demoPath);
			totalList.add(dbPath);
			totalList.add(webPath);
			totalList.add(javaPath);
			// 根据输入输出流和客户端连接
			InputStream inputStream = socket.getInputStream();// 得到一个输入流，接收客户端传递的信息
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);// 提高效率，将自己字节流转为字符流
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);// 加入缓冲区
			String temp = null;
			OutputStream outputStream = socket.getOutputStream();// 获取一个输出流，向服务端发送信息
			PrintWriter printWriter = new PrintWriter(outputStream);// 将输出流包装成打印流
			ArrayList<String> filenames = new ArrayList<String>();
			int size = filenames.size();
			String receive = null;
			int flag = 1;
			for (String s : totalList) {
				filenames.clear();
				FileUtil.getAllFilesInPath(s, filenames);
				System.out.println("-----开始发送-------");
				for (String fileName : filenames) {
					flag = 1;
					writeContent(printWriter, "fileName," + fileName + "," + new File(fileName).lastModified());
					while ((receive = bufferedReader.readLine()) != null) {
						// System.out.println("收到客户端信息：" + receive);
						if (receive.equals("跳过")) {
							size--;
							// System.out.println("跳过");
							flag = 0;
							break;
						}
						break;
					}
					if (flag == 1) {
						// System.out.println("-----开始发送:" + fileName);
						BufferedReader bReader = new BufferedReader(new FileReader(new File(fileName)));
						while ((temp = bReader.readLine()) != null) {
							writeContent(printWriter, temp);
						}
						writeContent(printWriter, "fileEnd");

						while ((receive = bufferedReader.readLine()) != null) {
							if (receive.contains("完成")) {
								size--;
								System.out.println(size);
								break;
							}
						}
						bReader.close();
						System.out.println("-----" + fileName + "----发送完成！");
					}
				}

				System.out.println(s + "发送成功！");
			}

			socket.shutdownOutput();// 关闭输出流

			// 关闭相对应的资源
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			printWriter.close();
			outputStream.close();

			socket.close();

			System.out.println("完成所有任务！");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeContent(PrintWriter pw, String s) {
		pw.println(s);
		pw.flush();
	}

}
