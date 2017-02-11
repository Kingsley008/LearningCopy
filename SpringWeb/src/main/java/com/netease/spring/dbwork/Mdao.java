package com.netease.spring.dbwork;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface Mdao {

	List<Account> getAccount ();

	void update(Account ac);

	public Account getId(long id);

	public void transferByMybatis(Long srcUserId, Long targetUserId, double count);
}