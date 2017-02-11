package com.netease.work.servicei.mpl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public boolean addBlog(String title,String content){
		
		
		boolean b =false;
		int i=this.jdbcTemplate.update("insert into Blog(blogId,blogTitle,blogContent) values(null,?,?)", title,content);
		if (i==1){
			b=true;
		}
		return b;
	}
	
   public boolean checkBlog(String title,String content){
	   boolean b = false;
	   int titleCount = 0;
	   int contentCount = 0;
	   for(int i=0;i<title.length();i++){
		   titleCount++;
	   }
	   for(int i=0;i<content.length();i++){
		   contentCount++;
	   }
	   
	   System.out.println("Title"+titleCount+" Content"+contentCount);
	   
	   if(titleCount>20||contentCount>100){
		   
	   }else{
		   b=true;
	   }
	   
	   return b;
   }
}
