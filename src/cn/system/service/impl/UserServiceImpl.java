package cn.system.service.impl;

import javax.annotation.Resource;

import cn.system.dao.UserDao;
import cn.system.domain.User;
import cn.system.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao ud;

	@Override
	public User getUser(User u) {
		User user = ud.getUserByCode(u.getUser_code());
		
		return user;
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}
	
}
