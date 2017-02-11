package com.netease.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
//注释的方法声明这是一个DAO
@Repository("JdbcTemplateDao")
public class JdbcTemplateDao {
	
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void createTable(){
		jdbcTemplate.execute("create table account (id integer,first_name varchar(100),last_name varchar(100))");
	}
	
	public void insertDate(){
		this.jdbcTemplate.update("insert into user2 values(1,?,?)","Kingsley","Wang");
		this.jdbcTemplate.update("insert into user2 values(2,?,?)","john","Lee");
	}
	public int count(){
		
		return this.jdbcTemplate.queryForObject("select count(*) from user2", Integer.class);
	}
	public List<Userbean> getUserList(){
		return this.jdbcTemplate.query("select * from user2", new RowMapper<Userbean>(){
			public Userbean mapRow(ResultSet rs,int rowNum)throws SQLException{
				Userbean ub = new Userbean();
				ub.setId(rs.getInt("id"));
				ub.setFirst_name(rs.getString("first_name"));
				ub.setLast_name(rs.getString("last_name"));
				return ub;
				
			}
		});
	}
	public void setDataSource2 (DataSource dataSource){
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public int countOfUsersByFirstName(Userbean ub){
		String sql ="select count(*) from user2 where first_name=:first_name";
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(ub);
		return this.namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Integer.class);
		
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("jdbc-context.xml");
		
		JdbcTemplateDao dao = context.getBean("JdbcTemplateDao",JdbcTemplateDao.class);
		//dao.createTable();
		//dao.insertDate();
		
		System.out.println(dao.count());
		List<Userbean> userList = dao.getUserList();
		for(Userbean user: userList){
			System.out.println(user.getId()+" "+user.getFirst_name()+" "+user.getLast_name());
		//System.out.println(dao.countOfUsersByFirstName(user));
		}
	
	
		 ((ConfigurableApplicationContext)context).close();
        
	}

}
