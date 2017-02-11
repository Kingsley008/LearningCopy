package com.netease.work.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.netease.work.meta.User;

public interface Userdao {
	
	@Results({
		   @Result(property="id", column="id"),
		   @Result(property="firstname", column="first_name"),
		   @Result(property="lastname", column="last_name"),
		}
				)
	@Select("select * from user2")
	
	List <User> getUserList(); 
  
}
