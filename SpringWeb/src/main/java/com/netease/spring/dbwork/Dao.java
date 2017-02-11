package com.netease.spring.dbwork;

public interface Dao {
	
	void transferMoney(Long srcUserId, Long targetUserId, double count);
}
