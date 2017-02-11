package com.netease.spring.mybatis;

import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface AccountDao {
	@Results({
		   @Result(property="id", column="userId"),
		   @Result(property="balance", column="balance"),
		})
	@Select("select * from account2")
	List<Account> getAccount ();
	@Results({
		   @Result(property="id", column="userId"),
		   @Result(property="balance", column="balance"),
		})
	@Update("update account2 set balance = #{balance} where userId=#{id}")
	  void update(Account ac);
	@Results({
		   @Result(property="id", column="userId"),
		   @Result(property="balance", column="balance"),
		})
	@Select("select * from account2 where userId =#{id}")
	  public Account getId(long id);

}
