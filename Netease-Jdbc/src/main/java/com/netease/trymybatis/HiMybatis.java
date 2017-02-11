package com.netease.trymybatis;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class HiMybatis {

	public static void main(String[] args) {
		    //1.声明 配置文件的目录读取
				String resource = "conftry.xml";
			//2. 加载应用配置文件
				InputStream is = HiMybatis.class.getClassLoader().getResourceAsStream(resource);
			//3.创建sqlSessionFactory 
				SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
			//4.获取Session  开启自动提交 默认事务提交
				SqlSession session = sessionFactory.openSession(true);
			try {
				//5. 获取操作类(自己定义的接口)
				Op op = session.getMapper(Op.class);
				//6. 得到映射
				User user = op.getUser(1);
				
				//7.完成查询 
				System.out.println(user.getUserName()+" "+user.getTel());
                System.out.println(user.getProduct().get(0).getProductName());	
                System.out.println(user.getProduct().get(1).getProductName());
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				session.close();
			}

	}

}
