package com.netease.spring.mybatis;


public interface transferMoneyDao {
	void transferMoney(Long srcUserId, Long targetUserId, double count);

}
