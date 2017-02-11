package com.netease.usemybatis;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class HelloMyBatis {

	public static void main(String[] args) {
	//1.声明 配置文件的目录读取
		String resource = "conf.xml";
	//2. 加载应用配置文件
		InputStream is = HelloMyBatis.class.getClassLoader().getResourceAsStream(resource);
	//3.创建sqlSessionFactory 
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
	//4.获取Session  开启自动提交 默认事务提交
		SqlSession session = sessionFactory.openSession(true);
	try {
		//5. 获取操作类(自己定义的接口)
		UserOp userop = session.getMapper(UserOp.class);
		//6. 得到映射
		User user = userop.getUser(1);
		//7.完成查询 
		System.out.println(user.getUsername()+" "+user.getPassword());
		//插入用户
		User useradd= new User(5,"XiaoMing","12345");
		userop.addUser(useradd);
		System.out.println(useradd.getUid());
		//更新
		 useradd.setUsername("LiMing");
		 userop.updateUser(useradd);
		//删除
		 userop.deleteUser(useradd.getUid());
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		session.close();
	}

	}

}
