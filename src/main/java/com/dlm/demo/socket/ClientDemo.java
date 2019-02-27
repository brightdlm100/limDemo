package com.dlm.demo.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class ClientDemo {

    /**
     * Socket客户端
     */
    public static void main(String[] args) {
        try {
            //创建Socket对象
            Socket socket=new Socket("192.168.22.119",8888);
            
            //根据输入输出流和服务端连接
            OutputStream outputStream=socket.getOutputStream();//获取一个输出流，向服务端发送信息
            PrintWriter printWriter=new PrintWriter(outputStream);//将输出流包装成打印流
            
                           
            InputStream inputStream=socket.getInputStream();//获取一个输入流，接收服务端的信息
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);//包装成字符流，提高效率
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);//缓冲区
            String temp=null;//临时变量
            File file=null;
            BufferedWriter bw=null;
            
            int i=0;
            int j=0;
            int flag=-1;
            while((temp=bufferedReader.readLine())!=null) {
            	//System.out.println(temp);
            	if((temp.split(",").length==3)&&(temp.split(",")[0].equals("fileName"))) {
            		file=new File(temp.split(",")[1].replace("D:","C:"));
            		File fileParent=file.getParentFile();
            		if(!fileParent.exists()) {
            			fileParent.mkdirs();
            		}
            		if(!file.exists()) {
                		file.createNewFile();
            		}
            		if(file.lastModified()>=Long.parseLong(temp.split(",")[2])) {
            			flag=0;
            			System.out.println("文件无改动，跳过:"+(++j));
                		writeContent(printWriter, "跳过");
            		}else {
            			flag=1;
                		writeContent(printWriter, "继续");
                		bw=new BufferedWriter(new FileWriter(file));
            		}
            		//System.out.println("处理后："+flag);
            	}else if(flag==1&&temp.equals("fileEnd")){
                	System.out.println(++i);
            		writeContent(printWriter, "完成："+file.getAbsolutePath());
            		bw.close();
            	}else if(flag==1) {
            		bw.write(temp);
            		bw.newLine();
            	}else {
            		continue;
            	}
            }
            System.out.println("完成！传输："+i+",跳过："+j);
            writeContent(printWriter, "完成");

            socket.shutdownOutput();//关闭输出流
            //关闭相对应的资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            printWriter.close();
            outputStream.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        } 

    }
    
    public static void writeContent(PrintWriter pw, String s) {
		pw.println(s);
		pw.flush();
	}

}