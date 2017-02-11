package com.netease.work.servicei.mpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.netease.work.meta.Userlg;

@Service
public class CheckLogin {
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public boolean checkuser(String username,String password){
		boolean b = false;
		
		String sql ="select * from User where userName=? and userPassword=?";
		this.jdbcTemplate.queryForList(sql, username,password);	
		// 执行查询,将动态参数放到object 数组里
		List <Userlg> userlgs = this.jdbcTemplate.query(sql, new Object[]{username,password}
		,new RowMapper<Userlg>(){

			@Override
			public Userlg mapRow(ResultSet rs, int rowNum) throws SQLException {
				Userlg userlg = new Userlg();
				userlg.setId(rs.getInt("userId"));
				userlg.setName(rs.getString("userName"));
				userlg.setPassword(rs.getString("userPassword"));
				return userlg;
			}
		});
		//定义返回值
		Userlg u = null;
		// 判断集合对象是否为null 并且长度大于0
		if(userlgs !=null && userlgs.size()>0){
			u = userlgs.get(0);
			b = true;
		}
				
		return b;
	}

}
