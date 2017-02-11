package com.netease.spring.mybatis;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;



@Repository
public class AccountImp extends SqlSessionDaoSupport implements AccountDao {
	@Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

	//和配置文件的namespace对应
	private static final String NAMESPACE="AccountMapper.";

	
	@Override
	public List<Account> getAccount() {
		//和mapper的Id对应
		return getSqlSession().selectList(NAMESPACE+"getAccount");
	}

	@Override
	public void update(Account ac) {
		getSqlSession().update(NAMESPACE+"update", ac);
		
	}

	@Override
	public Account getId(long id) {
		
		return getSqlSession().selectOne(NAMESPACE+"getId", id);
	}

}
