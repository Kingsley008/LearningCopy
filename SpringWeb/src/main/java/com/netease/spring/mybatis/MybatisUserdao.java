package com.netease.spring.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;


public interface MybatisUserdao {
	@Results({
		   @Result(property="id", column="id"),
		   @Result(property="first_name", column="first_name"),
		   @Result(property="last_name", column="last_name"),
		})
	@Select("select * from user2 where first_name = #{first_name}")
	public Userbean getUser(String first_name);
	@Results({
		   @Result(property="id", column="id"),
		   @Result(property="first_name", column="first_name"),
		   @Result(property="last_name", column="last_name"),
		}
				)
	@Select("select * from user2")
	public List <Userbean> getUserList();
}
