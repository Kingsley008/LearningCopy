package com.netease.spring.aop;

public class UserManagerImp {
    private String username;
     
	public boolean addUser(String username,String password){
		System.out.println("add a user: username="+username+"password="+password);
		return true;
	}


	public boolean  delUser(int userId) {
		System.out.println("delete a user: userId="+userId );
		
		return true;
	}
	
	public boolean findUserById(int userId){
        System.out.println("find a user: userId="+userId );
		
		return true;
	}
	public boolean updateUser(String password){
		System.out.println("update a user: username="+username+"password="+password);
		return true;
	}
}
