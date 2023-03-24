package com.akicat.noteshareremake.service;


import com.akicat.noteshareremake.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 用户Service层接口
 */
public interface UserService {
	// 通过账号和密码查询用户
	public User getCheckUser(String username, String password);
	public int addUser(User user);
	public User getUserFromUserId(@Param("user_id")int id);
	public int updateUserInfo(User user);

	public int updateUserPass(User user);

}
