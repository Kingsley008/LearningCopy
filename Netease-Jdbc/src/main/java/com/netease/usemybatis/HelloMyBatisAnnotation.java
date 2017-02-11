package com.netease.usemybatis;

import java.io.InputStream;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class HelloMyBatisAnnotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.声明 配置文件的目录读取
				String resource = "confAnnotation.xml";
			//2. 加载应用配置文件
				InputStream is = HelloMyBatisAnnotation.class.getClassLoader().getResourceAsStream(resource);
			//3.创建sqlSessionFactory 
				SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
				//API增加映射关系
				Configuration conf = sessionFactory.getConfiguration();
				conf.addMapper(GetUserInfoAnnotation.class);
			//4.获取Session 
				SqlSession session = sessionFactory.openSession();
			try {
				//5. 获取操作类(自己定义的接口)
				GetUserInfoAnnotation getUserInfo = session.getMapper(GetUserInfoAnnotation.class);
				//6. 得到映射
				User user = getUserInfo.getUser(1);
				//7.完成查询 
				System.out.println(user.getUsername()+" "+user.getPassword());
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				session.close();
			}     
	}

}
