package com.netease.usemybatis;
import org.apache.ibatis.annotations.*;
public interface GetUserInfoAnnotation {
@Select("select * from user where uid=#{uid}")
public User getUser(int uid);
}
