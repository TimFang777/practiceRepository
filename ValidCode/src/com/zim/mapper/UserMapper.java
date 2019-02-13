package com.zim.mapper;

import org.apache.ibatis.annotations.Select;

import com.zim.pojo.Users;

public interface UserMapper {
	@Select("select * from users where username=#{username} and password=#{password}")
	Users selByUsersPwd(Users users);
}
