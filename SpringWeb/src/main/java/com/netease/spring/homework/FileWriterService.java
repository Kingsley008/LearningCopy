package com.netease.spring.homework;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;
@Component("FileWriterService")
public class FileWriterService implements Service {
	String url ;
	
 public FileWriterService(String url) {
	
		this.url = url;
	}
PrintWriter pw = null;
 
@PostConstruct
public void init (){

	try {
		pw = new PrintWriter( 
				new BufferedWriter( 
					new OutputStreamWriter(
						new FileOutputStream(url))));
		
	System.out.println("初始化对象时得到需要写入的文件路径");	
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
 }

@Override
public void write(String message) {
	pw.write(message);
}

@PreDestroy
public void destory(){
	System.out.println("回调关闭资源");
	pw.close();
}

}
