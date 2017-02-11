package com.netease.usemybatis;

public interface UserOp {
  public void addUser (User user);
  public void updateUser(User user);
  public void deleteUser(int uid);
  public User getUser(int uid);
  
}
