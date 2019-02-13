package com.zim.service.impl;

import com.zim.mapper.UserMapper;
import com.zim.pojo.Users;
import com.zim.service.UserService;

public class UserServiceImpl implements UserService{
	private UserMapper userMapper;
	@Override
	public Users login(Users users) {
		return userMapper.selByUsersPwd(users);
	}
	public UserMapper getUserMapper() {
		return userMapper;
	}
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

}
