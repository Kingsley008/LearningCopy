package com.netease.spring.mybatis;

public interface TransferService {
	public void transferByMybatis(Long srcUserId, Long targetUserId, double count);
	public void showMoney ();
}
