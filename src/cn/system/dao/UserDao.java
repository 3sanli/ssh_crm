package cn.system.dao;

import cn.system.domain.User;

public interface UserDao {

	User getUserByCode(String user_code);

}
