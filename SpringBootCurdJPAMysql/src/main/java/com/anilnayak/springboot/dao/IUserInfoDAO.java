package com.anilnayak.springboot.dao;

import com.anilnayak.springboot.model.UserInfo;

public interface IUserInfoDAO {
	UserInfo getActiveUser(String userName);
}